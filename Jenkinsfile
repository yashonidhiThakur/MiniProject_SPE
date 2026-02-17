pipeline {
    agent any

    environment {
    
        IMAGE_NAME = "yashonidhithakur/scientific-calculator"
        DOCKER_CRED_ID = 'DockerHubCred'
        ANSIBLE_CRED_ID = 'localhost'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Pulling the code from GitHub'
                checkout scm
            }
        }

        stage('Building Docker Image') {
            steps {
                echo 'Building Docker Image'
                // using Dockerfile to compile Java and build the image
                sh 'docker build -t $IMAGE_NAME:latest .' 
            }
        }

        stage('Push to Docker Hub') {
            steps {
                echo 'Pushing to Docker Hub'
                withCredentials([usernamePassword(credentialsId: DOCKER_CRED_ID, passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh "docker push $IMAGE_NAME:latest"
                }
            }
        }

        stage('Deploy (Ansible)') {
            steps {
                echo 'Deploying the container via Ansible'
                ansiblePlaybook(
                    playbook: 'deploy.yml',
                    inventory: 'localhost',
                    credentialsId: ANSIBLE_CRED_ID
                )
            }
        }

        post{
            always{
                sh 'docker logout'
            }
        }
    }
}