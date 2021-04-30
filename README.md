#### BandaGo Plug-ins Parent Project

This plugin maps and resolves all bandaGo plugin dependencies and builds the deployment artifacts.
The included plugins are: 
* idemp-base
* idemp-base-editor
* idemp-webui
* idemp-rest
* idemp-base-tests (contains unit tests for idemp-base )

PS: All the plugins should be contained in a common directory location.

##### To build all bandaGo projects, run:

`mvn verify -Didempiere.home.dir=<absolute_path_to_idemp_repo/>`
Example: 
`mvn verify -Didempiere.home.dir=/home/user1/idempiere/`
