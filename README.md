# BandaGo iDempiere Project | ![TeamCity build status](https://teamcity.bandahealth.org/app/rest/builds/buildType:id:BHGO_IDempiereBanda_BuildDevelop/statusIcon.svg)
A repository that houses all Banda Health's plugins, data import files, DB migrations, and reports for iDempiere. 

## Plugins
The modular architecture of iDempiere allows us to build custom functionality onto existing layers without affecting the core functionality of the ERP. Our plugins are built to implement these features. You can read more on iDempiere's architecture in [iDempiere and Modularity](https://wiki.idempiere.org/en/Equinox_OSGi_framework). 

The included plugins are: 
* base
* base-editor
* webui
* rest

The plugins handle the following things:
| Plugin | Description |
|-|-|
| base | All custom BandaGo models, model events, processes, and callouts are contained in this plugin. |
| ~~base-editor~~ | **DEPRECATED**<br>Defines a custom ribbon that holds navigation buttons. These buttons allow the user to move between different windows of the system and also complete tasks. |
| rest | Provides a RESTful API interface to the business functionality implemented in BandaGo. |
| ~~webui~~ | **DEPRECATED**<br>Most of the UI customization can be found in this plugin. It contains 'BandaGo' look-and-feel customization, implementation for the main menu widget, terms of service and data metrics functionality. |

### Test Plugins
We also have several plugins that are meant to run unit tests on the system. These are not deployed to our environments but are only used in our CI/CD pipelines. The plugins are:
| Test Plugin | Description |
|-|-|
| test | Runs tests to ensure the model events & processes are handled correctly. |
| reports-test | Run reports to confirm that reports generate correctly with the appropriate values. |
| rest-test | Tests workflows and calls to our API to validate the system operates correctly. |

## Data Imports
Additionally, the project also contains the data folders used during client creation. To leverage these files (located in the `data` directory) in your local instance, copy this directory to your `[IDEMPIERE_HOME]` directory, or see [Building the Plugins](#building-the-plugins) below.

## Reports
Located in the `./reports` directory, these are reports available to our iDempiere installation, from receipts to patient transactions.

## DB Migration
Located in the `./migration` directory, these files are used to automate iDempiere DB migrations. They also house our custom functions that are stored in the DB.


## Building the Plugins & Project
To build all BandaGo plugins and place files in the correction location, run:
```
mvn verify -Didempiere.home.dir=<absolute_path_to_idemp_repo/>
```
Example: 
`mvn verify -Didempiere.home.dir=/home/user1/idempiere/`

You can also configure your global settings so you don't have to provide the property each time. In your global settings file, set:
```
<settings ...>
  ...
  <profiles>
  <profile>
    <id>local-idempiere</id>
    <properties>
      <idempiere.home.dir>/home/user1/idempiere/</idempiere.home.dir>
    </properties>
  </profile>
  </profiles>
</settings>
```

This will build the plugins, compile the reports, and move data imports, DB migration files, and compiled reports into their correct directories in you iDempiere installation directory.

## Running Tests
A database (DB) is needed to run tests (we test business logic, not implementation logic). You can either use your own and have test data be filled in it, or you can use a fresh DB. The Banda Health iDempiere image comes with data to initialize a new DB, if you'd like. Check the `.env.default` file for information that's available, plus the [Banda iDempiere Docker Image Repo](https://github.com/banda-health/idempiere-docker) for full image information.

Regardless of which DB you used, you will need an active `Gardwen World` client that comes with the base iDempiere DB & installation. The tests are run against this client and the SOAP webservices are configured as this client.

### Getting a separate, test DB
The [CI builds](https://teamcity.bandahealth.org/buildConfiguration/BHGO_IdempMigration_Build_BuildDevelop) output a DB file that has the scripts and 2-packs run on top of a base iDempiere DB. You can get this file, then restore it to a DB of your chooseing by running:
```
pg_restore -d [database_name] [db_file]
```
You can optionally add the user and hostname/port flags, if needed.

### Base Plugin & Report Testing
For the base plugin tests and for reports, you can run them
1. [Through the UI](#in-the-ui) or
2. [Through Docker compose](#through-docker-compose)

#### In the UI
Log in as the Garden World client and search for `Populate` to see the screen appear. You can enter the number of loops and an optional package for your tests. This is based off [Chuck's testing framework](https://erp-academy.chuckboecking.com/?page_id=3711).

#### Through Docker Compose
Simply build the plugins and run `docker compose up` to run the tests. Any container that doesn't finish running in a healthy state had tests fail.

### Rest API Tests
These are run via Jest to connect to the server and test the endpoints. It is a TypeScript project that needs the types the API returns. These are automatically generated by building the `rest` plugin, so please do that first.

You can spin up the Docker container to run these tests, or you can run them on your machine if you provide the following environment variables for connecting:
* `IDEMPIERE_ENDPOINT`
* `IDEMPIERE_USER`
* `IDEMPIERE_USER_PASSWORD`

Then just run the tests via the Jest CLI.

#### In Development
There exists a `docker-compose.dev.yml` to allow easier running of the API tests while developing. This compose file spins up the container without running anything, then mounts the JS code to the container.

To leverage this,
1. Get iDempiere up and running (with a test or your regular DB).
2. Run `docker compose -f docker-compose.dev.yml up --build`.
3. After the container is running, attach to it via `docker compose -f docker-compose.dev.yml exec rest-test /bin/bash`.
4. Execute `jest` to run the tests.

You can also adjust the test client used in the REST tests (since no hard-coding through a SOAP request is required) via the `.env` file. 
