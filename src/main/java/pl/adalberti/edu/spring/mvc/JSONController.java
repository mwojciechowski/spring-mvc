package pl.adalberti.edu.spring.mvc;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.adalberti.edu.spring.model.Person;

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

    @RequestMapping(value = "/person/{type}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getPerson(@PathVariable("type") int type) {
        if (type == 1) {
            Person person = new Person();
            person.setId("123");
            person.setName("Person Name");
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        } else if (type == 2) {
            JSONObject object = new JSONObject();
            object.put("id", "234");
            object.put("name", "Json name");
            return new ResponseEntity<String>(object.toString(), HttpStatus.OK);
        } else {
            JSONObject object = new JSONObject();
            object.put("id", "234");
            object.put("name", "Json name");
            return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
        }

    }

}
