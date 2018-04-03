/**
 * Set dashboard panels returned to no display
 */

'use strict';

let bandahealth = (function () {

	let classNames = {
		BH: 'bh',
		ORGANIZATION: 'organization',
		CLIENT: 'client',
		SYSTEM: 'system'
	};

	addBodyClassName(classNames.BH);
	addBodyClassName(classNames.SYSTEM);

	let initPage = function initPage() {
		let ribbon = document.querySelector('.z-toolbar-tabs .z-toolbar-content.z-toolbar-start');
		if (!pageHasLoaded()) {
			setTimeout(initPage, 0);
			return;
		}
		let expandCollapseButton = ribbon.querySelectorAll('a')[1];
		hideRibbonElement();
		hideWestPanel();
		appendLogoutButton();

		return;

		function appendLogoutButton() {
			let logoutAElement = document.createElement('a');
			logoutAElement.classList.add('window-container-toolbar-btn', 'z-toolbarbutton');
			ribbon.appendChild(logoutAElement);

			let logoutIElement = document.createElement('i');
			logoutAElement.appendChild(logoutIElement);
			logoutIElement.classList.add('fas', 'fa-sign-out-alt');

			logoutAElement.addEventListener('click', logout);
		}

		function hideRibbonElement() {
			let expandCollapseImg = expandCollapseButton.querySelector('img');
			if (expandCollapseImg.src.indexOf('collapse') !== -1) {
				expandCollapseButton.click();
			}
		}

		function hideWestPanel() {
			let westPanelCollapseButton = document.querySelectorAll('.desktop-layout .z-west-splitter-button i')[1];
			if (westPanelCollapseButton.offsetParent !== null) {
				westPanelCollapseButton.click();
			}
		}

		function pageHasLoaded() {
			return !!ribbon;
		}
	};

	let userIsOrg = function userIsOrg() {
		removeBodyClassName(classNames.SYSTEM, classNames.CLIENT);
		addBodyClassName(classNames.ORGANIZATION);
	};

	let userIsClientAndOrg = function userIsClientAndOrg() {
		removeBodyClassName(classNames.SYSTEM, classNames.ORGANIZATION);
		addBodyClassName(classNames.CLIENT);
	};

	return {
		initPage: initPage,
		userIsOrg: userIsOrg,
		userIsClientAndOrg: userIsClientAndOrg
	};

	function addBodyClassName() {
		if (arguments.length === 0) {
			return;
		}
		let bodyTag = document.querySelector('body');
		for (let i = 0; i < arguments.length; i++) {
			bodyTag.classList.add(arguments[i]);
		}
	}

	function logout() {
		let logoutTableFetchButton = document.querySelector('.z-toolbar-tabs .z-toolbar-content.z-toolbar-start a');
		logoutTableFetchButton.click();
		clickLogout();

		function clickLogout() {
			let logoutHtml = document.querySelector('.desktop-header-popup');
			if (!logoutHtml) {
				setTimeout(clickLogout, 0);
				return;
			}
			logoutHtml.querySelector('.desktop-header-popup table table table table table table table table tbody tr '
				+ 'td:last-child a').click();
		}
	}

	function removeBodyClassName() {
		if (arguments.length === 0) {
			return;
		}
		let bodyTag = document.querySelector('body');
		for (let i = 0; i < arguments.length; i++) {
			bodyTag.classList.remove(arguments[i]);
		}
	}
})();



