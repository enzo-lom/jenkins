# Jenkins Docker Setup

This repository contains scripts and configuration files to set up a Jenkins server using Docker containers. The setup includes a Jenkins master and multiple Jenkins agents running in Docker containers.

## Prerequisites

Make sure you have Docker and Docker Compose installed on your machine.

## Usage

### 1. Run Jenkins Server

Execute the `run.sh` script to start the Jenkins master container:

```bash
./run.sh
```
This script uses Docker Compose to launch the Jenkins master container and copies SSH keys to enable communication with Jenkins agents.

### 2. Set Up Jenkins Agents
Run the following Docker Compose command to start Jenkins agents:

```bash
docker-compose -f agents-compose.yml up -d
```
This will create Jenkins agent containers with SSH connectivity.

### 3. Jenkins Plugins
The Jenkins master is configured with the following plugins:

xvfb
workflow-aggregator
git
ssh
ssh-agent
ant
pipeline-maven
junit
cobertura
jacoco
github
code-coverage-api
git-parameter
warnings-ng
configuration-as-code
copyartifact
htmlpublisher
performance
custom-tools-plugin
junit-attachments
ssh-slaves

### 4. Docker Compose Configuration
The docker-compose.yml file defines services for Jenkins master, Docker (for Docker-in-Docker), and Socat.

### 5. Copy SSH Keys
The copykeys.sh script copies the public key from the Jenkins master to the local environment file. Run it after starting the Jenkins master container:
```bash
./copykeys.sh
```
### 6. Jenkins Agents Configuration
The agents-compose.yml file defines services for Jenkins agents. Each agent runs in a separate Docker container.

### 7. Jenkins Master Dockerfile
The Dockerfile in the root directory sets up the Jenkins master container. It includes the installation of necessary tools and plugins.

### 8. Jenkins SSH Dockerfile
The jenkins-ssh/Dockerfile extends the Jenkins master Dockerfile and includes additional configurations for SSH.

### 9. Jenkins SSH Scripts
The jenkins-ssh/create-ssh-credentials.groovy script creates SSH credentials for Jenkins agents, and jenkins-ssh/create-agents.groovy script automatically adds Jenkins agents using SSH.

## Notes
Ensure Docker is properly configured on your machine.
Make sure to customize variables, paths, and configurations based on your requirements.
