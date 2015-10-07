package com.spring.models;

/**
 * User Model
 * @author ahmad.bakr
 *
 */
public class User {

    private int id;
    private String name;
    private String email;

    /**
     * Get user id
     * @return user id
     */
    public int getId() {
        return id;
    }

    /**
     * Set user id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get user name
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Set user name
     * @param name user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get user email
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set user email
     * @param email user email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
