package com.payit.jdbi;

import com.payit.api.BlogPost;

import java.util.List;

public interface BlogStore {
    List<BlogPost> getAllPosts();

    BlogPost storeBlogPost(BlogPost blogpost);

    BlogPost getBlogPostById(String id);

    void updateBlogPost(String id, BlogPost blogPost);

    void deleteBlogPost(String id);
}
