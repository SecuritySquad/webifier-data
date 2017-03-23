package de.securitysquad.webifier.web.controller;

import de.securitysquad.webifier.core.service.WebifierTestResultDataService;
import de.securitysquad.webifier.web.domain.request.WebifierCheckTestResultsRequest;
import de.securitysquad.webifier.web.domain.request.WebifierPushTestResultDataRequest;
import de.securitysquad.webifier.web.domain.response.WebifierCheckTestResultsResponse;
import de.securitysquad.webifier.web.domain.response.WebifierPushTestResultDataResponse;
import de.securitysquad.webifier.web.domain.response.WebifierTestResultsCountResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by samuel on 17.02.17.
 */
@RestController
public class WebifierTestResultDataController {
    private static final Logger LOG = Logger.getLogger(WebifierTestResultDataController.class);

    private final WebifierTestResultDataService dataService;

    @Autowired
    public WebifierTestResultDataController(WebifierTestResultDataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public WebifierPushTestResultDataResponse pushTestResult(@RequestBody @Valid WebifierPushTestResultDataRequest request, BindingResult result) {
        if (result.hasErrors()) {
            LOG.info("Validation error!");
            return new WebifierPushTestResultDataResponse(false);
        }
        return dataService.pushTestResultDataRequest(request);
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public WebifierCheckTestResultsResponse checkTestResults(@RequestBody @Valid WebifierCheckTestResultsRequest request, BindingResult result) {
        if (result.hasErrors()) {
            LOG.info("Validation error!");
            return new WebifierCheckTestResultsResponse(false);
        }
        return dataService.checkTestResultsRequest(request);
    }

    @RequestMapping(value = "/count")
    public WebifierTestResultsCountResponse countTestResults() {
        return dataService.countTestResultsRequest();
    }
}