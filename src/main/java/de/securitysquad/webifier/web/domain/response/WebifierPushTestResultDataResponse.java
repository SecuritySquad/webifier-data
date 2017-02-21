package de.securitysquad.webifier.web.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by samuel on 17.02.17.
 */
public class WebifierPushTestResultDataResponse {
    @JsonProperty
    private boolean success;

    public WebifierPushTestResultDataResponse(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }
}
