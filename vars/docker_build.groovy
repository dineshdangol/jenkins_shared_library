def call(String ProjectName, String Tag){
    withCredentials([usernamePassword(credentialsId: 'dockerHub', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubpass' )]){
        sh """
            docker build -t "$dockerHubUser/${ProjectName}:${Tag}"
            """
    }
}
