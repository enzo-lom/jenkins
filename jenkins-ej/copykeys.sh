#!/bin/bash

# Set the container name or ID
container_name="jenkins-n"

# Set the path to the local environment file
env_file=".env"


# Check if the container is running
if docker inspect -f '{{.State.Running}}' "$container_name" &> /dev/null; then
    # Copy the public key from the container to the local machine
    docker exec -d "$container_name" sh -c 'echo "JENKINS_AGENT_SSH_PUBKEY=$(cat ~/.ssh/id_rsa.pub)" > /var/jenkins_home/.env'
    docker cp "$container_name:/var/jenkins_home/.env" "$env_file"

    echo "Public key copied to $env_file"
else
    echo "Container is not running: $container_name"
fi