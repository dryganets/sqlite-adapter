#!/bin/sh

./gradlew -Prelease uploadArchives closeAndReleaseRepository --info --stacktrace
