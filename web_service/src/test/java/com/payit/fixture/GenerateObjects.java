package com.payit.fixture;

import com.payit.api.BlogPost;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Date;
import java.util.UUID;

public class GenerateObjects {
    public static BlogPost generateBlogPost() {
        BlogPost blogPost = new BlogPost();
        blogPost.setAuthor(UUID.randomUUID().toString());
        blogPost.setPostDate(new Date());
        blogPost.setPostText(generateLongString(100000));
        blogPost.setTitle(UUID.randomUUID().toString());
        return blogPost;
    }

    protected static String generateLongString(int size) {
        return RandomStringUtils.random(size);
    }
}
