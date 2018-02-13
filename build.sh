#!/bin/bash
# Build NTL OneKey

echo Building NTL OneKey...

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
JS_FILE="`find "$SCRIPT_DIR"/app/src/main/assets/cloud/ -name ntl_onekey-*.js`"

if grep -q K_LOPT "$JS_FILE"; then
    echo Removing K_LOPT from touch layout...
    sed -i.bak -e 's/{"id":"K_LOPT","text":"\*Menu\*","sp":"1"},{"id":"K_SPACE","text":"","width":"415","sp":"0"}/{"id":"K_SPACE","text":"","width":"520","sp":"0"}/g' "$JS_FILE" && rm "$JS_FILE".bak
fi

./gradlew clean build
