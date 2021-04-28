cat words.txt | tr ' ' '\n' | sort | uniq -c | sort -r | awk '{if($2 != "") print $2" "$1}'
