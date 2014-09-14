package com.pzelnip.seqnum.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class SequenceNumber {

	private final long timestamp;
	
	private final long sequenceNumber;
	
	@JsonCreator
	public SequenceNumber(@JsonProperty("sequence_number") long sequenceNum, @JsonProperty("timestamp") long timestamp)	{
		this.sequenceNumber = sequenceNum;
		this.timestamp = timestamp;
	}
	
	@JsonProperty("timestamp")
	public long getTimestamp() {
		return timestamp;
	}

	@JsonProperty("sequence_number")
	public long getSequenceNumber() {
		return sequenceNumber;
	}
}
