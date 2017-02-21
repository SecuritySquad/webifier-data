package de.securitysquad.webifier.persistence.repository;

import de.securitysquad.webifier.persistence.domain.WebifierTestResultData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WebifierTestResultDataRepository extends CrudRepository<WebifierTestResultData, String> {
    List<WebifierTestResultData> findByHostIgnoreCase(String host);
}