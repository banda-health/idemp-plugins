'use strict';

// There are a few things in ZK that are kind-of using require, so we're going to rename what we're using...
var bhRequire, bhDefine;
bhRequire = bhRequire || require;
bhDefine = bhDefine || define;
// require = null; // <-- Don't delete this one because it's used somewhere else...?
define = null;

var baseUrl = document.currentScript.src.split('/main.js')[0];
baseUrl = baseUrl && baseUrl.split('webui/')[1];

bhRequire.config({
	baseUrl,
	paths: {
		html: '../html',
	},
});

requirejs(['bandahealth', 'bandahealth.login'], () => {});
