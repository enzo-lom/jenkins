import com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey
import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl
import com.cloudbees.plugins.credentials.CredentialsStore
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials
import com.cloudbees.jenkins.plugins.sshcredentials.SSHUserPrivateKey
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.impl.*
import hudson.util.Secret
import java.nio.file.Files
import net.sf.json.JSONObject
import org.jenkinsci.plugins.plaincredentials.impl.*

import jenkins.model.*
import jenkins.security.*
import hudson.model.*
import hudson.security.*

// create-ssh-credentials.groovy
def privateKey = new File('var/jenkins_home/.ssh/id_rsa').text

def credentialsId = 'privatekey-master'
def username = 'jenkins'

def credentials = new BasicSSHUserPrivateKey(
    CredentialsScope.GLOBAL, 
    credentialsId, 
    username, 
    new BasicSSHUserPrivateKey.DirectEntryPrivateKeySource(privateKey),
    null,
    null,
)

// Get the Jenkins credentials store
def credentials_store = jenkins.model.Jenkins.instance.getExtensionList(
        'com.cloudbees.plugins.credentials.SystemCredentialsProvider'
    )[0].getStore()

// Add the credentials to the store
credentials_store.addCredentials(Domain.global(), credentials)
