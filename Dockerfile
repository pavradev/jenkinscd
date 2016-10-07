FROM jenkins:2.7.4
COPY plugins.txt /usr/share/jenkins/ref/
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/plugins.txt
COPY seed.groovy /usr/share/jenkins/ref/init.groovy.d/seed.groovy
