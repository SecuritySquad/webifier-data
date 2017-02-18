package de.securitysquad.webifier.web.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by samuel on 18.02.17.
 */
public class WebifierSingleTestRequest {
    @JsonProperty
    @NotEmpty
    private String testId;
    @JsonProperty
    @NotNull
    private WebifierTestParametersRequest testData;
    @JsonProperty
    @NotNull
    private WebifierSingleTestResultRequest result;
    @JsonProperty
    @Min(0)
    private long duration;

    public String getTestId() {
        return testId;
    }

    public WebifierTestParametersRequest getTestData() {
        return testData;
    }

    public WebifierSingleTestResultRequest getResult() {
        return result;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "WebifierSingleTestRequest{" +
                "testId='" + testId + '\'' +
                ", testData=" + testData +
                ", result=" + result +
                ", duration=" + duration +
                '}';
    }
}