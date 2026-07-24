package com.saedodev.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/web")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME,
        value = "com.saedodev.web.stepdef,com.saedodev.web.hooks")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME,
        value = "@web")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty, html:build/reports/cucumber/web-report.html, json:build/reports/cucumber/web-report.json")
public class WebTestRunner {
}