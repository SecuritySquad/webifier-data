package de.securitysquad.webifier.web.domain.details;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

/**
 * Created by samuel on 18.02.17.
 */
public class WebifierTestParameterDetails {
    @JsonProperty
    @NotEmpty
    private String name;
    @JsonProperty
    @NotEmpty
    private String startup;
    @JsonProperty
    @NotEmpty
    private String shutdown;
    @JsonProperty
    private boolean enabled;
    @JsonProperty
    @Min(0)
    private int weight;
    @JsonProperty
    @Min(0)
    private int startupTimeoutInSeconds;
    @JsonProperty
    @Min(0)
    private int shutdownTimeoutInSeconds;

    public String getName() {
        return name;
    }

    public String getStartup() {
        return startup;
    }

    public String getShutdown() {
        return shutdown;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getWeight() {
        return weight;
    }

    public int getStartupTimeoutInSeconds() {
        return startupTimeoutInSeconds;
    }

    public int getShutdownTimeoutInSeconds() {
        return shutdownTimeoutInSeconds;
    }

    @Override
    public String toString() {
        return "WebifierSingleTestDataRequest{" +
                "name='" + name + '\'' +
                ", startup='" + startup + '\'' +
                ", shutdown='" + shutdown + '\'' +
                ", enabled=" + enabled +
                ", weight=" + weight +
                ", startupTimeoutInSeconds=" + startupTimeoutInSeconds +
                ", shutdownTimeoutInSeconds=" + shutdownTimeoutInSeconds +
                '}';
    }
}
