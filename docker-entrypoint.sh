#!/usr/bin/env bash
set -e

touch .unhealthy

cd ./base-test
./runTests.sh

cd ../rest-test
./runTests.sh

cd ../reports-test
./runTests.sh

cd ../
rm .unhealthy
exec "$@"
