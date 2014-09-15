package com.pzelnip.seqnum.resources;

import java.util.concurrent.atomic.AtomicLong;

import com.pzelnip.seqnum.core.SequenceNumber;

public class SeqNumResource {

	private final AtomicLong counter;
	
	public SeqNumResource(long startVal) {
		counter = new AtomicLong(startVal);
	}

	public SequenceNumber getNextNumber() {
		SequenceNumber sn = new SequenceNumber(counter.incrementAndGet(), 
				System.currentTimeMillis());

		return sn;
	}
}
