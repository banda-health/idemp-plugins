#### BandaGo Plug-ins Project

A repository that houses all our Banda Health's plugins for iDempiere.

This resolves all BandaGo plugin dependencies and builds the deployment artifacts.
The included plugins are: 
* idemp-base
* idemp-base-editor
* idemp-webui
* idemp-rest

##### To build all BandaGo projects, run:

`mvn verify -Didempiere.home.dir=<absolute_path_to_idemp_repo/>`
Example: 
`mvn verify -Didempiere.home.dir=/home/user1/idempiere/`
