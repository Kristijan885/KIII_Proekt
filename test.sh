#!/bin/bash

workers=("citus-worker-0" "citus-worker-1" "citus-worker-2")
query="SELECT COUNT(*) FROM book;"

for worker in "${workers[@]}"; do
    echo "Querying $worker..."
    result=$(kubectl exec -it "$worker" -n book-ranker -- psql -U postgres -d books -c "$query")
    echo "Result from $worker: $result"
done
