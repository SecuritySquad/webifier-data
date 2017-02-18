package de.securitysquad.webifier.core.service;

import de.securitysquad.webifier.web.domain.request.WebifierTestResultDataRequest;
import de.securitysquad.webifier.web.domain.response.WebifierTestResultDataResponse;

/**
 * Created by samuel on 18.02.17.
 */
public interface WebifierTestResultDataService {
    WebifierTestResultDataResponse pushTestResultDataRequest(WebifierTestResultDataRequest data);
}
