package com.teodora.blog.exceptions;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(Integer articleId) {
        super("Could not find article "+articleId);
    }
}
