/**
 * Set dashboard panels returned to no display
 */


let bandahealth = (function () {

	let org = 'organization';
	
	document.querySelector('body').classList.add('bh');
	
	return {
		userIsOrg: userIsOrg,
		userIsClientAndOrg: userIsClientAndOrg
	};
	
	function addRoleClass(roleClass) {
		document.querySelector('body').classList.add(orgClass);
	}
	
	function removeRoleClass(roleClass) {
		document.querySelector('body').classList.remove(orgClass);
	}
	
	function userIsOrg(){
		addRoleClass(org);
	}
	
	function userIsClientAndOrg(){
		removeRoleClass(org);
	}
})();



