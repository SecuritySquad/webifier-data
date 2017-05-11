package de.securitysquad.webifier.core.service;

import de.securitysquad.webifier.web.domain.request.WebifierCheckTestResultsRequest;
import de.securitysquad.webifier.web.domain.request.WebifierPushTestResultDataRequest;
import de.securitysquad.webifier.web.domain.response.WebifierCheckTestResultsResponse;
import de.securitysquad.webifier.web.domain.response.WebifierPushTestResultDataResponse;
import de.securitysquad.webifier.web.domain.response.WebifierTestResultsCountResponse;

/**
 * Created by samuel on 18.02.17.
 */
public interface WebifierTestResultDataService {
    WebifierPushTestResultDataResponse pushTestResultDataRequest(WebifierPushTestResultDataRequest data);

    WebifierCheckTestResultsResponse checkTestResultsRequest(WebifierCheckTestResultsRequest request);

    WebifierTestResultsCountResponse countTestResultsRequest();
}
