package pl.adalberti.edu.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller handling REST requests
 */

@RestController
public class JSONController {

    @Autowired
    RequestHandler handler;

    @RequestMapping(value = "/request", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getResponse() {
        handler.handleRequest();
        return "{\"response\" : \"aaa\"}";
    }

}
