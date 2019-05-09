
'use strict';

define(['helper/util', 'config/classNames', 'helper/templateManager'], function (util, classNames, templateManager) {
	let self = {};
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
