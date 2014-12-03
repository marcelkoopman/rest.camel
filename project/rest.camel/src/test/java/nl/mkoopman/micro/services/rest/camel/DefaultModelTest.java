package nl.mkoopman.micro.services.rest.camel;

import java.util.Map;
import java.util.TreeMap;

import nl.mkoopman.micro.services.rest.camel.model.Model;
import nl.mkoopman.micro.services.rest.camel.model.impl.DefaultModel;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class DefaultModelTest {

	@Test
	public void testDefaultModel() throws Exception {
		final Model model = DefaultModel.builder().name("user").key("marcel.koopman@gmail.com").build();
		Assert.assertNotNull(model);
	}

	@Test(expected = Exception.class)
	public void testDefaultModelWithoutKey() throws Exception {
		final Model model = DefaultModel.builder().name("user").key("").build();
		Assert.assertNotNull(model);
	}

	@Test
	public void testJson() throws Exception {
		final Gson gson = new Gson();
		final Map<String, Object> attributes = new TreeMap<String, Object>();
		attributes.put("name", "String");
		final Model model = DefaultModel.builder().name("user").key("marcel.koopman@gmail.com").attibutes(attributes).build();
		final String json = gson.toJson(model);
		Assert.assertEquals("{\"attributes\":{\"name\":\"String\"},\"key\":\"marcel.koopman@gmail.com\",\"name\":\"user\"}", json);

		final Model defaultModel = gson.fromJson(json, DefaultModel.class);
		Assert.assertNotNull(defaultModel);
	}
}
