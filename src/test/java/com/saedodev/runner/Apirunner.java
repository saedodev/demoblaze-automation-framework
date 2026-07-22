package com.saedodev.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

public class Apirunner {
    @Suite
    @IncludeEngines("cucumber")
    @SelectClasspathResource("features/api")
    @ConfigurationParameter(
            key = GLUE_PROPERTY_NAME,
            value = "com.saedodev.api.stepdef,com.saedodev.api.hooks"
    )
    @ConfigurationParameter(
            key = PLUGIN_PROPERTY_NAME,
            value = "pretty, html:build/reports/api-report.html, json:build/reports/api-report.json"
    )
    public class ApiRunner {
    }
}
