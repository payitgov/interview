package com.payit.jdbi;

import com.payit.api.BlogPost;

import java.util.List;

public interface BlogStore {

    public List<BlogPost> getAllPosts();
    public BlogPost storeBlogPost(BlogPost blogpost);
    public BlogPost getBlogPostById(String id);
    public void updateBlogPost(String id, BlogPost blogPost);
    public void deleteBlogPost(String id);
}
