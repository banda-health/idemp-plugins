
'use strict';

define(['helper/util', 'config/classNames'], function (util, classNames) {
	let self = {};

	let changeRoleTrIds = {
		client: '#rowClient',
		role: '#rowRole',
		organization: '#rowOrganisation',
		warehouse: '#rowWarehouse'
	};
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

	function allowRoleChangeIfMultipleSelectionsPresent() {
		let mustUserSelectRole = false;

		let clientChoices = document.querySelector(changeRoleTrIds.client).querySelectorAll('.login-field .z-combobox-popup li');
		if (clientChoices.length > 1) {
			mustUserSelectRole = true;
		}

		let roleChoices = document.querySelector(changeRoleTrIds.role).querySelectorAll('.login-field .z-combobox-popup li');
		if (roleChoices.length > 1) {
			mustUserSelectRole = true;
		}

		let organizationChoices = document.querySelector(changeRoleTrIds.organization).querySelectorAll('.login-field .z-combobox-popup li');
		if (organizationChoices.length > 1) {
			mustUserSelectRole = true;
		}

		if (mustUserSelectRole) {
			util.removeBodyClassName(classNames.USER.CANNOT_CHANGE_ROLES);
		}
	}

	function checkText(e) {
		if (e.target.value === 'SuperUser') {
			util.addBodyClassName(classNames.USER.SUPER_USER);
		} else {
			util.removeBodyClassName(classNames.USER.SUPER_USER);
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
				util.executeFunctionWhenElementPresent(changeRoleTrIds.client, allowRoleChangeIfMultipleSelectionsPresent);
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
});
