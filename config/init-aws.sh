#!/bin/bash
aws sqs create-queue --queue-name book-event-queue --endpoint-url http://localhost:4566

aws dynamodb create-table \
    --table-name person \
    --attribute-definitions \
        AttributeName=id,AttributeType=S \
    --key-schema \
        AttributeName=id,KeyType=HASH \
    --provisioned-throughput \
        ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --endpoint-url http://localhost:4566