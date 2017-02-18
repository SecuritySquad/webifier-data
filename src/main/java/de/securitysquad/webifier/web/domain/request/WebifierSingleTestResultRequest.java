package de.securitysquad.webifier.web.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by samuel on 18.02.17.
 */
public class WebifierSingleTestResultRequest {
    @JsonProperty
    @NotNull
    private WebifierTestResultRequest result;
    @JsonProperty
    @NotNull
    private Object info;

    public WebifierTestResultRequest getResult() {
        return result;
    }

    public Object getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "WebifierSingleTestResultRequest{" +
                "result=" + result +
                ", info=" + info +
                '}';
    }
}
