package nl.mkoopman.micro.services.rest.camel.repository.impl;

import nl.mkoopman.micro.services.rest.camel.model.impl.User;
import nl.mkoopman.micro.services.rest.camel.query.QueryContext;
import nl.mkoopman.micro.services.rest.camel.repository.Repository;
import nl.mkoopman.micro.services.rest.camel.store.StoreContext;

public class UserRepository implements Repository<User> {

	@Override
	public User getModel(final QueryContext context, final Class<User> modelClass) {
		final User user = new User();
		user.setEmail("marcel.koopman@gmail.com");
		user.setPassword("123456");
		return user;
	}

	@Override
	public void storeModel(final StoreContext context) {
		// TODO Auto-generated method stub

	}

}
