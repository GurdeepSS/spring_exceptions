package com.spring.models;

/**
 * Project Model
 * @author ahmad.bakr
 *
 */
public class Project {

    private int id;
    private String name;

    /**
     * Get Id
     * @return project id
     */
    public int getId() {
        return id;
    }

    /**
     * Set Id
     * @param id project id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get Name
     * @return project name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name
     * @param name project name
     */
    public void setName(String name) {
        this.name = name;
    }

}
