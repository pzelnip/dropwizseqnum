package com.pzelnip.seqnum.resources;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;


public class SeqNumResourceTest {

	@Test
	public void getNextNumberGivesEverIncreasingNumbers()
	{
		final long NUM_VALUES = 10; 
		long startVal = 5;
		SeqNumResource sut = new SeqNumResource(startVal);

		List<Long> result = new ArrayList<Long>();
		
		for (int x = 0; x < NUM_VALUES ; x++)
		{
			// don't care about timestamps for this test
			result.add(sut.getNextNumber().getSequenceNumber());
		}

		// should be in sorted order
		assertTrue(Ordering.natural().isOrdered(result));
		
		// and should contain no duplicates
		assertEquals(NUM_VALUES, Sets.newHashSet(result).size());		
	}
	
	@Test
	public void getNextNumberGivesTimestampRoughlyEqualToNow() {
		long startVal = 5;
		SeqNumResource sut = new SeqNumResource(startVal);
		
		// timestamp should be between when the method is called and when you 
		// return (inclusive)
		long start = System.currentTimeMillis();
		long result = sut.getNextNumber().getTimestamp();
		long end = System.currentTimeMillis();
		
		assertThat(result, is(both(greaterThanOrEqualTo(start)).and(lessThanOrEqualTo(end))));
	}

}
