
'use strict';

define(['helper/util', 'text!html/templates.html!strip'], function (util, templates) {
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
