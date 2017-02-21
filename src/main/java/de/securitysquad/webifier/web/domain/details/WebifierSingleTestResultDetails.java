package de.securitysquad.webifier.web.domain.details;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by samuel on 18.02.17.
 */
public class WebifierSingleTestResultDetails {
    @JsonProperty
    @NotNull
    private WebifierTestResultDetails result;
    @JsonProperty
    @NotNull
    private Object info;

    public WebifierTestResultDetails getResult() {
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
