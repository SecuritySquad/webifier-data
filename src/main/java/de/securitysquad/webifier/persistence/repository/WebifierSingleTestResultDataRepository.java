package de.securitysquad.webifier.persistence.repository;

import de.securitysquad.webifier.persistence.domain.WebifierSingleTestResultData;
import org.springframework.data.repository.CrudRepository;

public interface WebifierSingleTestResultDataRepository extends CrudRepository<WebifierSingleTestResultData, String> {
}