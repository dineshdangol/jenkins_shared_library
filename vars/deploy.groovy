def call(String ProjectName, String Port, String Tag){
	withCredentials([usernamePassword(credentialsId: 'dockerHub', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]){
                    sh """
                        echo "Remove previously existing same container"
                        docker rm -f "${ProjectName}" 2>/dev/null || true
                        docker run -d --name "${ProjectName}" -p "0.0.0.0:${Port}:${Port}" "$dockerHubUser/${ProjectName}:${Tag}"
                        """
                }
}
