
job('create-pipeline') {
    parameters {
        stringParam('repoName')
    }
    steps {
        dsl {
            text(readFileFromWorkspace('src/main/groovy/pipeline_dsl.groovy'))
        }
    }
}