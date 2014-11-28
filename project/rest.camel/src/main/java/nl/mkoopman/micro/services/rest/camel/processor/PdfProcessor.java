package nl.mkoopman.micro.services.rest.camel.processor;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class PdfProcessor implements Processor {

	private static final Logger LOG = Logger.getLogger(PdfProcessor.class);

	@Override
	public void process(final Exchange exchange) throws Exception {
		final String filename = "test.pdf";
		final byte[] data = Files.readAllBytes(Paths.get(filename));
		LOG.info("Read " + data.length + " bytes! " + Thread.currentThread().getId());
		exchange.getOut().setBody(data);
	}

}
