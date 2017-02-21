package de.securitysquad.webifier.web.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by samuel on 19.02.17.
 */
public class WebifierCheckTestResultsRequest {
    @JsonProperty
    @NotNull
    private List<String> urls;

    public List<String> getUrls() {
        return urls;
    }
}