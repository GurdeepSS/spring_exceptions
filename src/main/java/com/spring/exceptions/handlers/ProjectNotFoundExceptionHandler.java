package com.spring.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.exceptions.ProjectNotFoundException;

/**
 * A Global handler for ProjectNotFoundException 
 * @author ahmad.bakr
 *
 */
@ControllerAdvice
public class ProjectNotFoundExceptionHandler {

    /**
     * Globally handle @see ProjectNotFoundException
     * @param req web request
     * @param ex exception thrown
     * @return Exception Response
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<Object> handleProjectNotFoundException(HttpServletRequest req, ProjectNotFoundException ex) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", String.valueOf(ex.getId()));
        map.put("reason", "Project can not be found");
        map.put("url", req.getRequestURI());
        BodyBuilder responseBudiler = ResponseEntity.status(HttpStatus.NOT_FOUND);
        ResponseEntity<Object> response = responseBudiler.body(map);
        return response;
    }

}
