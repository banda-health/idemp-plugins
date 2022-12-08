#!/usr/bin/env bash

touch .unhealthy

[ -f "testResults.txt" ] && rm testResults.txt
# Send the SOAP request to run the tests
wget "${IDEMPIERE_ENDPOINT}/ADInterface/services/ModelADService" --post-file=request.xml -O testResults.xml >/dev/null 2>&1

if [[ -f "testResults.xml" ]]; then
  # Parse the results
  # Get the summary message
  touch testResults.txt >/dev/null 2>&1

  # Set the file header
  echo "++++++++++++++++++++++++++++++++++" >testResults.txt
  echo "idemp-reports Tests" >>testResults.txt
  echo "++++++++++++++++++++++++++++++++++" >>testResults.txt

  xmllint --xpath 'string(//*[name()="soap:Envelope"]/*[name()="soap:Body"]/*[name()="ns1:runProcessResponse"]/*[local-name()="RunProcessResponse"]/*[local-name()="Summary"])' testResults.xml >>testResults.txt
  # Get the returned HTML string
  xmllint --xpath 'string(//*[name()="soap:Envelope"]/*[name()="soap:Body"]/*[name()="ns1:runProcessResponse"]/*[local-name()="RunProcessResponse"]/*[local-name()="LogInfo"])' testResults.xml >tmp.txt

  # Some versions of iDempiere don't return the results, so confirm that first
  grep -q '[^[:space:]]' < "tmp.txt" && xmllint --html --xpath '//table/tr/td/text()' tmp.txt >>testResults.txt

  # Set the file footer
  echo "" >>testResults.txt
  echo "" >>testResults.txt

  [ -f "testResults.xml" ] && rm testResults.xml
  [ -f "tmp.txt" ] && rm tmp.txt
else
  echo "There was an error submitting the test SOAP request"
fi

echo "Finished tests!"
cat testResults.txt

psql -c "select case when description = 'Error' then 'FAIL' else 'PASS' end as status, name as test_suite, round(executiontime / 1000, 3) as \"execution_time [s]\", case when description = 'Error' then note end as result from chuboe_populateresponse where lower(classname) like 'org.bandahealth.idempiere.report.test%' order by created"

if ! grep -q "Success!!" testResults.txt; then
  exit 1
fi

rm .unhealthy
exec "$@"
