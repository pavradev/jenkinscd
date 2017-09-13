#!groovy

import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

println "--> creating local user 'admin'"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('admin','admin')
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)

// Disable CLI over Remoting
instance.getDescriptor("jenkins.CLI").get().setEnabled(false)

// Enable slave-to-master access control
// https://wiki.jenkins.io/display/JENKINS/Slave+To+Master+Access+Control
instance.getInjector().getInstance(jenkins.security.s2m.AdminWhitelistRule.class)
        .setMasterKillSwitch(false)

// Enable CSRF protection
// ???

instance.save()