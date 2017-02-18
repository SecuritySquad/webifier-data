package de.securitysquad.webifier.web.controller;

import de.securitysquad.webifier.core.service.WebifierDataService;
import de.securitysquad.webifier.web.domain.request.WebifierTestResultDataRequest;
import de.securitysquad.webifier.web.domain.response.WebifierTestResultDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by samuel on 17.02.17.
 */
@RestController
public class WebifierDataController {
    private final WebifierDataService dataService;

    @Autowired
    public WebifierDataController(WebifierDataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public WebifierTestResultDataResponse pushTestResult(@RequestBody @Valid WebifierTestResultDataRequest request) {
        return dataService.pushTestResultDataRequest(request);
    }
}