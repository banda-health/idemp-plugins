package org.bandahealth.idempiere.report.test.utils;

import java.math.BigDecimal;
import java.util.Random;

public class NumberUtils {
	private static final Random random = new Random();

	/**
	 * Get a random BigDecimal integer object between the min and max inclusive.
	 *
	 * @param min The minimum boundary for the random number
	 * @param max The maximum boundary for the random number
	 * @return The randomly generated BigDecimal
	 */
	public static BigDecimal randomBigDecimal(int min, int max) {
		return new BigDecimal(random.nextInt((max - min) + 1) + min);
	}
}
