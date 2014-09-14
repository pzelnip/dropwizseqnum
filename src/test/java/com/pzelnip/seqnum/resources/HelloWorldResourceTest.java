package com.pzelnip.seqnum.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.base.Optional;
import com.pzelnip.seqnum.core.Saying;

public class HelloWorldResourceTest {

	@Test
	public void sayHelloGivesExpectedSaying() {
		HelloWorldResource hwr = new HelloWorldResource("%s", "Robert");
		
		Saying result = hwr.sayHello(Optional.of("bob"));
		
		assertEquals(result.getContent(), "bob");
	}
	
	@Test
	public void sayHelloGivesIncreasingIdValues() {
		HelloWorldResource hwr = new HelloWorldResource("%s", "bob");
		long lastResult = Long.MIN_VALUE;
		Optional<String> absent = Optional.absent();
		
		for (int x = 0; x < 5; x++) {
			Saying result = hwr.sayHello(absent);
			assertTrue(lastResult < result.getId());
			lastResult = result.getId();
		}
	}

}
