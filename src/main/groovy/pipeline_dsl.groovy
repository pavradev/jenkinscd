String safeJobName = "$repoName".replaceAll("/", "-")
pipelineJob(safeJobName) {
    scm {
        github "$repoName"
    }
    definition {
        cpsScm {
            scm {
                github "$repoName"
            }
            scriptPath('pipeline.groovy')
        }
    }
}