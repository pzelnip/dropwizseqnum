package com.pzelnip.seqnum.core;

import static org.junit.Assert.assertEquals;

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
		EqualsVerifier.forClass(SequenceNumber.class)
				.verify();
	}
}
