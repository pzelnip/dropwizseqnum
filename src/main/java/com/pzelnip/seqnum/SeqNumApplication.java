package com.pzelnip.seqnum;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.pzelnip.seqnum.resources.HelloWorldResource;
import com.pzelnip.seqnum.resources.SeqNumResource;
import com.pzelnip.seqnum.health.TemplateHealthCheck;

public class SeqNumApplication extends Application<HelloWorldConfiguration> {
	public static void main(String[] args) throws Exception {
		new SeqNumApplication().run(args);
	}

	@Override
	public String getName() {
		return "seqnum";
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(HelloWorldConfiguration configuration,
			Environment environment) {
		final HelloWorldResource resource = new HelloWorldResource(
				configuration.getTemplate(), configuration.getDefaultName());
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(
				configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
		environment.jersey().register(new SeqNumResource(5));
	}

}