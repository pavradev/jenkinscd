import de.gesellix.docker.client.DockerClientImpl

class DockerHelper {

    public static gradle(cmd) {

        def dockerClient = new DockerClientImpl()
        def image = "gradle:4.0.1-jre8-alpine"
        //def cmds = ["mvn", "info"]
        def containerConfig = ["Cmd"       : cmd,
                              // "Volumes"   : ["jenkinshome" : "/usr/src/mymaven"],
                               "WorkingDir": "/jenkins/workspace/${env.JOB_NAME}",
                               "HostConfig": [
                                       "Binds": ["jenkinshome:/jenkins"]
                               ]]
        def result = dockerClient.run(image, containerConfig).content
        print result
    }
}
