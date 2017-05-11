package de.securitysquad.webifier.web.controller;

import de.securitysquad.webifier.core.service.WebifierTestResultDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by samuel on 18.02.17.
 */
@RestController
public class WebifierDataController {
    private final WebifierTestResultDataService service;

    @Autowired
    public WebifierDataController(WebifierTestResultDataService service) {
        this.service = service;
    }


    @RequestMapping("*")
    public void redirectToWebifier(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.webifier.de/");
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update() throws IOException {
        return service.update();
    }
}