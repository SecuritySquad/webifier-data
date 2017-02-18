package de.securitysquad.webifier.persistence.domain;

/**
 * Created by samuel on 18.02.17.
 */
public class WebifierSingleTestResultData {
    private String testId;
    private String name;
    private String startup;
    private String shutdown;
    private boolean enabled;
    private int weight;
    private int startupTimeoutInSeconds;
    private int shutdownTimeoutInSeconds;
    private WebifierTestResult result;
    private Object resultInfo;
    private long durationInMillis;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartup() {
        return startup;
    }

    public void setStartup(String startup) {
        this.startup = startup;
    }

    public String getShutdown() {
        return shutdown;
    }

    public void setShutdown(String shutdown) {
        this.shutdown = shutdown;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStartupTimeoutInSeconds() {
        return startupTimeoutInSeconds;
    }

    public void setStartupTimeoutInSeconds(int startupTimeoutInSeconds) {
        this.startupTimeoutInSeconds = startupTimeoutInSeconds;
    }

    public int getShutdownTimeoutInSeconds() {
        return shutdownTimeoutInSeconds;
    }

    public void setShutdownTimeoutInSeconds(int shutdownTimeoutInSeconds) {
        this.shutdownTimeoutInSeconds = shutdownTimeoutInSeconds;
    }

    public WebifierTestResult getResult() {
        return result;
    }

    public void setResult(WebifierTestResult result) {
        this.result = result;
    }

    public Object getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(Object resultInfo) {
        this.resultInfo = resultInfo;
    }

    public long getDurationInMillis() {
        return durationInMillis;
    }

    public void setDurationInMillis(long durationInMillis) {
        this.durationInMillis = durationInMillis;
    }
}
