###idemp-rest

#### Overview

idemp-rest is an OSGi module that plugs into [BandaGo](https://wiki.openhmisafrica.org/wiki/bandago/view/Developer%20Guide/How%20to%20Setup%20BandaGo/)
,a customised application based on Idempiere ERP](https://www.idempiere.org/).
idemp-rest provides a RESTful API interface to the business functionality implemented in BandaGo.

#### Table of Contents
* Prerequisites
* Installation
* Documentation
* Resources
* Contributing
* Support

#### Prerequisites
Before setting up this plugin, you should ensure that the following requirements have been installed and working.
* Java OpenJDK 11 or 12 
* Maven 3.6.0 or later.
* BandaGo Application([Instructions on setup](https://wiki.openhmisafrica.org/wiki/bandago/view/Developer%20Guide/How%20to%20Setup%20BandaGo/))
* 

#### Installation
* From your GitLab account, fork the `idemp-rest` [here](https://code.openhmisafrica.org/bhgo/idemp-rest) and clone it to your local development workstation.
* From the `idemp-parent` repository (this project should be present if you setup BandaGo correctly), run `mvn verify`, this command will validate, compile, build and package all your plug-in projects.
To deploy the plugin to the server, in Eclipse, go to Run Configurations, choose the Plugins tab and from the list, ensure that the rest plugin 
with the name select the *org.idempiere.bandahealth.rest* is shown. You can change the autostart option to `true`. When the server is started, the plugin will be 
automatically started.

#### Documentation

- [Website](http://bandahealth.org)
  
- [Greenlight Demo Site](http://demo.bandahealth.org)

- [Greenlight User Documentation](https://wiki.openhmisafrica.org/wiki/greenlight/view/Main/) 



#### Resources
* [BandaGo Developer Guide](https://wiki.openhmisafrica.org/wiki/bandago/view/Developer%20Guide/)

#### Contributing
To contribute, see the CONTRIBUTING.md file in the root directory of this repository.

#### Support
To reach out to the team, please use our RocketChat service [here](https://chat.openhmisafrica.org/home), alternatively 
send an email to; implementers@bandahealth.org



