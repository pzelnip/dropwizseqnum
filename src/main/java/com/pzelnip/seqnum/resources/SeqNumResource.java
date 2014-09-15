package com.pzelnip.seqnum.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.pzelnip.seqnum.core.SequenceNumber;

@Path("/seqnum")
@Produces(MediaType.APPLICATION_JSON)
public class SeqNumResource {

	private final AtomicLong counter;
	
	public SeqNumResource(long startVal) {
		counter = new AtomicLong(startVal);
	}

    @GET
    @Timed
	public SequenceNumber getNextNumber() {
		SequenceNumber sn = new SequenceNumber(counter.incrementAndGet(), 
				System.currentTimeMillis());

		return sn;
	}
}
