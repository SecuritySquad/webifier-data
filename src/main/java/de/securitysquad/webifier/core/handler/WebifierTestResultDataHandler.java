package de.securitysquad.webifier.core.handler;

import de.securitysquad.webifier.core.service.WebifierTestResultDataService;
import de.securitysquad.webifier.persistence.domain.WebifierSingleTestResultData;
import de.securitysquad.webifier.persistence.domain.WebifierTestResult;
import de.securitysquad.webifier.persistence.domain.WebifierTestResultData;
import de.securitysquad.webifier.persistence.service.WebifierTestResultDataPersistenceService;
import de.securitysquad.webifier.web.domain.request.WebifierSingleTestRequest;
import de.securitysquad.webifier.web.domain.request.WebifierTestResultDataRequest;
import de.securitysquad.webifier.web.domain.request.WebifierTestResultRequest;
import de.securitysquad.webifier.web.domain.response.WebifierTestResultDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;

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
    public WebifierTestResultDataResponse pushTestResultDataRequest(WebifierTestResultDataRequest dataRequest) {
        try {
            WebifierTestResultData data = mapRequest(dataRequest);
            Optional<WebifierTestResultData> savedData = dataPersistenceService.saveTestResultData(data);
            return new WebifierTestResultDataResponse(savedData.isPresent());
        } catch (MalformedURLException e) {
            return new WebifierTestResultDataResponse(false);
        }
    }

    private WebifierTestResultData mapRequest(WebifierTestResultDataRequest request) throws MalformedURLException {
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

    private WebifierSingleTestResultData mapSingleTestResults(WebifierSingleTestRequest request) {
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

    private WebifierTestResult mapResultType(WebifierTestResultRequest resultType) {
        return WebifierTestResult.valueOf(resultType.name());
    }

    private String filterHost(String url) throws MalformedURLException {
        return new URL(url).getHost();
    }
}
