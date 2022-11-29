# iDempiere Reports | ![TeamCity build status](https://teamcity.bandahealth.org/app/rest/builds/buildType:id:BHGO_Reports_Build_BuildDevelop/statusIcon.svg)

## Get Files for iDempiere
Download the repository and run the following command in the root:
```
mvn jasperreports:jasper
```

Afterwards, all reports will be compiled in the `./target` directory. Our leverage of reports in iDempiere requires a flat structure, so you can run something like the following command to get all the files in a single location:
```
# make the directory (if it doesn't exist)
mkdir target-flat

# copy all files ending in jasper to the new, flattenend directory
find ./target -type f | grep -i jasper$ | xargs -i cp {} target-flat
```
