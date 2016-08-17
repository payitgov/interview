package com.payit;

import com.google.inject.AbstractModule;
import com.payit.jdbi.BlogStore;
import com.payit.jdbi.impl.BlogStoreImpl;
import com.payit.service.BlogPostService;
import com.payit.service.impl.BlogPostServiceImpl;

public class ServiceInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(BlogPostService.class).to(BlogPostServiceImpl.class);
        bind(BlogStore.class).to(BlogStoreImpl.class);
    }

}
