package nl.mkoopman.micro.services.rest.camel.processor;

import nl.mkoopman.micro.services.rest.camel.model.User;
import nl.mkoopman.micro.services.rest.camel.repository.UserRepository;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spi.Registry;

public class UserProcessor implements Processor {

	@Override
	public void process(final Exchange exchange) throws Exception {
		final CamelContext context = exchange.getContext();
		final Registry registry = context.getRegistry();
		final UserRepository userRepository = registry.lookupByNameAndType("userRepository", UserRepository.class);
		final User user = userRepository.getUser();
		exchange.getOut().setBody(user);
	}
}
