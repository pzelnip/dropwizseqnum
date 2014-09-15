package com.pzelnip.seqnum.core;

import static org.junit.Assert.*;

import java.io.IOException;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SequenceNumberTest {

	@Test
	public void serializationAndDeserializationToFromJsonResultsInSameObject()
			throws IOException {
		SequenceNumber expected = new SequenceNumber(5, 1111);
		ObjectMapper om = new ObjectMapper();

		String json = om.writeValueAsString(expected);
		SequenceNumber result = om.readValue(json, SequenceNumber.class);

		assertEquals(expected.getTimestamp(), result.getTimestamp());
		assertEquals(expected.getSequenceNumber(), result.getSequenceNumber());
	}

	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(SequenceNumber.class).verify();
	}

	@Test
	public void compareToIgnoresTimestamp() {
		SequenceNumber s1 = new SequenceNumber(5, 1234);
		SequenceNumber s2 = new SequenceNumber(5, 32422);

		assertTrue(s1.compareTo(s2) == 0);
	}

	@Test
	public void compareToWithDifferentSequenceNumbersReturnsAsExpected() {
		Long n1 = Long.valueOf(5);
		Long n2 = Long.valueOf(6);
		SequenceNumber s1 = new SequenceNumber(n1, 1234);
		SequenceNumber s2 = new SequenceNumber(n2, 1234);

		assertTrue(s1.compareTo(s2) == n1.compareTo(n2));
	}
}
