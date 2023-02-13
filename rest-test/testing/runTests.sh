#!/usr/bin/env bash

[ -f "testResults.txt" ] && rm testResults.txt
# Send the SOAP request to run the tests
wget "${IDEMPIERE_ENDPOINT}/ADInterface/services/ModelADService" --post-file=request.xml -O testResults.xml >/dev/null 2>&1

if [[ -f "testResults.xml" ]]; then
  # Parse the results
  # Get the summary message
  touch testResults.txt >/dev/null 2>&1

  # Set the file header
  echo "++++++++++++++++++++++++++++++++++" >testResults.txt
  echo "rest Tests" >>testResults.txt
  echo "++++++++++++++++++++++++++++++++++" >>testResults.txt

  xmllint --xpath 'string(//*[name()="soap:Envelope"]/*[name()="soap:Body"]/*[name()="ns1:runProcessResponse"]/*[local-name()="RunProcessResponse"]/*[local-name()="Summary"])' testResults.xml >>testResults.txt
  # Get the returned HTML string
  xmllint --xpath 'string(//*[name()="soap:Envelope"]/*[name()="soap:Body"]/*[name()="ns1:runProcessResponse"]/*[local-name()="RunProcessResponse"]/*[local-name()="LogInfo"])' testResults.xml >>tmp.txt

  # Some versions of iDempiere don't return the results, so confirm that first
  grep -q '[^[:space:]]' <"tmp.txt" && xmllint --html --xpath '//table/tr/td/text()' tmp.txt >>testResults.txt

  # Set the file footer
  echo "" >>testResults.txt
  echo "" >>testResults.txt

  [ -f "testResults.xml" ] && rm testResults.xml
  [ -f "tmp.txt" ] && rm tmp.txt
else
  echo "There was an error submitting the test SOAP request"
fi

cat testResults.txt

psql -c "select case when description = 'Error' then 'FAIL' else 'PASS' end as status, name as test_suite, round(executiontime / 1000, 3) as \"execution_time [s]\", case when description = 'Error' then note end as result from chuboe_populateresponse where lower(classname) like 'org.bandahealth.idempiere.rest.test%' order by created"

if ! grep -q "Success!!" testResults.txt; then
  exit 1
fi

# There's something wrong with running Jest in sequence and it won't output any results (both --runInBand and --maxWorkers=1
# don't output log files). Also, something is wrong with Jest and it's not outputting the results, so we have to do it
# manually. So, loop over the test files so Jest can run one test at a time in parallel. 😂
{ echo && echo "Running Jest Tests..."; }

# Find the tests like Jest does
[ -f "tests-to-execute.txt" ] && rm tests-to-execute.txt
touch tests-to-execute.txt
find ./src -type f -regex '.*\/__tests__\/.*\.[jt]sx\?' | sed 's/\.\///' >>tests-to-execute.txt
find ./src -type f -regex '.*\/\?.*\(spec\|test\)\.[tj]sx\?' | sed 's/\.\///' >>tests-to-execute.txt

[ -f "full-test-results.txt" ] && full-test-results.txt
touch full-test-results.txt
while IFS= read -r line; do
  [ -f "jestResults.json" ] && rm jestResults.json
  touch jestResults.json
  jest --silent --json --outputFile=jestResults.json "$line"
  waitCounter=0
  until [ -s jestResults.json ] || [ $waitCounter -gt 29 ]; do
    sleep 1
    ((waitCounter++))
  done
  jq -r '.testResults[]|if .status=="passed" or .status=="focused" then "PASS "+.name+" ("+((.endTime-.startTime)/1000000|tostring)+")" else "FAIL "+.name+"\n"+.message+"\n" end' <jestResults.json >>full-test-results.txt
done <tests-to-execute.txt

cat full-test-results.txt
{ echo && echo; }
if grep -q "FAIL " full-test-results.txt; then
  exit 1
fi
