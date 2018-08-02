package com.payit.jdbi.impl;

import com.payit.api.BlogPost;
import com.payit.jdbi.BlogStore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BlogStoreImpl implements BlogStore {
    private static final Map<String, BlogPost> inMemoryStore = new HashMap<>();

    @Override
    public List<BlogPost> getAllPosts() {
        return inMemoryStore.values().stream().collect(Collectors.toList());
    }

    @Override
    public BlogPost storeBlogPost(BlogPost blogpost) {
        inMemoryStore.put(blogpost.getId(), blogpost);
        return blogpost;
    }

    @Override
    public BlogPost getBlogPostById(String id) {
        return inMemoryStore.getOrDefault(id, null);
    }

    @Override
    public void updateBlogPost(String id, BlogPost blogPost) {
        inMemoryStore.replace(id, blogPost);
    }

    @Override
    public void deleteBlogPost(String id) {
        inMemoryStore.remove(id);
    }
}
