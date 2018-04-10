/**
 * Set dashboard panels returned to no display
 */

'use strict';

var bandahealth = bandahealth || (function () {

	let classNames = {
		BH: 'bh',
		ORGANIZATION: 'organization',
		CLIENT: 'client',
		SYSTEM: 'system'
	};
	let hasHashChangedDueToClick = false;
	let needToResetHomeHash = false;

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
		appendHomeBackButton();

		return;

		function appendHomeBackButton() {
			let pageTabHolder = document.querySelector('.desktop-tabbox .z-tabs .z-tabs-content');
			let firstElement = pageTabHolder.querySelector('li');

			let backLIElement = document.createElement('li');
			backLIElement.classList.add('z-tab', 'back-button');
			pageTabHolder.insertBefore(backLIElement, firstElement);

			let backAElement = document.createElement('a');
			backAElement.classList.add('z-tab-content');
			backLIElement.appendChild(backAElement);

			let backIElement = document.createElement('i');
			backAElement.appendChild(backIElement);
			backIElement.classList.add('fas', 'fa-arrow-left');

			backAElement.addEventListener('click', function triggerBrowserBack() {
				window.history.back();
			});
		}

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

	let openIDempDialog = function showIDempDialog() {
		getDesktopHeaderPopupAndExecuteFunction(function clickIDempiereLogo() {
			document.querySelector('.desktop-header-popup table.desktop-header-left table tbody tr td:first-child img')
				.click();
		});
	};

	let openPreferences = function showIDempDialog() {
		getDesktopHeaderPopupAndExecuteFunction(function clickPreferences() {
			document.querySelector('.desktop-header-popup table table table table table table table table tbody tr '
				+ 'td:nth-child(5) a').click();
		});
	};

	let userIsOrg = function userIsOrg() {
		removeBodyClassName(classNames.SYSTEM, classNames.CLIENT);
		addBodyClassName(classNames.ORGANIZATION);
	};

	let userIsClientAndOrg = function userIsClientAndOrg() {
		removeBodyClassName(classNames.SYSTEM, classNames.ORGANIZATION);
		addBodyClassName(classNames.CLIENT);
	};

	addBodyClassName(classNames.BH);
	addBodyClassName(classNames.SYSTEM);
	document.addEventListener('click', handleClickNavigation);
	window.addEventListener('hashchange', handleNavigation);

	return {
		initPage: initPage,
		openIDempDialog: openIDempDialog,
		openPreferences: openPreferences,
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

	function closeSelectedTab() {
		let tabs = document.querySelectorAll('.desktop-tabbox .z-tabs .z-tabs-content li');
		// If a tab is selected other than the home tab, the tab length will be greater than 2
		if (tabs.length > 2) {
			document.querySelector('.desktop-tabbox .z-tabs .z-tabs-content .z-tab-selected .z-tab-button i').click();
		}
	}

	function getDesktopHeaderPopupAndExecuteFunction(functionToExecute) {
		let idempTableFetchButton = document.querySelector('.z-toolbar-tabs .z-toolbar-content.z-toolbar-start a');
		idempTableFetchButton.click();
		waitForHtmlToArrive();

		function waitForHtmlToArrive() {
			let html = document.querySelector('.desktop-header-popup');
			if (!html) {
				setTimeout(waitForHtmlToArrive, 0);
				return;
			}
			functionToExecute();
		}
	}

	function handleClickNavigation(e) {
		let targetIsBigButton = e.target.className.indexOf('button') > -1 && e.target.className.indexOf('app') > -1
			&& e.target.className.indexOf('big') > -1 && e.target.className.indexOf('z-div') > -1;
		let targetIsIconButton = e.target.className.indexOf(' i ') > -1 && (e.target.className.indexOf('fas ') > -1
			|| e.target.className.indexOf('far ') > -1);
		if (targetIsBigButton || targetIsIconButton) {
			if (window.location.hash !== '#' + e.target.id) {
				hasHashChangedDueToClick = true;
				if (!isHashEmpty()) {
					needToResetHomeHash = true;
					window.location.hash = '';
				}
				window.location.hash = e.target.id;
			}
		}
	}

	function handleNavigation(e) {
		if (!hasHashChangedDueToClick && !needToResetHomeHash) {
			// Check if we're on the home page (hash is empty)
			if (isHashEmpty()) {
				// Close the current tab
				closeSelectedTab();
			} else {
				// Open the right tab
				let buttonToClick = document.querySelector(window.location.hash);
				if (buttonToClick) {
					buttonToClick.click();
				}
			}
		}
		if (!needToResetHomeHash) {
			hasHashChangedDueToClick = false;
		}
		needToResetHomeHash = false;
	}

	function isHashEmpty() {
		return !window.location.hash || window.location.hash === '#';
	}

	function logout() {
		getDesktopHeaderPopupAndExecuteFunction(function clickLogout() {
			document.querySelector('.desktop-header-popup table table table table table table table table tbody tr '
				+ 'td:last-child a').click();
		});
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
