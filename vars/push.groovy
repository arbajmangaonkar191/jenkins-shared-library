def call(String credentialId, String image) {
    withCredentials([
        usernamePassword(
            credentialsId: "$credentialId",
            usernameVariable: 'Dockeruser',
            passwordVariable: 'PasswordHub'
        )
    ]) {
        sh 'docker login -u $Dockeruser -p $PasswordHub'
        sh "docker image tag "${image}" arbajmangaonkar/"${image}""
        sh "docker push arbajmangaonkar/"${image}""
    }
}
