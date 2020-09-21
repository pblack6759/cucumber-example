package cukesteps;



import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelloCukeStepDefinitions {
	
	private static final Map<String, String> CONVERSATION_PAIRS = new HashMap<>();
	static {
		CONVERSATION_PAIRS.put("Hello, World!", "Hey, Dude!");
		CONVERSATION_PAIRS.put("How's it going?", "Not too bad, thanks.");
		CONVERSATION_PAIRS.put("Ugh, not you again!", "How rude!");
	}
	
	private static Logger LOG;
	private String greetingIn = null;
	
	@Given("logging is enabled")
	public void loggingIsEnabled() {
		LOG = LogManager.getLogger(HelloCukeStepDefinitions.class);
		Assert.assertNotNull("The logger could not be instantiated", LOG);
	}

	@When("{string} is said to the world")
	public void somethingIsSaidToTheWorld(String greeting) {
		LOG.info("received a greeting: " + greeting);
		Assert.assertNotNull("The world doesn't know how to respond to \"" + greetingIn + "\"", CONVERSATION_PAIRS.get(greeting));
		this.greetingIn = greeting;
	}

	@Then("the world responds with {string}")
	public void theWorldRespondsWith(String response) {
		String worldsResponse = CONVERSATION_PAIRS.get(greetingIn);
		Assert.assertEquals("The world had a different response in mind to \"" + greetingIn + "\"", response, worldsResponse);
	}

}

