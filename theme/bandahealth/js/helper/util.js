
'use strict';

define(function () {
	let self = {};

	self.addBodyClassName = function addBodyClassName() {
		if (arguments.length === 0) {
			return;
		}
		let bodyTagClassList = document.querySelector('body').classList;
		for (let i = 0; i < arguments.length; i++) {
			if (!bodyTagClassList.contains(arguments[i])) {
				bodyTagClassList.add(arguments[i]);
			}
		}
	};

	self.elementIsVisible = function elementIsVisible(element) {
		return element && element.offsetParent !== null;
	};

	self.executeFunctionWhenElementPresent = function executeFunctionWhenElementPresent(querySelectorOrElement, functionToExecute) {
		waitForElementToBePresent();

		function waitForElementToBePresent() {
			let element = querySelectorOrElement;
			if (self.isString(querySelectorOrElement)) {
				element = document.querySelector(querySelectorOrElement);
			}

			if (!element) {
				setTimeout(waitForElementToBePresent, 0);
				return;
			}
			functionToExecute(element);
		}
	};

	self.isString = function isString(potentialString) {
		return potentialString instanceof String || typeof potentialString === 'string';
	};

	self.removeBodyClassName = function removeBodyClassName() {
		if (arguments.length === 0) {
			return;
		}
		let bodyTag = document.querySelector('body');
		for (let i = 0; i < arguments.length; i++) {
			bodyTag.classList.remove(arguments[i]);
		}
	};

	return self;
});
