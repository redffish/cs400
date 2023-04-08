#!/bin/bash
echo "Content-type: text/html"
echo ""
cat first-half.html
/usr/lib/jvm/java-1.8.0/bin/java -cp . P4Webpage "$QUERY_STRING" 2>&1
cat second-half.html
