package org.bandahealth.idempiere.base.test.utils;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * This class contains utilities to help handle any asynchronous testing
 */
public class AsyncUtil {
	/**
	 * Similar to Testing Library's `waitFor`, this will wait for a set of conditions to be true
	 *
	 * @param runnable A function to call with assertions
	 * @throws InterruptedException In case something random happens
	 */
	public static void waitFor(Runnable runnable) throws InterruptedException {
		AsyncUtil.waitFor(runnable, 10000L);
	}

	/**
	 * Similar to Testing Library's `waitFor`, this will wait for a set of conditions to be true
	 *
	 * @param runnable           A function to call with assertions
	 * @param millisecondTimeout The timeout in milliseconds before the `waitFor` should fail
	 * @throws InterruptedException In case something random happens
	 */
	public static void waitFor(Runnable runnable, Long millisecondTimeout) throws InterruptedException {
		boolean hasSucceeded = false;
		long startTime = System.currentTimeMillis();
		String lastErrorMessage = null;
		while (!hasSucceeded && (System.currentTimeMillis() - startTime) <= millisecondTimeout) {
			try {
				// Assertions will throw exceptions when they fail, so we'll catch them
				runnable.run();
				// If no exceptions were thrown, all assertions passed
				hasSucceeded = true;
			} catch (Throwable error) {
				lastErrorMessage = error.getMessage();
			}
			Thread.sleep(200);
		}
		// If we haven't yet succeeded, just fail on the last failure message that came out
		if (!hasSucceeded) {
			fail(lastErrorMessage);
		}
	}
}
