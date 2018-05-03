
'use strict';

define(['helper/util', 'config/classNames', 'helper/templateManager'], function (util, classNames, templateManager) {
	let self = {};

	let changeRoleTrIds = {
		client: '#rowClient',
		role: '#rowRole',
		organization: '#rowOrganisation',
		warehouse: '#rowWarehouse'
	};
	let usersThatCanChangeRoles = ['SuperUser', 'System'];
	let maxTimeToWaitUntilLoginFieldsAppearMS = 5000;

	util.executeFunctionWhenElementPresent(getUserInputFieldSelector(), initLoginScreen, maxTimeToWaitUntilLoginFieldsAppearMS);

	// document.addEventListener('click', handleInitialLoginClick);
	addLoadingDisplay();

	return self;

	function addLoadingDisplay() {
		let loadingDiv = document.createElement('div');
		loadingDiv.innerHTML = templateManager.getTemplate('loadingDiv').firstElementChild.outerHTML;
		loadingDiv.classList.add(classNames.LOADING);
		document.body.appendChild(loadingDiv);
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
