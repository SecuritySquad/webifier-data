package de.securitysquad.webifier.web.domain.details;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by samuel on 18.02.17.
 */
public class WebifierOverallTestResultDetails {
    @JsonProperty
    @NotNull
    private WebifierTestResultDetails resultType;
    @JsonProperty
    @Min(-1)
    @Max(1)
    private double resultValue;

    public WebifierTestResultDetails getResultType() {
        return resultType;
    }

    public double getResultValue() {
        return resultValue;
    }

    @Override
    public String toString() {
        return "WebifierOverallTestResultRequest{" +
                "resultType=" + resultType +
                ", resultValue=" + resultValue +
                '}';
    }
}
