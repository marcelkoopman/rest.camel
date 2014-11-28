package nl.mkoopman.micro.services.rest.camel.repository;

import nl.mkoopman.micro.services.rest.camel.model.User;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public User getUser() {
		final User user = new User();
		user.setEmail("marcel.koopman@gmail.com");
		user.setPassword("123456");
		return user;
	}

}
