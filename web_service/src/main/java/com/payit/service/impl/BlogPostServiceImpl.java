package com.payit.service.impl;

import com.payit.api.BlogPost;
import com.payit.jdbi.BlogStore;
import com.payit.service.BlogPostService;

import java.util.List;

import javax.inject.Inject;

public class BlogPostServiceImpl implements BlogPostService {
    private final BlogStore blogStore;

    @Inject
    public BlogPostServiceImpl(BlogStore blogStore) {
        this.blogStore = blogStore;
    }

    @Override
    public List<BlogPost> getAllPosts() {
        return blogStore.getAllPosts();
    }

    @Override
    public BlogPost getPostById(String id) {
        return blogStore.getBlogPostById(id);
    }

    @Override
    public void deletePost(String id) {
        blogStore.deleteBlogPost(id);
    }

    @Override
    public BlogPost createPost(BlogPost post) {
        return blogStore.storeBlogPost(post);
    }

    @Override
    public void updatePost(String id, BlogPost blogPost) {
        blogStore.updateBlogPost(id, blogPost);
    }
}
