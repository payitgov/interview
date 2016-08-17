package com.payit.service;

import com.payit.api.BlogPost;

import java.util.List;

public interface BlogPostService {
    public List<BlogPost> getAllPosts();

    public BlogPost getPostById(String id);

    public void deletePost(String id);

    public BlogPost createPost(BlogPost post);

    public void updatePost(String id, BlogPost post);
}
