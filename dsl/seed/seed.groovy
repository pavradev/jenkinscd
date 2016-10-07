package pipeline.jobs

import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

job('pipeline') {
    parameters {
        stringParam('REPO')
        stringParam('BRANCH')
    }
    steps {
        dsl {
	    text(readFileFromWorkspace('dsl/pipeline/pipeline.groovy'))
	    removeAction('DELETE')
        }
    }
}
queue('DSL-Tutorial-1-Test')
