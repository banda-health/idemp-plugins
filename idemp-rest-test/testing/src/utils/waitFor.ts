// This is largely copied from https://github.com/testing-library/dom-testing-library so
// we could use the ability to wait for a condition to pass

function jestFakeTimersAreEnabled(): boolean {
	/* istanbul ignore else */
	if (typeof jest !== 'undefined' && jest !== null) {
		return (
			// legacy timers
			(setTimeout as any)._isMockFunction === true ||
			// modern timers
			Object.prototype.hasOwnProperty.call(setTimeout, 'clock')
		);
	}
	return false;
}

function waitFor<T>(
	callback: () => Promise<T> | T,
	{
		timeout = 15000, // 15 seconds, less than the 30 we set for Jest
		interval = 1000, // 1 second, since this will probably be used for API checking
		onTimeout = (error) => error,
	}: { timeout?: number; interval?: number; onTimeout?: (error: Error) => Error } = {},
) {
	if (typeof callback !== 'function') {
		throw new TypeError('Received `callback` arg must be a function');
	}

	return new Promise(async (resolve, reject) => {
		let lastError: Error | undefined, intervalId: NodeJS.Timer | undefined;
		let finished = false;
		let promiseStatus = 'idle';

		const overallTimeoutTimer = setTimeout(handleTimeout, timeout);

		const usingJestFakeTimers = jestFakeTimersAreEnabled();
		if (usingJestFakeTimers) {
			checkCallback();
			// this is a dangerous rule to disable because it could lead to an
			// infinite loop. However, eslint isn't smart enough to know that we're
			// setting finished inside `onDone` which will be called when we're done
			// waiting or when we've timed out.
			// eslint-disable-next-line no-unmodified-loop-condition
			while (!finished) {
				if (!jestFakeTimersAreEnabled()) {
					const error = new Error(
						`Changed from using fake timers to real timers while using waitFor. This is not allowed and will result in very strange behavior. Please ensure you're awaiting all async things your test is doing before changing to real timers. For more info, please go to https://github.com/testing-library/dom-testing-library/issues/830`,
					);
					reject(error);
					return;
				}
				// we *could* (maybe should?) use `advanceTimersToNextTimer` but it's
				// possible that could make this loop go on forever if someone is using
				// third party code that's setting up recursive timers so rapidly that
				// the user's timer's don't get a chance to resolve. So we'll advance
				// by an interval instead. (We have a test for this case).
				jest.advanceTimersByTime(interval);

				// It's really important that checkCallback is run *before* we flush
				// in-flight promises. To be honest, I'm not sure why, and I can't quite
				// think of a way to reproduce the problem in a test, but I spent
				// an entire day banging my head against a wall on this.
				checkCallback();

				if (finished) {
					break;
				}

				// In this rare case, we *need* to wait for in-flight promises
				// to resolve before continuing. We don't need to take advantage
				// of parallelization so we're fine.
				// https://stackoverflow.com/a/59243586/971592
				// eslint-disable-next-line no-await-in-loop
				await new Promise((r) => {
					setTimeout(r, 0);
					jest.advanceTimersByTime(0);
				});
			}
		} else {
			intervalId = setInterval(checkRealTimersCallback, interval);
			checkCallback();
		}

		function onDone(error: Error | null, result: T | null) {
			finished = true;
			clearTimeout(overallTimeoutTimer);

			if (!usingJestFakeTimers) {
				clearInterval(intervalId);
			}

			if (error) {
				reject(error);
			} else {
				resolve(result);
			}
		}

		function checkRealTimersCallback() {
			if (jestFakeTimersAreEnabled()) {
				const error = new Error(
					`Changed from using real timers to fake timers while using waitFor. This is not allowed and will result in very strange behavior. Please ensure you're awaiting all async things your test is doing before changing to fake timers. For more info, please go to https://github.com/testing-library/dom-testing-library/issues/830`,
				);
				return reject(error);
			} else {
				return checkCallback();
			}
		}

		function checkCallback() {
			if (promiseStatus === 'pending') return;
			try {
				const result = callback();
				if (typeof (result as Promise<T> | undefined)?.then === 'function') {
					promiseStatus = 'pending';
					(result as Promise<T>).then(
						(resolvedValue) => {
							promiseStatus = 'resolved';
							onDone(null, resolvedValue);
						},
						(rejectedValue) => {
							promiseStatus = 'rejected';
							lastError = rejectedValue;
						},
					);
				} else {
					onDone(null, result as T);
				}
				// If `callback` throws, wait for the next mutation, interval, or timeout.
			} catch (error) {
				// Save the most recent callback error to reject the promise with it in the event of a timeout
				lastError = error as Error;
			}
		}

		function handleTimeout() {
			let error;
			if (lastError) {
				error = lastError;
			} else {
				error = new Error('Timed out in waitFor.');
			}
			onDone(onTimeout(error), null);
		}
	});
}

export { waitFor };
