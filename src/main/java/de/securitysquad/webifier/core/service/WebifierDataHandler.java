package de.securitysquad.webifier.core.service;

import de.securitysquad.webifier.web.domain.request.WebifierTestResultDataRequest;
import de.securitysquad.webifier.web.domain.response.WebifierTestResultDataResponse;
import org.springframework.stereotype.Component;

/**
 * Created by samuel on 18.02.17.
 */
@Component
public class WebifierDataHandler implements WebifierDataService {
    @Override
    public WebifierTestResultDataResponse pushTestResultDataRequest(WebifierTestResultDataRequest data) {
        return new WebifierTestResultDataResponse(true);
    }
}
