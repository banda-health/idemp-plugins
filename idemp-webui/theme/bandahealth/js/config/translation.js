'use strict';

define(function () {
	let self = {};

	self.LOGOUT = {
		TRANSLATION: '',
		HELPTIP: ''
	};

	self.update = function update(translationObject) {
		let root = document.documentElement;
		if (!translationObject.buttonTranslations) {
			console.log('Button Translations not received from server.');
			return;
		}
		for (let i = 0; i < translationObject.buttonTranslations.length; i++) {
			let buttonTranslation = translationObject.buttonTranslations[i];
			root.style.setProperty(buttonTranslation.cssVariableName, '" ' + buttonTranslation.name + '"');
		}
		self.LOGOUT.TRANSLATION = translationObject.logout.translation;
		self.LOGOUT.HELPTIP = translationObject.logout.helpTip;
	};

	return self;
});
