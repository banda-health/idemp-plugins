/**
 * Set dashboard panels returned to no display
 */

let bandahealth = (function () {
	document.querySelector("body").classList.add("bh");
	
	return {
		addRoleClass: addRoleClass,
		removeRoleClass: removeRoleClass
	};
	
	function addRoleClass(roleClass) {
		document.querySelector("body").classList.add(roleClass);
	}
	
	function hideDashboard(dashboardClass){
		var elements = document.getElementsByClassName(dashboardClass);
		for(var x = 0; x < elements.length; x++){
			elements[x].style.display = "none";
		}
	}
	
	function removeRoleClass(roleClass) {
		document.querySelector("body").classList.remove(roleClass);
	}
})();