
'use strict';

define(['helper/util', 'config/classNames', 'helper/templateManager'], function (util, classNames, templateManager) {
	let self = {};
	let languageChangedDelayCheckerMS = 100;
	let maxTimeToCheckForLanguageUpdatesMS = 10 * 1000; // 10 seconds
	let maxTimeToWaitUntilLoginFieldsAppearMS = 5000;

	util.executeFunctionWhenElementPresent(getUserInputFieldSelector(), initLoginScreen, maxTimeToWaitUntilLoginFieldsAppearMS);
	addLoadingDisplay();

	return self;

	function addLoadingDisplay() {
		let loadingDiv = document.createElement('div');
		loadingDiv.innerHTML = templateManager.getTemplate('loadingDiv').firstElementChild.outerHTML;
		loadingDiv.classList.add(classNames.LOADING);
		document.body.appendChild(loadingDiv);
	}

	function getUserInputField() {
		return document.querySelector(getUserInputFieldSelector());
	}

	function getUserInputFieldSelector() {
		return '#rowUser .login-field input';
	}

	function initLoginScreen() {
		let advancedRowElement = templateManager.getTemplate('loginAdvancedRow').firstElementChild;
		let originalSelectRoleRowElement = document.querySelector('#rowSelectRole');
		let selectRoleRowElement = originalSelectRoleRowElement.cloneNode(true);
		let loginTableBody = document.querySelector('.login-box-body tbody');

		// Append "_BH" to the end of each of the id/for attributes so we don't have any conflicts
		selectRoleRowElement.id += 'BH';
		selectRoleRowElement.innerHTML = selectRoleRowElement.innerHTML.replace(/((id|for)=")(\w+\-?\w+)(")/g, "$1$3_BH$4");
		selectRoleRowElement.classList.add('hide');

		advancedRowElement.addEventListener('click', toggleAdvancedOptions);
		selectRoleRowElement.querySelector('input[type="checkbox"]').addEventListener('change', syncRealRoleSelectorWithFake);

		loginTableBody.appendChild(advancedRowElement);
		loginTableBody.appendChild(selectRoleRowElement);

		initLanguageSelectorListener();

		function initLanguageSelectorListener() {
			let languageSelector = document.querySelector('#rowLanguage .login-field input');
			if (!languageSelector) {
				return;
			}

			let currentLanguageSelectorValue = languageSelector.value;
			setInterval(checkIfDifferentLanguageSelected, languageChangedDelayCheckerMS);
			let checkStartTime = 0;

			function checkIfDifferentLanguageSelected() {
				let languageSelectorValue = languageSelector.value;
				if (languageSelectorValue !== currentLanguageSelectorValue) {
					checkStartTime = new Date();
					onLanguageChanged();
				}
				currentLanguageSelectorValue = languageSelectorValue;
			}

			function onLanguageChanged() {
				let realSelectRoleLabel = originalSelectRoleRowElement.querySelector('.login-field .z-checkbox-content');
				let fakeSelectRoleLabel = selectRoleRowElement.querySelector('.login-field .z-checkbox-content');
				if (!realSelectRoleLabel || !fakeSelectRoleLabel) {
					return;
				}
				if (realSelectRoleLabel.innerHTML === fakeSelectRoleLabel.innerHTML) {
					// We're only going to wait for this to update for so long...
					if (((new Date()) - checkStartTime) <= maxTimeToCheckForLanguageUpdatesMS) {
						setTimeout(onLanguageChanged, languageChangedDelayCheckerMS);
					}
					return;
				}
				fakeSelectRoleLabel.innerHTML = realSelectRoleLabel.innerHTML;
			}
		}

		function syncRealRoleSelectorWithFake(e) {
			let checkbox = e.target;
			let iDempiereChangeRoleCheckbox = originalSelectRoleRowElement.querySelector('input[type="checkbox"]');
			if (checkbox.checked !== iDempiereChangeRoleCheckbox.checked) {
				iDempiereChangeRoleCheckbox.click();
			}
		}

		function toggleAdvancedOptions(e) {
			let groupRowIcon = advancedRowElement.querySelector('.z-group-icon');
			if (selectRoleRowElement.classList.contains('hide')) {
				selectRoleRowElement.classList.remove('hide');
				groupRowIcon.classList.remove('z-group-icon-close');
				groupRowIcon.classList.add('z-group-icon-open');
			} else {
				selectRoleRowElement.classList.add('hide');
				groupRowIcon.classList.add('z-group-icon-close');
				groupRowIcon.classList.remove('z-group-icon-open');
			}
		}
	}

	function isUserLoginScreenVisible() {
		return !!getUserInputField();
	}
});
