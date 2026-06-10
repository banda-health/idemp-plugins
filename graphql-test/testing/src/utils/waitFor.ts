// This is largely copied from https://github.com/testing-library/dom-testing-library so
// we could use the ability to wait for a condition to pass

import { vi } from 'vitest';

function fakeTimersAreEnabled(): boolean {
	return vi.isFakeTimers();
}

function waitFor<T>(
	callback: () => Promise<T> | T,
	{
		timeout = 15000, // 15 seconds, less than the 30 we set for Vitest
		interval = 1000, // 1 second, since this will probably be used for API checking
		onTimeout = (error) => error,
	}: { timeout?: number; interval?: number; onTimeout?: (error: Error) => Error } = {},
) {
	if (typeof callback !== 'function') {
		throw new TypeError('Received `callback` arg must be a function');
	}

	return new Promise(async (resolve, reject) => {
		let lastError: Error | undefined, intervalId: NodeJS.Timeout | undefined;
		let finished = false;
		let promiseStatus = 'idle';

		const overallTimeoutTimer = setTimeout(handleTimeout, timeout);

		const usingFakeTimers = fakeTimersAreEnabled();
		if (usingFakeTimers) {
			checkCallback();
			// eslint-disable-next-line no-unmodified-loop-condition
			while (!finished) {
				if (!fakeTimersAreEnabled()) {
					const error = new Error(
						`Changed from using fake timers to real timers while using waitFor. This is not allowed and will result in very strange behavior. Please ensure you're awaiting all async things your test is doing before changing to real timers. For more info, please go to https://github.com/testing-library/dom-testing-library/issues/830`,
					);
					reject(error);
					return;
				}
				vi.advanceTimersByTime(interval);
				checkCallback();
				if (finished) {
					break;
				}
				// eslint-disable-next-line no-await-in-loop
				await new Promise((r) => {
					setTimeout(r, 0);
					vi.advanceTimersByTime(0);
				});
			}
		} else {
			intervalId = setInterval(checkRealTimersCallback, interval);
			checkCallback();
		}

		function onDone(error: Error | null, result: T | null) {
			finished = true;
			clearTimeout(overallTimeoutTimer);

			if (!usingFakeTimers) {
				clearInterval(intervalId);
			}

			if (error) {
				reject(error);
			} else {
				resolve(result);
			}
		}

		function checkRealTimersCallback() {
			if (fakeTimersAreEnabled()) {
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
			} catch (error) {
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
