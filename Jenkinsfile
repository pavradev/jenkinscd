node {
  stage 'Build'
    docker run --rm -v jenkinshome:/project  -w /project gradle:4.0.1-jre8-alpine gradle
    echo 'build'

  stage 'Deployment complete'
    echo 'Send emails and be happy to have something deployed to production'
}

