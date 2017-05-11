package de.securitysquad.webifier.persistence.handler;

import de.securitysquad.webifier.persistence.domain.WebifierTestResultData;
import de.securitysquad.webifier.persistence.repository.WebifierSingleTestResultDataRepository;
import de.securitysquad.webifier.persistence.repository.WebifierTestResultDataRepository;
import de.securitysquad.webifier.persistence.service.WebifierTestResultDataPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.ofNullable;

/**
 * Created by samuel on 15.10.15.
 */
@Component
public class WebifierTestResultDataPersistenceHandler implements WebifierTestResultDataPersistenceService {
    private final WebifierTestResultDataRepository testRepository;
    private final WebifierSingleTestResultDataRepository singleTestRepository;

    @Autowired
    public WebifierTestResultDataPersistenceHandler(WebifierTestResultDataRepository testRepository, WebifierSingleTestResultDataRepository singleTestRepository) {
        this.testRepository = testRepository;
        this.singleTestRepository = singleTestRepository;
    }

    @Override
    public Optional<WebifierTestResultData> saveTestResultData(WebifierTestResultData data) {
        if (data.getId() == null) {
            data.setId(UUID.randomUUID().toString());
        }
        data.getTestResults().forEach(result -> {
            if (result.getId() == null) {
                result.setId(UUID.randomUUID().toString());
            }
            if (result.getOverallResult() == null) {
                result.setOverallResult(data);
            }
        });
        singleTestRepository.save(data.getTestResults());
        WebifierTestResultData savedData = testRepository.save(data);
        return ofNullable(savedData);
    }

    @Override
    public List<WebifierTestResultData> getTestResultDataByHost(String host) {
        return testRepository.findByHostContainingIgnoreCase(host);
    }

    @Override
    public long getTestResultsCount() {
        return testRepository.count();
    }

    @Override
    public List<WebifierTestResultData> getTestResultDataPage(int page, int size) {
        return testRepository.findAll(new PageRequest(page, size)).getContent();
    }


    @Override
    public int getTestResultDataPageSize(int size) {
        return (int) (testRepository.count() / size) + 1;
    }
}