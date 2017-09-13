node {
    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/pavradev/dockerbay']]])
    stage('Build') {
        docker.image('maven:3-alpine').inside('-v $HOST_HOME/.m2:/root/.m2') { c ->
            sh 'mvn clean install'
        }
    }
}