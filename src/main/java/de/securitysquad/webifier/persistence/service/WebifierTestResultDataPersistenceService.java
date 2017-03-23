package de.securitysquad.webifier.persistence.service;

import de.securitysquad.webifier.persistence.domain.WebifierTestResultData;

import java.util.List;
import java.util.Optional;

/**
 * Created by samuel on 18.02.17.
 */
public interface WebifierTestResultDataPersistenceService {
    Optional<WebifierTestResultData> saveTestResultData(WebifierTestResultData data);

    List<WebifierTestResultData> getTestResultDataByHost(String host);

    long getTestResultsCount();
}