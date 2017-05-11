package de.securitysquad.webifier.core.handler;

import de.securitysquad.webifier.core.service.WebifierTestResultDataService;
import de.securitysquad.webifier.persistence.domain.WebifierSingleTestResultData;
import de.securitysquad.webifier.persistence.domain.WebifierTestResult;
import de.securitysquad.webifier.persistence.domain.WebifierTestResultData;
import de.securitysquad.webifier.persistence.service.WebifierTestResultDataPersistenceService;
import de.securitysquad.webifier.web.domain.details.WebifierSingleTestDetails;
import de.securitysquad.webifier.web.domain.details.WebifierTestResultDetails;
import de.securitysquad.webifier.web.domain.request.WebifierCheckTestResultsRequest;
import de.securitysquad.webifier.web.domain.request.WebifierPushTestResultDataRequest;
import de.securitysquad.webifier.web.domain.response.WebifierCheckTestResultsResponse;
import de.securitysquad.webifier.web.domain.response.WebifierPushTestResultDataResponse;
import de.securitysquad.webifier.web.domain.response.WebifierTestResultsCountResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by samuel on 18.02.17.
 */
@Component
public class WebifierTestResultDataHandler implements WebifierTestResultDataService {
    private final WebifierTestResultDataPersistenceService dataPersistenceService;

    @Autowired
    public WebifierTestResultDataHandler(WebifierTestResultDataPersistenceService dataPersistenceService) {
        this.dataPersistenceService = dataPersistenceService;
    }

    @Override
    public WebifierPushTestResultDataResponse pushTestResultDataRequest(WebifierPushTestResultDataRequest dataRequest) {
        try {
            WebifierTestResultData data = mapRequest(dataRequest);
            Optional<WebifierTestResultData> savedData = dataPersistenceService.saveTestResultData(data);
            Runtime.getRuntime().gc();
            return new WebifierPushTestResultDataResponse(savedData.isPresent());
        } catch (MalformedURLException e) {
            return new WebifierPushTestResultDataResponse(false);
        }
    }

    @Override
    public WebifierCheckTestResultsResponse checkTestResultsRequest(WebifierCheckTestResultsRequest request) {
        List<String> hosts = request.getUrls().stream().map(url -> {
            try {
                return filterHost(url);
            } catch (MalformedURLException e) {
                return null;
            }
        }).distinct().filter(StringUtils::isNotEmpty).collect(toList());
        Map<String, WebifierTestResultDetails> hostResults = new HashMap<>();
        hosts.forEach(host -> {
            List<WebifierTestResultData> data = dataPersistenceService.getTestResultDataByHost(host)
                    .stream().filter(d -> d.getOverallResultType() != WebifierTestResult.UNDEFINED).collect(toList());
            if (data.isEmpty()) {
                hostResults.put(host, WebifierTestResultDetails.UNDEFINED);
            } else {
                double resultValue = data.stream().mapToDouble(this::mapDataResultToIndex).average().orElse(1);
                hostResults.put(host, mapResultValueToResult(resultValue));
            }
        });
        Runtime.getRuntime().gc();
        if (hostResults.isEmpty()) {
            return new WebifierCheckTestResultsResponse(false);
        }
        return new WebifierCheckTestResultsResponse(true, hostResults);
    }

    @Override
    public WebifierTestResultsCountResponse countTestResultsRequest() {
        return new WebifierTestResultsCountResponse(dataPersistenceService.getTestResultsCount());
    }

    @Override
    public String update() {
        int pageSize = 10000;
        int pages = dataPersistenceService.getTestResultDataPageSize(pageSize);
        System.out.println("Update " + pages + " pages with " + pageSize + " entries per page:");
        for (int i = 0; i < pages; i++) {
            System.out.println("Updating page " + (i + 1) + " of " + pages);
            dataPersistenceService.getTestResultDataPage(i, pageSize).forEach(dataPersistenceService::saveTestResultData);
        }
        System.out.println("Done!");
        return "Done";
    }

    private double mapDataResultToIndex(WebifierTestResultData data) {
        switch (data.getOverallResultType()) {
            case CLEAN:
                return 0;
            case SUSPICIOUS:
                return 0.3;
            default:
                return 1;
        }
    }

    private WebifierTestResultDetails mapResultValueToResult(double result) {
        if (result >= 0.5) {
            return WebifierTestResultDetails.MALICIOUS;
        }
        if (result >= 0.1) {
            return WebifierTestResultDetails.SUSPICIOUS;
        }
        return WebifierTestResultDetails.CLEAN;
    }

    private WebifierTestResultData mapRequest(WebifierPushTestResultDataRequest request) throws MalformedURLException {
        WebifierTestResultData data = new WebifierTestResultData();
        data.setTesterId(request.getId());
        data.setEnteredUrl(request.getEnteredUrl());
        data.setTestedUrl(request.getTestedUrl());
        data.setHost(filterHost(request.getTestedUrl()));
        data.setOverallResultType(mapResultType(request.getResult().getResultType()));
        data.setOverallResultValue(request.getResult().getResultValue());
        data.setDurationInMillis(request.getDuration());
        data.setDatetime(new Date());
        data.setTestResults(request.getTestResults().stream().map(this::mapSingleTestResults).collect(toList()));
        return data;
    }

    private WebifierSingleTestResultData mapSingleTestResults(WebifierSingleTestDetails request) {
        WebifierSingleTestResultData data = new WebifierSingleTestResultData();
        data.setTestId(request.getTestId());
        data.setName(request.getTestData().getName());
        data.setStartup(request.getTestData().getStartup());
        data.setShutdown(request.getTestData().getShutdown());
        data.setEnabled(request.getTestData().isEnabled());
        data.setWeight(request.getTestData().getWeight());
        data.setStartupTimeoutInSeconds(request.getTestData().getStartupTimeoutInSeconds());
        data.setShutdownTimeoutInSeconds(request.getTestData().getShutdownTimeoutInSeconds());
        data.setResult(mapResultType(request.getResult().getResult()));
        data.setResultInfo(request.getResult().getInfo());
        data.setDurationInMillis(request.getDuration());
        return data;
    }

    private WebifierTestResult mapResultType(WebifierTestResultDetails resultType) {
        return WebifierTestResult.valueOf(resultType.name());
    }

    private String filterHost(String url) throws MalformedURLException {
        return new URL(url).getHost();
    }
}
