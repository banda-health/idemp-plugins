/**
 * Set dashboard panels returned to no display
 */

'use strict';

function BandaHealth($) {
	let self = this;

	let classNames = {
		BH: 'bh',
		ORGANIZATION: 'organization',
		CLIENT: 'client',
		SYSTEM: 'system'
	};
	let hasHashChangedDueToClick = false;
	let needToResetHomeHash = false;

	self.initPage = (function initPageScope() {
		let initPageHasRun = false;
		return function initPage() {
			if (initPageHasRun) {
				return;
			}

			let ribbon = document.querySelector('.z-toolbar-tabs .z-toolbar-content.z-toolbar-start');
			if (!pageHasLoaded()) {
				setTimeout(initPage, 0);
				return;
			}
			initPageHasRun = true;
			
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
				backLIElement.setAttribute('title', 'Back');
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
				logoutAElement.classList.add('window-container-toolbar-btn', 'z-toolbarbutton', 'bh-logoutbutton');
				logoutAElement.setAttribute('title', 'Logout');
				ribbon.appendChild(logoutAElement);

				let logoutIElement = document.createElement('i');
				logoutAElement.appendChild(logoutIElement);
				logoutIElement.classList.add('fas', 'fa-sign-out-alt');

				let logoutDivElement = document.createElement('div');
				logoutDivElement.innerText = 'Logout';
				logoutAElement.appendChild(logoutDivElement);

				logoutAElement.addEventListener('click', logout);
			}

			function hideRibbonElement() {
				let expandCollapseImg = expandCollapseButton.querySelector('img');
				if (expandCollapseImg.src.includes('collapse')) {
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
	})();

	self.openIDempDialog = function showIDempDialog() {
		getDesktopHeaderPopupAndExecuteFunction(function clickIDempiereLogo() {
			document.querySelector('.desktop-header-popup table.desktop-header-left table tbody tr td:first-child img')
				.click();
		});
	};

	self.openPreferences = function showIDempDialog() {
		getDesktopHeaderPopupAndExecuteFunction(function clickPreferences() {
			document.querySelector('.desktop-header-popup table table table table table table table table tbody tr '
				+ 'td:nth-child(5) a').click();
		});
	};

	self.userIsOrg = function userIsOrg() {
		removeBodyClassName(classNames.SYSTEM, classNames.CLIENT);
		addBodyClassName(classNames.ORGANIZATION);
	};

	self.userIsClientAndOrg = function userIsClientAndOrg() {
		removeBodyClassName(classNames.SYSTEM, classNames.ORGANIZATION);
		addBodyClassName(classNames.CLIENT);
	};

	addBodyClassName(classNames.BH, classNames.SYSTEM);
	document.addEventListener('click', handleClickNavigation);
	window.addEventListener('hashchange', handleNavigation);

	return self;

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
		if (getNumberOfIDempTabsOpen() > 1) {
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

	function getNumberOfIDempTabsOpen() {
		let tabs = document.querySelectorAll('.desktop-tabbox .z-tabs .z-tabs-content li');
		// One tab was added for the back button
		return tabs.length - 1;
	}

	function handleClickNavigation(e) {
		if (userClickedHomeScreenButton()) {
			if (window.location.hash !== '#' + e.target.id) {
				hasHashChangedDueToClick = true;
				if (!isHashEmpty()) {
					needToResetHomeHash = true;
					window.location.hash = '';
				}
				window.location.hash = e.target.id;
			}
		} else if (userClickedDetailPaneTab()) {
			let clickedSpan = e.target;
			if (clickedSpan.localName !== 'span') {
				clickedSpan = clickedSpan.querySelector('span');
			}
			if (clickedSpan.parentNode.parentNode.classList.contains('z-tab-selected')) {
				hasHashChangedDueToClick = true;
				window.location.hash = clickedSpan.id;
			}
		} else if (userClickedDetailPaneNewOrEdit()) {
			let clickedSpan = e.target;
			if (clickedSpan.localName !== 'span') {
				clickedSpan = clickedSpan.querySelector('span');
			}
			if (!clickedSpan.parentNode.getAttribute('disabled')) {
				hasHashChangedDueToClick = true;
				window.location.hash = clickedSpan.id;
			}
		} else if (userClickedEditRecordInTable()) {
			let clickedTd = e.target;
			if (clickedTd.classList.contains('row-indicator-selected')) {
				hasHashChangedDueToClick = true;
				window.location.hash = clickedTd.id;
			}
		}

		return;

		function userClickedDetailPaneTab() {
			let greatGrandparent = ((e.target.parentNode || {}).parentNode || {}).parentNode || {};
			if (e.target.localName === 'a' && e.target.classList.contains('z-tab-content')) {
				greatGrandparent = greatGrandparent.parentNode || {};
			} else if (e.target.localName === 'span' && e.target.classList.contains('z-tab-text')) {
				greatGrandparent = (greatGrandparent.parentNode || {}).parentNode || {};
			}

			if (greatGrandparent.classList && greatGrandparent.classList.contains('adwindow-detailpane-tabbox')) {
				return true;
			}
			return false;
		}

		function userClickedDetailPaneNewOrEdit() {
			let targetClassList = e.target.classList;
			if (!targetClassList.contains('z-toolbarbutton-content') && !targetClassList.contains('z-toolbarbutton')) {
				return false;
			}
			let parent = e.target.parentNode;
			let aTag = e.target;
			if (e.target.localName !== 'a') {
				aTag = parent;
				parent = parent.parentNode;
			}
			let grandparent = parent.parentNode;

			if (grandparent.classList.contains('adwindow-detailpane-toolbar')
				&& (aTag.getAttribute('title').includes('New ') || aTag.getAttribute('title').includes('Edit '))) {
				return true;
			}
			return false;
		}

		function userClickedEditRecordInTable() {
			if (e.target.localName !== 'td' || !e.target.classList.contains('z-cell')
				|| !(e.target.getAttribute('title') || '').includes('Edit ')) {
				return false;
			}

			let parent = e.target;
			let i = 0;
			// This edit TD should be 18 levels deep, according to iDempiere 5.1 layouts...
			while (i++ < 18) {
				parent = (parent.parentNode || {});
			}

			return parent.classList.contains('adwindow-detailpane');
		}

		function userClickedHomeScreenButton() {
			let targetClassList = e.target.classList;
			if (e.target.localName === 'span' && e.target.parentNode) {
				targetClassList = e.target.parentNode.classList;
			}
			let targetIsBigButton = targetClassList.contains('button') && targetClassList.contains('app')
				&& targetClassList.contains('big') && targetClassList.contains('z-div');
			let targetIsIconButton = targetClassList.contains('i') && (targetClassList.contains('fas')
				|| targetClassList.contains('far') || targetClassList.contains('fab'));

			return targetIsBigButton || targetIsIconButton;
		}
	}

	function handleNavigation(e) {
		if (!hasHashChangedDueToClick && !needToResetHomeHash) {
			// Check if we're on the home page (hash is empty)
			if (isHashEmpty()) {
				// Close the current tab
				closeSelectedTab();
			} else {
				// If there is more than one tab open, try to see if there is a breadcrumb ID we can click on
				let breadcrumb = document.querySelector('.adwindow-breadcrumb a');
				if (breadcrumb && getNumberOfIDempTabsOpen() > 1) {
					breadcrumb.click();
				}
				// Assume the hash is an ID to click on
				else if (getNumberOfIDempTabsOpen() === 1) {
					let buttonToClick = document.querySelector(window.location.hash);
					if (buttonToClick) {
						buttonToClick.click();
					}
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
}

var bandahealth = bandahealth || new BandaHealth(window.jQuery);
