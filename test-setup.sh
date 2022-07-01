#!/usr/bin/env bash

# Repeat given char 80 times using shell function
repeat(){
  end=$2
	for ((i=0;i<=end;i++)); do echo -n "$1"; done
}

# Start the servers
echo "Starting iDempiere..."
docker compose up -d

# Wait for the idempiere service to be healthy (will only wait 3 minutes
retries=180
waitMessage="Waiting for iDempiere container to be healthy"
echo -ne "$waitMessage"
maxDecimals=3
counter=0
until [ "$(docker inspect -f {{.State.Health.Status}} $(docker compose ps -q idempiere))" == "healthy" ] || [ retries == 0 ]; do
  ((retries--))
  ((counter=++counter % maxDecimals))
  echo -ne "\033[2K"; printf "\r"
  echo -ne "$waitMessage$(repeat "." counter)"
  sleep 1
done

echo -ne "$pc%\033[OK\r"
echo -ne "$waitMessage$(repeat "." 3)"

if [ $retries == 0 ]; then
  # We failed
  echo "Failed!"
  echo "Shutting down..."
  docker compose down
  exit 1
else
  echo "Succeeded!"
fi

# Run the tests
echo "Running tests..."
docker compose exec idempiere /bin/bash "/home/src/code/idemp-base/runTests.sh"

# Shut down the containers
echo "Tests complete - shutting down iDempiere"
docker compose down

if [ `find testing -name "testResults.txt" 2>/dev/null | wc -l ` == 0 ]; then
  echo "No tests were run..."
  exit 0
fi

# Loop through the results and see if anything failed and exit if so
echo "Test results:"
find testing -name "testResults.txt" | xargs cat

if find testing -name "testResults.txt" | xargs cat | grep -q "FAIL "; then
  exit 1
fi
