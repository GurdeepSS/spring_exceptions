package com.spring.models;

/**
 * Article Model
 * @author ahmad.bakr
 *
 */
public class Article {

    private int id;
    private String title;

    /**
     * Get id
     * @return article id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     * @param id article id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get title
     * @return article title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     * @param title article title
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
