package de.securitysquad.webifier.web.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.securitysquad.webifier.web.domain.details.WebifierTestResultDetails;

import java.util.Map;

/**
 * Created by samuel on 19.02.17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebifierCheckTestResultsResponse {
    @JsonProperty
    private boolean success;
    @JsonProperty
    private Map<String, WebifierTestResultDetails> hosts;

    public WebifierCheckTestResultsResponse(boolean success) {
        this(success, null);
    }

    public WebifierCheckTestResultsResponse(boolean success, Map<String, WebifierTestResultDetails> hostResults) {
        this.success = success;
        this.hosts = hostResults;
    }

    public Map<String, WebifierTestResultDetails> getHosts() {
        return hosts;
    }

    public boolean getSuccess() {
        return success;
    }
}