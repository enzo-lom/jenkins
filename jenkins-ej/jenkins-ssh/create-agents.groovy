import hudson.model.*
import hudson.slaves.*
import jenkins.model.*
import hudson.plugins.sshslaves.*
 
def nombresDeNodos = ['jenkins-agent1', 'jenkins-agent2', 'jenkins-agent3']
def puertoSSH = 22
 
for (int i = 0; i < nombresDeNodos.size(); i++) {
    def sshLauncher = new hudson.plugins.sshslaves.SSHLauncher(
        nombresDeNodos[i],           // Dirección del host
        puertoSSH,         // Puerto SSH desde el array
        'privatekey-master',        // ID de la credencial SSH configurada en Jenkins
    )
 
    def sshSlave = new DumbSlave(
        nombresDeNodos[i],      // Nombre del nodo desde el array
        '/home/jenkins',   // Directorio de trabajo del nodo
        sshLauncher              // Configuración de lanzamiento SSH
    )

    sshSlave.setLabelString("jenkins-agent")
 
    Jenkins.instance.addNode(sshSlave)
}