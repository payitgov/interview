package com.payit.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by Richard on 8/5/15.
 */
public class SampleHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
