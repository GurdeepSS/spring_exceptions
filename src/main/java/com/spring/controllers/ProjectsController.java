package com.spring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exceptions.ProjectNotFoundException;
import com.spring.models.Project;

/**
 * Projects Rest Controller
 * Projects Controller is an example of handling exceptions globally by catching them by a ControllerAdvice
 * and let the advice handle them as appropriate @see com.spring.exceptions.handlers.ProjectNotFoundExceptionHandler  
 * @author ahmad.bakr
 *
 */
@RestController
@RequestMapping("/projects")
public class ProjectsController {

    private Project project;

    public ProjectsController() {
        this.project = new Project();
        project.setId(1);
        project.setName("Spring Exceptions");
    }

    /**
     * Get Project by id
     * This is an example of handling exception by a global handler @see com.spring.exceptions.handlersProjectNotFoundExceptionHandler
     * ProjectNotFoundException Exceptions thrown here (and everywhere) are caught by the global handler which knows what to return to the caller
     * @param id project id
     * @return project or throw an exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project get(@PathVariable(value = "id") int id) {
        if (id == project.getId()) {
            return project;
        }
        throw new ProjectNotFoundException(id);
    }

}
