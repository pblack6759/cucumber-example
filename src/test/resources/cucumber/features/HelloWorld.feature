Feature: HelloWorld

	Scenario: Run test
		Given logging is enabled
		When "Hello, World!" is said to the world
		Then the world responds with "Hey, Dude!"
		When "Ugh, not you again!" is said to the world
		Then the world responds with "How rude!"