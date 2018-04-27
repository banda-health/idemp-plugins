
'use strict';

define(function () {
	let MutationObserver = window.MutationObserver || window.WebKitMutationObserver,
		eventListenerSupported = window.addEventListener;

	function DomObserver(obj, callback) {
		let self = this;

		let observer;

		if (MutationObserver) {
			// define a new observer
			observer = getObserver();
		}

		self.start = function start() {
			if (MutationObserver) {
				startObservation();
			} else {
				addListeners();
			}
		};

		self.stop = function stop() {
			if (MutationObserver) {
				stopObservation();
			} else {
				removeListeners();
			}
		};

		self.start();

		return self;

		function addListeners() {
			obj.addEventListener('DOMNodeInserted', callback, false);
			obj.addEventListener('DOMNodeRemoved', callback, false);
		}

		function getObserver() {
			return new MutationObserver(function mutationObserverChecker(mutations, observer) {
				if (mutations[0].addedNodes.length || mutations[0].removedNodes.length) {
					callback();
				}
			});
		}

		function removeListeners() {
			obj.removeEventListener('DOMNodeInserted', callback, false);
			obj.removeEventListener('DOMNodeRemoved', callback, false);
		}

		function startObservation() {
			observer.observe(obj, {
				childList: true,
				subtree: true
			});
		}

		function stopObservation() {
			observer.disconnect();
		}
	}

	return DomObserver;
});
