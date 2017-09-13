FROM jenkins/jenkins:lts

# Install plugins
COPY jenkins/plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/plugins.txt
RUN echo 2.0 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state

USER root

# Install Docker client
ARG DOCKER_VERSION=1.12.6
RUN curl -fsSL https://get.docker.com/builds/Linux/x86_64/docker-$DOCKER_VERSION.tgz \
    | tar --strip-components=1 -xz -C /usr/local/bin docker/docker

# Copy init files
COPY jenkins/seed.groovy /usr/share/jenkins/ref/init.groovy.d/seed.groovy
COPY jenkins/basic-security.groovy /usr/share/jenkins/ref/init.groovy.d/basic-security.groovy

USER jenkins