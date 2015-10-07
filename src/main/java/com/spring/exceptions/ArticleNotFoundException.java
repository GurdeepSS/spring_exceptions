package com.spring.exceptions;

/**
 * Article Not Found Exception
 * @author ahmad.bakr
 */
public class ArticleNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int id;

    public ArticleNotFoundException(int id) {
        this.id = id;
    }

    /**
     * Get Article id
     * @return Article id
     */
    public int getId() {
        return id;
    }

}
