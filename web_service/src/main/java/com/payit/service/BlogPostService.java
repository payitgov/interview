package com.payit.service;

import com.payit.api.BlogPost;

import java.util.List;

public interface BlogPostService {
    List<BlogPost> getAllPosts();

    BlogPost getPostById(String id);

    void deletePost(String id);

    BlogPost createPost(BlogPost post);

    void updatePost(String id, BlogPost post);
}
