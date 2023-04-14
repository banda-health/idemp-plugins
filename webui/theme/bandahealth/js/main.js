
'use strict';

require.config({
	baseUrl: 'theme/bandahealth/js',
	paths: {
		html: '../html'
	}
});

requirejs(['bandahealth', 'bandahealth.login'], function (bandahealth, bhLogin) {});
