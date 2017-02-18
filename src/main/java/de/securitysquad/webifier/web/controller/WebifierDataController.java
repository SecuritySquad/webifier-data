package de.securitysquad.webifier.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by samuel on 18.02.17.
 */
@RestController
public class WebifierDataController {
    @RequestMapping("*")
    public void redirectToWebifier(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.webifier.de/");
    }
}