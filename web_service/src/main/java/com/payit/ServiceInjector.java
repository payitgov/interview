package com.payit;

import com.payit.jdbi.BlogStore;
import com.payit.jdbi.impl.BlogStoreImpl;
import com.payit.service.BlogPostService;
import com.payit.service.impl.BlogPostServiceImpl;

import com.google.inject.AbstractModule;

public class ServiceInjector extends AbstractModule {
    @Override
    protected void configure() {
        bind(BlogPostService.class).to(BlogPostServiceImpl.class);
        bind(BlogStore.class).to(BlogStoreImpl.class);
    }
}
