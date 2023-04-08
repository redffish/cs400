#!/bin/bash
echo "Content-type: text/html"
echo ""
cat htmlPart1.html
/usr/lib/jvm/java-1.8.0/bin/java -cp . HandleHTML "$QUERY_STRING" 2>&1
cat htmlPart2.html
