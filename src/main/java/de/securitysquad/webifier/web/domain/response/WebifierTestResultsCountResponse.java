package de.securitysquad.webifier.web.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by samuel on 24.03.17.
 */
public class WebifierTestResultsCountResponse {
    @JsonProperty
    private long size;

    public WebifierTestResultsCountResponse(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }
}