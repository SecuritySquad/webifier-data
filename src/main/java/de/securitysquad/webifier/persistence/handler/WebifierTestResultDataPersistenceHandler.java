package de.securitysquad.webifier.persistence.handler;

import de.securitysquad.webifier.persistence.domain.WebifierTestResultData;
import de.securitysquad.webifier.persistence.repository.WebifierTestResultDataRepository;
import de.securitysquad.webifier.persistence.service.WebifierTestResultDataPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.ofNullable;

/**
 * Created by samuel on 15.10.15.
 */
@Component
public class WebifierTestResultDataPersistenceHandler implements WebifierTestResultDataPersistenceService {
    private final WebifierTestResultDataRepository dataRepository;

    @Autowired
    public WebifierTestResultDataPersistenceHandler(WebifierTestResultDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public Optional<WebifierTestResultData> saveTestResultData(WebifierTestResultData data) {
        if (data.getId() == null) {
            data.setId(UUID.randomUUID().toString());
        }
        WebifierTestResultData savedData = dataRepository.save(data);
        return ofNullable(savedData);
    }
}