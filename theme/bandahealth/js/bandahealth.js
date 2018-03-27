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
		document.querySelector('body').classList.add(roleClass);
	}
	
	function removeRoleClass(roleClass) {
		document.querySelector('body').classList.remove(roleClass);
	}
	
	function userIsOrg(){
		addRoleClass(org);
	}
	
	function userIsClientAndOrg(){
		removeRoleClass(org);
	}
})();



