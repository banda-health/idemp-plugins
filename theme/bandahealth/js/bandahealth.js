/**
 * Set dashboard panels returned to no display
 */

let bandahealth = (function () {

	let classNames = {
		BH: 'bh',
		ORGANIZTION: 'organization',
		CLIENT: 'client',
		SYSTEM: 'system'
	};

	addClassName(classNames.BH);
	addClassName(classNames.SYSTEM);

	return {
		userIsOrg: userIsOrg,
		userIsClientAndOrg: userIsClientAndOrg
	};

	function addClassName(className) {
		document.querySelector('body').classList.add(className);
	}

	function removeClassName(className) {
		document.querySelector('body').classList.remove(className);
	}

	function userIsOrg() {
		removeClassName(classNames.SYSTEM);
		addClassName(classNames.ORGANIZTION);
	}

	function userIsClientAndOrg() {
		removeClassName(classNames.SYSTEM);
		addClassName(classNames.CLIENT);
	}
})();



