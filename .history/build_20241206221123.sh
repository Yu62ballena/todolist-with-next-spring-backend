#!/usr/bin/env bash
set -o errexit

java -version
./gradlew clean build -x test