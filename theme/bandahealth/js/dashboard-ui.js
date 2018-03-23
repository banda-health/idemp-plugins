/**
 * Set dashboard panels returned to no display
 */

function hideDashboard(dashboardClass){
	var elements = document.getElementsByClassName(dashboardClass);
	for(var x = 0; x < elements.length; x++){
		elements[x].style.display = "none";
	}
}

(function () {
	let bodyTag = document.querySelector("body");
	bodyTag.classList.add("bh");
})();