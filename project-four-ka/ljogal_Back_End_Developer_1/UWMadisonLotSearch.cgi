#!/bin/bash
echo "Content-type: text/html"
echo ""
cat first-half.html
java='/usr/lib/jvm/java-1.8.0/bin/java'  # Correct binary on the CGI server
if [[ ! -e $java ]]; then
    java='java'
fi
"$java" P4Webpage "$QUERY_STRING" 2>&1
cat second-half.html
