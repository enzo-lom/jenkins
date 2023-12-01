FROM enzovalentinlombardocaridad192/jenkins:1.0.0
USER jenkins

USER root

COPY create-ssh-credentials.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY create-agents.groovy /usr/share/jenkins/ref/init.groovy.d/

USER jenkins