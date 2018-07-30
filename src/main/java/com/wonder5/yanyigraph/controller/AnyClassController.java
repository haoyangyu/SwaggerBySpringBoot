package com.wonder5.yanyigraph.controller;

import com.wonder5.yanyigraph.dto.AnyClassObject;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controller example for any class that aims ot provide API services
 * @author yuhaoy
 */
@RestController
public class AnyClassController {

    /**
     * Text example for the GET method
     * @return string - hello world
     */
    @RequestMapping(value = "/text", method = RequestMethod.GET)
    @ApiOperation(value = "Text - hello world return")
    public String getHello() {
        return "hello world!";
    }

    /**
     * JSON example for GET method without parameters
     * @return AnyClassObject
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns any class object", notes = "Returns any class object", response = AnyClassObject.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval of param value", response = AnyClassObject.class)})
    public AnyClassObject getPropertyJSON() {
        AnyClassObject anyClassObject = new AnyClassObject("I am the key", "I am the value");
        return anyClassObject;
    }

    /**
     * JSON example for GET method with parameters usage
     */
    @RequestMapping(value = "/{key}/{value}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get key-value pair by key and value")
    public ResponseEntity<AnyClassObject> getParamJSON(@PathVariable String key, @PathVariable String value) {
        AnyClassObject anyClassObject = new AnyClassObject(key, value);
        return new ResponseEntity<>(
                anyClassObject,
                HttpStatus.OK
        );
    }
}
