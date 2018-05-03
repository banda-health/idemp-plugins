
'use strict';

define(['helper/util'], function (util) {
	let self = {};

	self.getTemplate = function getTemplate(templateId) {
		let template = document.getElementById(templateId);
		return document.importNode(template.content, true);
	};

	return self;
});
