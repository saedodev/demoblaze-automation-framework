package com.saedodev.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/api")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME,
        value = "com.saedodev.api.stepdef,com.saedodev.api.hooks")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME,
        value = "@api")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty, html:build/reports/cucumber/api-report.html, json:build/reports/cucumber/api-report.json")
public class ApiTestRunner {
}