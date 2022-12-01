'use strict';

bhDefine(['text!html/templates.html!strip'], function (templates) {
	let self = {};

	let tempDiv = document.createElement('div');
	tempDiv.innerHTML = templates;
	while (tempDiv.firstChild) {
		document.body.appendChild(tempDiv.firstChild);
	}

	self.getTemplate = function getTemplate(templateId) {
		let template = document.getElementById(templateId);
		return document.importNode(template.content, true);
	};

	return self;
});
