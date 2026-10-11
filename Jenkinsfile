pipeline {
    agent any

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
                sh 'docker build -f Dockerfile.alpine -t divyachalla05/tastytrolley:4.0 .'
            }
        }
    }
}
