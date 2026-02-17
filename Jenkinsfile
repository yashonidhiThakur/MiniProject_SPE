pipeline {
    agent any

    environment {
    
        IMAGE_NAME = "yashonidhithakur/scientific-calculator"
        DOCKER_CRED_ID = 'DockerHubCred' 
    }

    stages {
        stage('Checkout') {
            steps {
                // Jenkins automatically checks out source code from Git using this
                checkout scm
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker Image...'
                // using Dockerfile to compile Java and build the image
                sh 'docker build -t $IMAGE_NAME:latest .' 
            }
        }

        stage('Push to Docker Hub') {
            steps {
                echo 'Pushing to Registry...'
                withCredentials([usernamePassword(credentialsId: DOCKER_CRED_ID, passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh "docker push $IMAGE_NAME:latest"
                }
            }
        }

        stage('Deploy (Ansible)') {
            steps {
                echo 'Deploying the container...'
                ansiblePlaybook(playbook: 'deploy.yml', ...)
            }
        }
    }
}