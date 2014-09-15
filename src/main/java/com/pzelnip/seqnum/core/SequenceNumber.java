package com.pzelnip.seqnum.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class SequenceNumber implements Comparable<SequenceNumber> {

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

	public int compareTo(SequenceNumber other) {
		return Long.valueOf(this.sequenceNumber).compareTo(Long.valueOf(other.sequenceNumber));
	}
	
}
