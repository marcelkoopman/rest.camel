package nl.mkoopman.micro.services.rest.camel;

import nl.mkoopman.micro.services.rest.camel.model.impl.DatamodelLoader;
import nl.mkoopman.micro.services.rest.camel.model.impl.DefaultModel;
import nl.mkoopman.micro.services.rest.camel.processor.PdfProcessor;
import nl.mkoopman.micro.services.rest.camel.processor.UserProcessor;
import nl.mkoopman.micro.services.rest.camel.repository.impl.UserRepository;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class RestServer {

	private final Main main;

	public RestServer() {
		main = new Main();
		main.enableHangupSupport();
		main.bind("userRepository", new UserRepository());
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);
	}

	public void boot() throws Exception {
		main.addRouteBuilder(new MyRouteBuilder());
		main.run();
	}

	private static class MyRouteBuilder extends RouteBuilder {
		@Override
		public void configure() throws Exception {

			from("file://datamodel?move=loaded").unmarshal().json(JsonLibrary.Gson, DefaultModel.class).process(new DatamodelLoader());

			restConfiguration().component("netty4-http").port(9091);

			rest("/api").get("user").to("direct:user");
			from("direct:user").process(new UserProcessor()).marshal().json(JsonLibrary.Gson);

			rest("/api").get("pdf").to("direct:pdf");
			from("direct:pdf").process(new PdfProcessor());
		}
	}

	public static void main(final String[] args) throws Exception {
		final RestServer restServer = new RestServer();
		restServer.boot();
	}
}
