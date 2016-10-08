import jenkins.model.*;
import hudson.model.FreeStyleProject;
import hudson.tasks.Shell;
import javaposse.jobdsl.plugin.*;
import hudson.plugins.git.*;

project = Jenkins.instance.createProject(FreeStyleProject, "myseed")

gitSCM = new GitSCM("https://github.com/pavradev/job-dsl-gradle-example.git")

project.setScm(gitSCM)

project.getBuildersList().clear()

project.getBuildersList().add(new ExecuteDslScripts(
  new ExecuteDslScripts.ScriptLocation("false","jobs/myseed.groovy",null),
  false,
  RemovedJobAction.DELETE,
  RemovedViewAction.DELETE,
  LookupStrategy.JENKINS_ROOT,
  "src/main/groovy")
);

project.save()
