
'use strict';

define(['helper/util', 'config/classNames'], function (util, classNames) {
	let self = {};

	util.executeFunctionWhenElementPresent(getUserInputField(), function (userInputField) {
		userInputField.addEventListener('focus', checkText);
		userInputField.addEventListener('change', checkText);
		userInputField.addEventListener('keydown', checkText);
		userInputField.addEventListener('keyup', checkText);
		runUntilNotEmpty();

		function runUntilNotEmpty() {
			if (!userInputField.value) {
				setTimeout(runUntilNotEmpty, 0);
			}
			checkText({ target: userInputField });
		}
	});

	return self;

	function checkText(e) {
		if (e.target.value === 'SuperUser') {
			util.addBodyClassName(classNames.USER.SUPER_USER);
		} else {
			util.removeBodyClassName(classNames.USER.SUPER_USER);
		}
	}

	function getUserInputField() {
		return document.querySelectorAll('.login-field input')[0];
	}
});
