FROM enzovalentinlombardocaridad192/jenkins:1.0.0
USER jenkins

RUN ssh-keygen -t rsa -b 2048 -f ~/.ssh/id_rsa -N "" -q

USER root

COPY create-ssh-credentials.groovy /usr/share/jenkins/ref/init.groovy.d/

USER jenkins