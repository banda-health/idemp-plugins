'use strict';

// There are a few things in ZK that are kind-of using require, so we're going to rename what we're using...
var bhRequire, bhDefine;
bhRequire = bhRequire || require;
bhDefine = bhDefine || define;
// require = null; // <-- Don't delete this one because it's used somewhere else...?
define = null;

bhRequire.config({
	baseUrl: 'theme/bandahealth/js',
	paths: {
		html: '../html',
	},
});

requirejs(['bandahealth', 'bandahealth.login'], () => {});
