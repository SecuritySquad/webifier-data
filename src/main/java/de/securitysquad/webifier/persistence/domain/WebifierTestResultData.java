package de.securitysquad.webifier.persistence.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by samuel on 17.02.17.
 */
public class WebifierTestResultData {
    @Id
    private String id;
    private String testerId;
    private String enteredUrl;
    private String testedUrl;
    private String host;
    private WebifierTestResult overallResultType;
    private double overallResultValue;
    private long durationInMillis;
    private Date datetime;
    @DBRef
    private List<WebifierSingleTestResultData> testResults;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTesterId() {
        return testerId;
    }

    public void setTesterId(String testerId) {
        this.testerId = testerId;
    }

    public String getEnteredUrl() {
        return enteredUrl;
    }

    public void setEnteredUrl(String enteredUrl) {
        this.enteredUrl = enteredUrl;
    }

    public String getTestedUrl() {
        return testedUrl;
    }

    public void setTestedUrl(String testedUrl) {
        this.testedUrl = testedUrl;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public WebifierTestResult getOverallResultType() {
        return overallResultType;
    }

    public void setOverallResultType(WebifierTestResult overallResultType) {
        this.overallResultType = overallResultType;
    }

    public double getOverallResultValue() {
        return overallResultValue;
    }

    public void setOverallResultValue(double overallResultValue) {
        this.overallResultValue = overallResultValue;
    }

    public long getDurationInMillis() {
        return durationInMillis;
    }

    public void setDurationInMillis(long durationInMillis) {
        this.durationInMillis = durationInMillis;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public List<WebifierSingleTestResultData> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<WebifierSingleTestResultData> testResults) {
        this.testResults = testResults;
    }
}