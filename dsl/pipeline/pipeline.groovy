package pipeline.jobs

import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

job('DSL-Tutorial-1-Test') {
    steps {
        shell('echo "Hello world!"')
    }
}
