def call(String ProjectName, String Tag) {
    withCredentials([usernamePassword(
        credentialsId: 'dockerHub',
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )]) {
        sh """
            docker build -t $dockerHubUser/${ProjectName}:${Tag} .
        """
    }
}
