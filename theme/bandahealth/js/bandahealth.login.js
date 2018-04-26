
'use strict';

define(['helper/util', 'config/classNames'], function (util, classNames) {
	let self = {};

	let changeRoleTrIds = {
		client: '#rowClient',
		role: '#rowRole',
		organization: '#rowOrganisation',
		warehouse: '#rowWarehouse'
	};
	let usersThatCanChangeRoles = ['SuperUser', 'System'];
	let maxTimeToWaitUntilLoginFieldsAppearMS = 5000;

	util.executeFunctionWhenElementPresent(getUserInputFieldSelector(), function (userInputField) {
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
	}, maxTimeToWaitUntilLoginFieldsAppearMS);

	document.addEventListener('click', handleInitialLoginClick);
	addLoadingDisplay();

	return self;

	function addLoadingDisplay() {
		let loadingDiv = document.createElement('div');
		loadingDiv.innerHTML = '<div class="z-loading"><div class="z-loading-indicator"><span class="z-loading-icon"></span> Processing...</div></div>';
		loadingDiv.classList.add(classNames.LOADING);
		document.querySelector('body').appendChild(loadingDiv);
	}

	function allowRoleChange() {
		util.removeBodyClassName(classNames.USER.CANNOT_CHANGE_ROLES);
	}

	function checkText(e) {
		if (usersThatCanChangeRoles.includes(e.target.value)) {
			util.addBodyClassName(classNames.USER.CAN_CHANGE_ROLES);
		} else {
			util.removeBodyClassName(classNames.USER.CAN_CHANGE_ROLES);
		}
	}

	function getSelectRoleField() {
		return document.querySelector('#rowSelectRole');
	}

	function getUserInputField() {
		return document.querySelector(getUserInputFieldSelector());
	}

	function getUserInputFieldSelector() {
		return '#rowUser .login-field input';
	}

	function handleInitialLoginClick(e) {
		if (loginOkWasClicked()) {
			if (isUserLoginScreenVisible() && !canChangeRoles()) {
				util.addBodyClassName(classNames.USER.CANNOT_CHANGE_ROLES);
				util.executeFunctionWhenElementPresent(changeRoleTrIds.client, roleSelectionScreenLoaded);
			}
		}

		function canChangeRoles() {
			return util.elementIsVisible(getSelectRoleField());
		}

		function loginOkWasClicked() {
			let element = e.target;
			let parent = element.parentNode || {};
			let grandparent = parent.parentNode || {};

			let imageTag = element;
			if (element.localName !== 'img') {
				imageTag = element.querySelector('img') || {};
			}
			return (imageTag.src || '').includes('Ok16.png');
		}
	}

	function isUserLoginScreenVisible() {
		return !!getUserInputField();
	}

	function isRoleSelectionScreenVisible() {
		return !!document.querySelector(changeRoleTrIds.client);
	}

	function roleSelectionScreenLoaded() {
		if (areMultipleSelectionsPresent()) {
			allowRoleChange();
		} else {
			selectCurrentRoleForUser();
		}

		function areMultipleSelectionsPresent() {
			let clientChoices = document.querySelector(changeRoleTrIds.client).querySelectorAll('.login-field .z-combobox-popup li');
			let roleChoices = document.querySelector(changeRoleTrIds.role).querySelectorAll('.login-field .z-combobox-popup li');
			let organizationChoices = document.querySelector(changeRoleTrIds.organization).querySelectorAll('.login-field .z-combobox-popup li');

			return clientChoices.length > 1 || roleChoices.length > 1 || organizationChoices.length > 1;
		}
	}

	function selectCurrentRoleForUser() {
		let okButton = document.querySelector('img[src*="Ok16.png"]');
		if (okButton) {
			okButton.click();
		}
	}
});
