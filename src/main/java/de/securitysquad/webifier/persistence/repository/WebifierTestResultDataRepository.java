package de.securitysquad.webifier.persistence.repository;

import de.securitysquad.webifier.persistence.domain.WebifierTestResultData;
import org.springframework.data.repository.CrudRepository;

public interface WebifierTestResultDataRepository extends CrudRepository<WebifierTestResultData, String> {
    WebifierTestResultData findByHostIgnoreCase(String host);
}