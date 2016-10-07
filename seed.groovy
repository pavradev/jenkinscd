import jenkins.model.*;
import hudson.model.FreeStyleProject;
import hudson.tasks.Shell;
import javaposse.jobdsl.plugin.*;
import hudson.plugins.git.*;

project = Jenkins.instance.createProject(FreeStyleProject, "seed")

gitSCM = new GitSCM("https://github.com/pavradev/jenkinscd.git")

project.setScm(gitSCM)

project.getBuildersList().clear()

project.getBuildersList().add(new ExecuteDslScripts(
  new ExecuteDslScripts.ScriptLocation("false","dsl/seed/*.groovy",null),
  false,
  RemovedJobAction.DELETE,
  RemovedViewAction.DELETE,
  LookupStrategy.JENKINS_ROOT,
  "src/main/groovy")
);

project.save()
