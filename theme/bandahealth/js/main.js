
'use strict';

require.config({
	baseUrl: 'theme/bandahealth/js'
});

requirejs(['bandahealth', 'bandahealth.login'], function (bandahealth, bhLogin) {});
