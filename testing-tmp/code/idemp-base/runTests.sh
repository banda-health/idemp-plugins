#!/usr/bin/env bash

# Change to the directory this script is in
cd "${0%/*}"

RETRIES=30

until wget --spider --server-response http://idempiere:8080 >/dev/null 2>&1 || [[ $RETRIES == 0 ]]; do
    echo "Waiting for iDempiere server, $((RETRIES--)) remaining attempts..."
    sleep 1
done

if [[ $RETRIES == 0 ]]; then
    echo "Shutting down..."
    exit 1
fi

# Send the SOAP request to run the tests
wget http://idempiere:8080/ADInterface/services/ModelADService --post-file=request.xml -O testResults.xml > /dev/null 2>&1

if [[ -f "testResults.xml" ]]; then
  # Parse the results
  # Get the summary message
  touch testResults.txt > /dev/null 2>&1

  # Set the file header
  echo "++++++++++++++++++++++++++++++++++" > testResults.txt
  echo "idemp-base Tests" >> testResults.txt
  echo "++++++++++++++++++++++++++++++++++" >> testResults.txt

  xmllint --xpath 'string(//*[name()="soap:Envelope"]/*[name()="soap:Body"]/*[name()="ns1:runProcessResponse"]/*[local-name()="RunProcessResponse"]/*[local-name()="Summary"])' testResults.xml >> testResults.txt
  # Get the returned HTML string
  xmllint --xpath 'string(//*[name()="soap:Envelope"]/*[name()="soap:Body"]/*[name()="ns1:runProcessResponse"]/*[local-name()="RunProcessResponse"]/*[local-name()="LogInfo"])' testResults.xml >> tmp.txt
  xmllint --html --xpath '//table/tr/td/text()' tmp.txt >> testResults.txt

#  Set the file footer
  echo "" >> testResults.txt
  echo "" >> testResults.txt

  rm testResults.xml > /dev/null 2>&1
  rm tmp.txt > /dev/null 2>&1
else
  echo "There was an error submitting the test SOAP request"
fi