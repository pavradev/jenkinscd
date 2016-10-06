docker run --rm -it -p 8080:8080 -v $PWD/seed.groovy:/usr/share/jenkins/ref/init.groovy.d/seed.groovy:ro -v $PWD:/var/jenkins_home/workspace/seed:ro myjenkins
