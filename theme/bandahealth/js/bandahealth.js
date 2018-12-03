/**
 * Set dashboard panels returned to no display
 */

'use strict';

define(
		[ 'helper/util', 'domObserver', 'config/classNames',
				'helper/templateManager' ],
		function(util, DomObserver, classNames, templateManager) {
			let self = {};

			let buttonIDs = {
				LOGOUT : 'BHLogoutButton',
				BACK : 'BHBackButton',
				MOBILE_MENU_BUTTON : 'BHMobileMenuButton'
			};

			let hasHashChangedDueToClick = false;
			let needToResetHomeHash = false;
			let didUserCloseTheDetailPane = false;
			let isTabDetailPaneProgrammaticallyTriggered = false;

			let maxTimeToWaitUntilDomElementsAppearMS = 5000;

			self.initPage = (function initPageScope() {
				let initPageHasRun = false;
				return function initPage() {
					if (initPageHasRun) {
						return;
					}

					let ribbon = document
							.querySelector('.z-toolbar-tabs .z-toolbar-content.z-toolbar-start');
					if (!pageHasLoaded()) {
						setTimeout(initPage, 0);
						return;
					}
					initPageHasRun = true;

					let expandCollapseButton = ribbon.querySelectorAll('a')[1];

					hideRibbonElement();
					// hideWestPanel();
					// hideEastPanel();
					appendLogoutButton();
					appendHomeBackButton();
					addDomObservationMethods();
					addDashboardPanelMethods();
					expandDashboardMenuTabPanels();
					if (areViewingMobile()) {
						util.addBodyClassName(classNames.MOBILE);
						initializeMobileCorrectionChecks();
					}

					return;

					function hideEastPanel() {
						let eastPanelCollapseButton = document
								.querySelectorAll('.desktop-layout .z-east-splitter-button i')[1];
						if (util.elementIsVisible(eastPanelCollapseButton)) {
							eastPanelCollapseButton.click();
						}
					}

					function hideRibbonElement() {
						let expandCollapseImg = expandCollapseButton
								.querySelector('img');
						if (expandCollapseImg.src.includes('collapse')) {
							expandCollapseButton.click();
						}
					}

					function hideWestPanel() {
						let westPanelCollapseButton = document
								.querySelectorAll('.desktop-layout .z-west-splitter-button i')[1];
						if (util.elementIsVisible(westPanelCollapseButton)) {
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
					document
							.querySelector(
									'.desktop-header-popup table.desktop-header-left table tbody tr td:first-child img')
							.click();
				});
			};

			self.openPreferences = function showIDempDialog() {
				getDesktopHeaderPopupAndExecuteFunction(function clickPreferences() {
					document
							.querySelector(
									'.desktop-header-popup table table table table table table table table tbody tr '
											+ 'td:nth-child(5) a').click();
				});
			};

			self.userIsOrg = function userIsOrg() {
				util.removeBodyClassName(classNames.SYSTEM, classNames.CLIENT);
				util.addBodyClassName(classNames.ORGANIZATION);
			};

			self.userIsClientAndOrg = function userIsClientAndOrg() {
				util.removeBodyClassName(classNames.SYSTEM,
						classNames.ORGANIZATION);
				util.addBodyClassName(classNames.CLIENT);
			};

			util.addBodyClassName(classNames.BH, classNames.SYSTEM);
			document.addEventListener('click', onPageClick);
			window.addEventListener('hashchange', handleNavigation);

			return self;

			function addDomObservationMethods() {
				util
						.executeFunctionWhenElementPresent(
								'.z-tabpanels',
								function createDetailPaneObserver() {
									let detailPaneObserver = new DomObserver(
											document
													.querySelector('.z-tabpanels'),
											function handleDomUpdate() {
												// Don't do any of this if we're
												// the system user
												let bodyTag = document.body;
												if (bodyTag.classList
														.contains(classNames.SYSTEM)) {
													return;
												}
												disableZoomAccrossWindows();
												let bodyTagClasses = document.body.classList;
												if (!areAnyTabsVisisble()) {
													util
															.addBodyClassName(classNames.NO_TABS_PRESENT);
													closeTabDetailPane();
												} else if (areAnyTabsVisisble()) {
													util
															.removeBodyClassName(classNames.NO_TABS_PRESENT);
													openTabDetailPane();
												}
												if (areCreatingOrEditingAnEntity()) {
													util
															.addBodyClassName(classNames.USER.ENTITY_ADD_OR_EDIT);
													closeTabDetailPane();
													navigateToDetailEditIfUserOnGridView();
													// hideSaveWhenFinalizeOrderPresent();
												} else if (!areCreatingOrEditingAnEntity()) {
													util
															.removeBodyClassName(classNames.USER.ENTITY_ADD_OR_EDIT);
													openTabDetailPane();
												}
												// are we on dashboard
												let dashboardPane = document
														.querySelector('.desktop-hometab.z-tab.z-tab-selected');
												if (util
														.elementIsVisible(dashboardPane)) {
													displaySOPanelOnDashboard();
												} else {
													let eastPanelCollapseButton = document
															.querySelectorAll('.desktop-layout .z-east-splitter-button i')[1];
													if (util
															.elementIsVisible(eastPanelCollapseButton)) {
														eastPanelCollapseButton
																.click();
													}
												}
												if (areViewingTheStockTakePage()) {
													util
															.addBodyClassName(classNames.NO_ADD_EDIT_ENTITY);
												} else {
													util
															.removeBodyClassName(classNames.NO_ADD_EDIT_ENTITY);
												}
												if (areViewingTheStockTakePage()) {
													util
															.addBodyClassName(classNames.NO_ADD_EDIT_ENTITY);
												} else {
													util
															.removeBodyClassName(classNames.NO_ADD_EDIT_ENTITY);
												}
												if (!pageLoadedIsLookupWindow()) {
													return;
												} else {
													let lookupPanelOkButton = document
															.querySelector('button[title="OK"].img-btn.btn-ok.z-button');
													hideLookupPanelOnProductsWindow(lookupPanelOkButton);
												}

											});
								}, maxTimeToWaitUntilDomElementsAppearMS);

				function areAnyTabsVisisble() {
					let tabs = document
							.querySelectorAll('.adwindow-detailpane-tabbox .z-tabs-content li');
					if (tabs.length === 0) {
						return false;
					}
					for (let i = 0; i < tabs.length; i++) {
						// If an element has the class z-tab-selected, at least
						// one is
						// visible
						if (tabs[i].classList.contains('z-tab-selected')) {
							return true;
						}
					}
					return false;
				}

				function areCreatingOrEditingAnEntity() {
					let entityCancelButton = document
							.querySelector('.adwindow-toolbar a:nth-child(1)');
					return util.elementIsVisible(entityCancelButton);
				}

				function areViewingTheStockTakePage() {
					let lastTabText = document
							.querySelector('.desktop-tabbox .z-tabs .z-tabs-content li.z-tab-selected .z-tab-text');
					return lastTabText
							&& (lastTabText.innerText || '')
									.includes('Stock Take');
				}

				function pageLoadedIsLookupWindow() {
					// Has user clicked on the product icon?
					let userNavigationIsFromDashboard = false;
					let windowHeader = document
							.querySelector('div .z-tabs ul li:nth-child(3) a span');
					if (windowHeader != null) {
						let isFromDashboardCheck = windowHeader.textContent
								.match(/^\s..\s\w{6}[a-z]$/i);
						if (isFromDashboardCheck != null) {
							userNavigationIsFromDashboard = true;
						}
					}
					return userNavigationIsFromDashboard;
				}
			}

			function addDashboardPanelMethods() {
				util.executeFunctionWhenElementPresent('.desktop-left-column',
						function createDashboardObserver() {
							let dashBoardObserver = new DomObserver(document
									.querySelector('.desktop-tabbox'),
									function handleDomUpdate() {
										let bodyTag = document.body;
										/* Ignore for System user */
										if (bodyTag.classList
												.contains(classNames.SYSTEM)) {
											return;
										}
										expandDashboardMenuTabPanels();

									});
						}, maxTimeToWaitUntilDomElementsAppearMS);
			}

			function appendHomeBackButton() {
				if (document.getElementById(buttonIDs.BACK) !== null) {
					return;
				}
				let pageTabHolder = document
						.querySelector('.desktop-tabbox .z-tabs .z-tabs-content');
				if (!pageTabHolder) {
					return;
				}
				let firstElement = pageTabHolder.querySelector('li');

				let backLIElement = document.createElement('li');
				backLIElement.classList.add('z-tab', 'back-button');
				backLIElement.setAttribute('title', 'Back');
				backLIElement.id = buttonIDs.BACK;
				pageTabHolder.insertBefore(backLIElement, firstElement);

				let backAElement = document.createElement('a');
				backAElement.classList.add('z-tab-content');
				backLIElement.appendChild(backAElement);

				let backIElement = document.createElement('i');
				backAElement.appendChild(backIElement);
				// backIElement.classList.add('fas', 'fa-arrow-left');

				backLIElement.addEventListener('click',
						function triggerBrowserBack() {
							// window.history.back();
						});
			}

			function appendLogoutButton() {
				if (document.getElementById(buttonIDs.LOGOUT) !== null) {
					return;
				}
				let ribbon = document
						.querySelector('.z-toolbar-tabs .z-toolbar-content.z-toolbar-start');
				if (!ribbon) {
					return;
				}

				let logoutAElement = document.createElement('a');
				logoutAElement.classList.add('window-container-toolbar-btn',
						'z-toolbarbutton', 'bh-logoutbutton');
				logoutAElement.setAttribute('title', 'Logout');
				logoutAElement.id = buttonIDs.LOGOUT;
				ribbon.appendChild(logoutAElement);

				let logoutIElement = document.createElement('i');
				logoutAElement.appendChild(logoutIElement);
				logoutIElement.classList.add('fas', 'fa-sign-out-alt');

				let logoutDivElement = document.createElement('div');
				logoutDivElement.innerText = 'Logout';
				logoutAElement.appendChild(logoutDivElement);

				logoutAElement.addEventListener('click', logout);
			}

			function areViewingMobile() {
				return document.querySelectorAll('.desktop-header.mobile').length !== 0;
			}

			function closeAllButHomeTab() {
				if (getNumberOfIDempTabsOpen() > 1) {
					let tabsToClose = document
							.querySelectorAll('.desktop-tabbox .z-tabs .z-tabs-content li:not(:first-child):not(:nth-child(2)) .z-tab-button i');
					tabsToClose.forEach(function closeTab(tabCloseButton) {
						tabCloseButton.click();
					});
				}
			}

			function closeTabDetailPane() {
				let closeTabDetailPaneButton = document
						.querySelector('.z-south-splitter-button .z-icon-caret-down');
				if (util.elementIsVisible(closeTabDetailPaneButton)) {
					isTabDetailPaneProgrammaticallyTriggered = true;
					closeTabDetailPaneButton.click();
				}
			}

			function getDesktopHeaderPopupAndExecuteFunction(functionToExecute) {
				let idempTableFetchButton = document
						.querySelector('.z-toolbar-tabs .z-toolbar-content.z-toolbar-start a');
				idempTableFetchButton.click();
				util.executeFunctionWhenElementPresent('.desktop-header-popup',
						functionToExecute,
						maxTimeToWaitUntilDomElementsAppearMS);
			}

			function getMobileHeaderPopupAndExecuteFunction(functionToExecute) {
				let idempTableFetchButton = document
						.querySelector('.desktop-header-username');
				if (!idempTableFetchButton) {
					return;
				}
				idempTableFetchButton.click();
				util.executeFunctionWhenElementPresent('.user-panel-popup',
						functionToExecute,
						maxTimeToWaitUntilDomElementsAppearMS);
			}

			function getNumberOfIDempTabsOpen() {
				let tabs = document
						.querySelectorAll('.desktop-tabbox .z-tabs .z-tabs-content li');
				// One tab was added for the back button
				return tabs.length - 1;
			}

			function handleClickNavigation(e) {
				if (userClickedHomeScreenButton()
						|| userClickedOnDraftSOItemOnDashboard()) {
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
					if (clickedSpan.parentNode.parentNode.classList
							.contains('z-tab-selected')) {
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
				} else if (userClosedTheDetailPane()) {
					didUserCloseTheDetailPane = true;
				} else if (userOpenedTheDetailPane()) {
					didUserCloseTheDetailPane = false;
				} else if (clickWasOnDetailPaneExpander()) {
					if (document.body.classList
							.contains(classNames.NO_TABS_PRESENT)) {
						e.preventDefault();
						return false;
					}
				}

				return;

				function userClickedOnDraftSOItemOnDashboard() {
					let target = e.target.parentNode.parentElement;
					return target.classList
							.contains(classNames.DRAFT_MODE_ORDER_ITEM);
				}

				function clickWasOnDetailPaneExpander() {
					return e.target.classList.contains('z-icon-chevron-up')
							&& e.target.parentNode.classList
									.contains('z-south-collapsed')
							|| e.target.classList.contains('z-south-collapsed');
				}

				function userClickedDetailPaneTab() {
					let greatGrandparent = ((e.target.parentNode || {}).parentNode || {}).parentNode
							|| {};
					if (e.target.localName === 'a'
							&& e.target.classList.contains('z-tab-content')) {
						greatGrandparent = greatGrandparent.parentNode || {};
					} else if (e.target.localName === 'span'
							&& e.target.classList.contains('z-tab-text')) {
						greatGrandparent = (greatGrandparent.parentNode || {}).parentNode
								|| {};
					}

					if (greatGrandparent.classList
							&& greatGrandparent.classList
									.contains('adwindow-detailpane-tabbox')) {
						return true;
					}
					return false;
				}

				function userClickedDetailPaneNewOrEdit() {
					let targetClassList = e.target.classList;
					if (!targetClassList.contains('z-toolbarbutton-content')
							&& !targetClassList.contains('z-toolbarbutton')) {
						return false;
					}
					let parent = e.target.parentNode;
					let aTag = e.target;
					if (e.target.localName !== 'a') {
						aTag = parent;
						parent = parent.parentNode;
					}
					let grandparent = parent.parentNode;

					if (grandparent.classList
							.contains('adwindow-detailpane-toolbar')
							&& (aTag.getAttribute('title').includes('New ') || aTag
									.getAttribute('title').includes('Edit '))) {
						return true;
					}
					return false;
				}

				function userClickedEditRecordInTable() {
					if (e.target.localName !== 'td'
							|| !e.target.classList.contains('z-cell')
							|| !(e.target.getAttribute('title') || '')
									.includes('Edit ')) {
						return false;
					}

					let parent = e.target;
					let i = 0;
					// This edit TD should be 18 levels deep, according to
					// iDempiere 5.1
					// layouts...
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
					let targetIsBigButton = targetClassList.contains('button')
							&& targetClassList.contains('app')
							&& targetClassList.contains('big')
							&& targetClassList.contains('z-div');
					let targetIsIconButton = targetClassList.contains('i')
							&& (targetClassList.contains('fas')
									|| targetClassList.contains('far')
									|| targetClassList.contains('fab') || targetClassList
									.contains('fa'));

					return targetIsBigButton || targetIsIconButton;
				}

				function userClosedTheDetailPane() {
					let wasClickOnTheCloseButton = e.target.classList
							.contains('z-icon-caret-down')
							&& e.target.parentNode.classList
									.contains('z-south-splitter-button')
							|| e.target.classList
									.contains('z-south-splitter-button');
					if (!wasClickOnTheCloseButton) {
						return false;
					}
					if (isTabDetailPaneProgrammaticallyTriggered) {
						isTabDetailPaneProgrammaticallyTriggered = false;
						return false;
					}
					return true;
				}

				function userOpenedTheDetailPane() {
					if (!clickWasOnDetailPaneExpander()) {
						return false;
					}
					if (isTabDetailPaneProgrammaticallyTriggered) {
						isTabDetailPaneProgrammaticallyTriggered = false;
						return false;
					}
					return true;
				}
			}

			function handleNavigation(e) {
				if (!hasHashChangedDueToClick && !needToResetHomeHash) {
					// Check if we're on the home page (hash is empty)
					if (isHashEmpty()) {
						// Close the current tab
						closeAllButHomeTab();
					} else {
						// If there is more than one tab open, try to see if
						// there is a
						// breadcrumb ID we can click on
						let breadcrumb = document
								.querySelector('.adwindow-breadcrumb a');
						if (breadcrumb && getNumberOfIDempTabsOpen() > 1) {
							breadcrumb.click();
						}
						// Assume the hash is an ID to click on
						else if (getNumberOfIDempTabsOpen() === 1) {
							let buttonToClick = document
									.querySelector(window.location.hash);
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

			function initializeMobileCorrectionChecks() {
				function fixMobileProblems() {
					updateSiteNav();
					addGridToggleButton();
				}

				setInterval(fixMobileProblems, 100);

				function addGridToggleButton() {
					let toolbar = document
							.querySelector('.adwindow-toolbar.mobile .z-toolbar-content');
					if (!toolbar) {
						return;
					}
					let gridToggleButton = document
							.querySelector('.adwindow-toolbar.mobile .z-toolbar-content > a[title*="Alt+T"]');
					if (gridToggleButton) {
						return;
					}
					gridToggleButton = templateManager
							.getTemplate('gridToggleButton').firstElementChild;
					let oldGridToggleButton = toolbar
							.querySelector('a[title*="Alt+T"]');
					gridToggleButton.addEventListener('click', function() {
						oldGridToggleButton.click();
					});
					// add to UI after the Post-It button for our CSS to render
					// correctly
					let postItButton = document
							.querySelector('.adwindow-toolbar.mobile .z-toolbar-content > a[title*="Post-it"]');
					if (postItButton != null)
						postItButton.parentNode.insertBefore(gridToggleButton,
								postItButton.nextSibling);
				}

			}

			function isHashEmpty() {
				return !window.location.hash || window.location.hash === '#';
			}

			function logout() {
				if (!areViewingMobile()) {
					getDesktopHeaderPopupAndExecuteFunction(function clickLogout() {
						document
								.querySelector(
										'.desktop-header-popup table table table table table table table table tbody tr '
												+ 'td:last-child a').click();
					});
				} else {
					getMobileHeaderPopupAndExecuteFunction(function clickMobileLogout() {
						document
								.querySelector(
										'.user-panel-popup .z-vlayout-inner:last-child table table td:last-child a')
								.click();
					});
				}
			}

			function navigateToDetailEditIfUserOnGridView() {
				let editTableCell = document
						.querySelector('.adwindow-layout div:nth-child(2) .adtab-content:first-child .adtab-grid tr .row-indicator-selected');
				if (util.elementIsVisible(editTableCell)) {
					let gridToggle = document
							.querySelector('.adwindow-toolbar a:nth-child(15)');
					if (gridToggle) {
						gridToggle.click();
					}
				}
			}

			function onPageClick(e) {
				handleClickNavigation(e);
				updateSiteNav();
			}

			function openTabDetailPane() {
				let openTabDetailPaneButton = document
						.querySelector('.z-south-collapsed .z-icon-chevron-up');
				if (util.elementIsVisible(openTabDetailPaneButton)
						&& !didUserCloseTheDetailPane) {
					isTabDetailPaneProgrammaticallyTriggered = true;
					openTabDetailPaneButton.click();
				}
			}

			function updateSiteNav() {
				appendLogoutButton();
				appendHomeBackButton();
				appendMobileMenuButton();
			}

			function disableZoomAccrossWindows() {
				let zoomableLabels = document
						.querySelectorAll('.z-label[style="\cursor: pointer; text-decoration: underline;color: #333;"\]');
				if (zoomableLabels == null) {
					return;
				} else {
					zoomableLabels.forEach(function(label) {
						label.style.textDecoration = 'none';
						label.style.cursor = 'default';
						label.style.pointerEvents = 'none';
					});
				}
			}

			function hideSaveWhenFinalizeOrderPresent() {
				let saveButton = document
						.querySelector("a.toolbar-button.z-toolbarbutton[title*='Alt+S']");
				let finalizeOrderButton = document
						.querySelector("div.btn[title*='Finalize']");
				if (finalizeOrderButton != null) {
					let saveNewButton = document
							.querySelector("a.toolbar-button.z-toolbarbutton[title*='Alt+A']");
					$(
							"<style>.bh.organization .adwindow-toolbar a:nth-child(7):after{content:' New'}</style>")
							.appendTo('head');
					saveButton.addEventListener("click", function(e) {
						saveNewButton.click();
					});
				} else {
					saveButton.style.visibility = 'visible';
					$(
							"<style>.bh.organization .adwindow-toolbar a:nth-child(7):after{content:' Save'}</style>")
							.appendTo('head');
				}
			}

			function hideLookupPanelOnProductsWindow(targetButton) {
				if (targetButton) {
					targetButton.click();
				}
			}

			function displaySOPanelOnDashboard() {
				let eastPanelDisplayBtn = document
						.querySelector('.window-container-toolbar-btn.context-help-btn.z-toolbarbutton');
				if (eastPanelDisplayBtn) {
					eastPanelDisplayBtn.click();
				}
				let eastPanel = document
						.querySelector('.desktop-right-column.z-east');
				eastPanel.style.background = "white";
				let parentDiv = eastPanel
						.getElementsByClassName('z-anchorchildren')[0];
				let soListWindow = document
						.querySelector('.bh-so-list-window.z-div');
				parentDiv.appendChild(soListWindow);
			}

			function appendMobileMenuButton() {
				if (document.getElementById(buttonIDs.MOBILE_MENU_BUTTON) !== null) {
					return;
				}
				var menuButton = document
						.querySelector('.desktop-header.mobile.z-div > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td:nth-child(1) > a');

				menuButton.classList.add(classNames.MOBILE_MENU);
				var menuButtonAsListItem = document.createElement('li');
				menuButtonAsListItem.appendChild(menuButton.cloneNode(true));
				menuButtonAsListItem.id = buttonIDs.MOBILE_MENU_BUTTON;
				var headerBar = document
						.querySelector('.desktop-center.z-center >.z-center-body >.desktop-tabbox.z-tabbox.z-tabbox-top >.z-tabs>.z-tabs-content');
				headerBar.insertBefore(menuButtonAsListItem,
						headerBar.childNodes[0]);

			}

            function expandDashboardMenuTabPanels() {
                let tabPanels = document
                        .querySelectorAll('.z-tabbox.z-tabbox-accordion > .z-tabpanels > .z-tabpanel');
                tabPanels.forEach(function(currentTab) {
                    let tabContent = currentTab
                            .querySelector('.z-tabpanel-content');
                    tabContent.style = "display:block";
                });
            }
            
		});
