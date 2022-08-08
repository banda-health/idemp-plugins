#!/usr/bin/env bash
set -e

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
  echo "idemp-rest Tests" >>testResults.txt
  echo "++++++++++++++++++++++++++++++++++" >>testResults.txt

  xmllint --xpath 'string(//*[name()="soap:Envelope"]/*[name()="soap:Body"]/*[name()="ns1:runProcessResponse"]/*[local-name()="RunProcessResponse"]/*[local-name()="Summary"])' testResults.xml >>testResults.txt
  # Get the returned HTML string
  xmllint --xpath 'string(//*[name()="soap:Envelope"]/*[name()="soap:Body"]/*[name()="ns1:runProcessResponse"]/*[local-name()="RunProcessResponse"]/*[local-name()="LogInfo"])' testResults.xml >>tmp.txt

  # Some versions of iDempiere don't return the results, so confirm that first
  grep -q '[^[:space:]]' < "tmp.txt" && xmllint --html --xpath '//table/tr/td/text()' tmp.txt >>testResults.txt

  # Set the file footer
  echo "" >>testResults.txt
  echo "" >>testResults.txt

  [ -f "testResults.txt" ] && rm testResults.txt
  [ -f "tmp.txt" ] && rm tmp.txt
else
  echo "There was an error submitting the test SOAP request"
fi

echo "Finished tests!"
cat testResults.txt

if grep -q "FAIL" testResults.txt; then
  exit 1
fi

jest --ci

rm .unhealthy
exec "$@"
