package com.payit;

import com.payit.healthcheck.SampleHealthCheck;
import com.payit.resources.BlogPostResource;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationMain extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            args = new String[] {"server", "app.yml"};
        }
        new ApplicationMain().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        Injector injector = Guice.createInjector(new ServiceInjector());

        BlogPostResource blogPostResource = injector.getInstance(BlogPostResource.class);

        //Register your resources
        environment.jersey().register(blogPostResource);

        final SampleHealthCheck healthCheck = new SampleHealthCheck();
        environment.healthChecks().register("sample", healthCheck);
    }

    @Override
    public String getName() {
        return "Interview App";
    }
}
