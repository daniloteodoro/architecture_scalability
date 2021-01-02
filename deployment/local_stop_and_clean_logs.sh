#!/usr/bin/env bash

# Run from the context of the script's directory
cd "$(dirname "$0")" || exit 1

cd ../checkout-job/docker || exit 1
docker-compose down
cd - || exit 1
echo "Rabbit-mq is being stopped"

cd ../order-service/docker || exit 1
docker-compose down
cd - || exit 1
echo "MongoDb is being stopped"

cd ../elk || exit 1
docker-compose down
cd - || exit 1
echo "ELK is being stopped"

if ! sudo service metricbeat stop;
then
  echo "Failure to stop metricbeat, check whether this service is installed and that you have the appropriate permissions"
fi

echo "Stopping services"
pgrep -f dependencies.jar | xargs kill
echo "Done"

rm order.log checkout.log management.log
