
pipeline {
    agent any

    environment {
        IMAGE_NAME = 'divyachalla05/tastytrolley'
        IMAGE_TAG = '4.0'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/divyachalla05/tastytrolley.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -f Dockerfile.alpine -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKERHUB_USER',
                    passwordVariable: 'DOCKERHUB_TOKEN'
                )]) {
                    sh '''
                        set +x
                        echo "$DOCKERHUB_TOKEN" | docker login \
                            --username "$DOCKERHUB_USER" \
                            --password-stdin
                        docker push "$IMAGE_NAME:$IMAGE_TAG"
                        docker logout
                    '''
                }
            }
        }
    }
}

