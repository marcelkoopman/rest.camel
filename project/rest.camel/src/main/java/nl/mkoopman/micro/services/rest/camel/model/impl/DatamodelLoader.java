package nl.mkoopman.micro.services.rest.camel.model.impl;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class DatamodelLoader implements Processor {

	private static final Logger LOG = Logger.getLogger(DatamodelLoader.class);

	@Override
	public void process(final Exchange exchange) throws Exception {
		final Object body = exchange.getIn().getBody();
		final DefaultModel defaultModel = (DefaultModel) body;
		LOG.info("Process: " + defaultModel.getAttributes());
	}
}
