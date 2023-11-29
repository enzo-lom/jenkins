container_name="jenkins-n"

docker compose -f docker-compose.yml up -d
./copykeys.sh
docker cp "./jenkins-ssh/create-ssh-credentials.groovy" "$container_name:/var/jenkins_home/"
docker compose -f agents-compose.yml up -d