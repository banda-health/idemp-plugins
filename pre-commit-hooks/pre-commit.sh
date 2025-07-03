#! /bin/sh -e

# Prevent .classpath files from being modified
REGEX='.*\.classpath'
git diff --name-only --cached | grep -qxE "$REGEX" && { echo "❌ Excluded file included in the commit:"; git diff --name-only --cached | grep -E "$REGEX"; exit 1; }
