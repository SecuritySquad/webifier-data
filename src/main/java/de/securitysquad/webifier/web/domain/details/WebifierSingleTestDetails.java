package de.securitysquad.webifier.web.domain.details;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by samuel on 18.02.17.
 */
public class WebifierSingleTestDetails {
    @JsonProperty
    @NotEmpty
    private String testId;
    @JsonProperty
    @NotNull
    private WebifierTestParameterDetails testData;
    @JsonProperty
    @NotNull
    private WebifierSingleTestResultDetails result;
    @JsonProperty
    @Min(0)
    private long duration;

    public String getTestId() {
        return testId;
    }

    public WebifierTestParameterDetails getTestData() {
        return testData;
    }

    public WebifierSingleTestResultDetails getResult() {
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