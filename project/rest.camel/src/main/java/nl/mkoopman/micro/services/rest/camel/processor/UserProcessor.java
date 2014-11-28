package nl.mkoopman.micro.services.rest.camel.processor;

import nl.mkoopman.micro.services.rest.camel.model.impl.User;
import nl.mkoopman.micro.services.rest.camel.query.QueryContext;
import nl.mkoopman.micro.services.rest.camel.repository.Repository;
import nl.mkoopman.micro.services.rest.camel.repository.impl.UserRepository;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spi.Registry;

public class UserProcessor implements Processor {

	@Override
	public void process(final Exchange exchange) throws Exception {
		final CamelContext context = exchange.getContext();
		final Registry registry = context.getRegistry();
		final Repository<User> repository = registry.lookupByNameAndType("userRepository", UserRepository.class);
		final User user = repository.getModel(new QueryContext() {
			@Override
			public String getId() {
				return "marcel.koopman@gmail.com";
			}
		}, User.class);
		exchange.getOut().setBody(user);
	}
}
