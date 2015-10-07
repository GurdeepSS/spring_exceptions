package com.spring.exceptions;

/**
 * Project Not Found Exception
 * @author ahmad.bakr
 *
 */
public class ProjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int id;

    public ProjectNotFoundException(int id) {
        this.id = id;
    }

    /**
     * Get project id
     * @return project id
     */
    public int getId() {
        return id;
    }

}
