package com.symphony.metric;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

public class CustomMeter implements MeterBinder {

    //MeterRegistry is injected by spring
    @Override
    public void bindTo(MeterRegistry registry) {
        //todo implement me
    }
}
