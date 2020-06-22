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
* BandaGo System setup([Instructions on setup](https://wiki.openhmisafrica.org/wiki/bandago/view/Developer%20Guide/))
* **Important** To be able to work with the BandaHealth GitLab repositories, you need to setup `ssh` access on your GitLab account [See this](https://docs.gitlab.com/ee/ssh/#options-for-ssh-keys)

#### Installation
* From the steps in bandaGo system setup, you should, at this point, have all required BandaGo plug-ins in a common parent directory.
* In Eclipse, use the 'Open Projects From FileSystem' option to import the project into your workspace.
* In the Project Explorer, right click on the project and choose 'Clean', the project will be rebuild with all dependencies being added.
* To deploy the plug-in to the server, in Eclipse, go to 'Run Configurations', choose the 'Plugins' tab and from the list, in the filter box, search 'banda' to filter the just imported plugin and ensure that the rest plugin with the name select the *org.idempiere.bandahealth.rest* is shown. Change the autostart option to `true`. When the server is started, this sets the plugin to be installed into Idempiere and automatically started. 
* You are now ready to work with this project for features and bug fixes!.

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
send an email to; implementer@bandahealth.org



