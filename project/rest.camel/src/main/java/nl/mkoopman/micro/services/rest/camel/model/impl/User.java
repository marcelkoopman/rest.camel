package nl.mkoopman.micro.services.rest.camel.model.impl;

import nl.mkoopman.micro.services.rest.camel.model.Model;

public class User implements Model {
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
}
