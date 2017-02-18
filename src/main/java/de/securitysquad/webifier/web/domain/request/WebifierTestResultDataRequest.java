package de.securitysquad.webifier.web.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by samuel on 17.02.17.
 */
public class WebifierTestResultDataRequest {
    @JsonProperty
    @NotEmpty
    private String id;
    @JsonProperty
    @NotEmpty
    private String enteredUrl;
    @JsonProperty
    @NotEmpty
    private String testedUrl;
    @JsonProperty
    @NotNull
    private WebifierOverallTestResultRequest result;
    @JsonProperty
    @Min(0)
    private long duration;
    @JsonProperty
    @NotNull
    private List<WebifierSingleTestRequest> testResults;

    public String getId() {
        return id;
    }

    public String getEnteredUrl() {
        return enteredUrl;
    }

    public String getTestedUrl() {
        return testedUrl;
    }

    public WebifierOverallTestResultRequest getResult() {
        return result;
    }

    public long getDuration() {
        return duration;
    }

    public List<WebifierSingleTestRequest> getTestResults() {
        return testResults;
    }

    @Override
    public String toString() {
        return "WebifierTestResultDataRequest{" +
                "id='" + id + '\'' +
                ", enteredUrl='" + enteredUrl + '\'' +
                ", testedUrl='" + testedUrl + '\'' +
                ", result=" + result +
                ", duration=" + duration +
                ", testResults=" + testResults +
                '}';
    }
}