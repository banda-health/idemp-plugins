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
Idemp-rest is a plug-in and therefore requires BandaGo to be setup and running. In addition the [idemp-base]() and [idemp-base-editor]() need to be installed 
in Idempire before installing this plugin. 
 That done, get the code for the plug-in [here](https://code.openhmisafrica.org/bhgo/idemp-rest).
Fork the project and clone it to you GitLab repository, then import it into Eclipse IDE.

In the plugin root directory, run the following command
`mvn validate` then `mvn build`

To 

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



