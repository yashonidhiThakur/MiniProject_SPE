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

        stage('Build Unit Test') {
            steps {
                echo 'Running Unit Tests and Building Exe'
                sh '/opt/homebrew/bin/mvn clean package' 
            }
        }

        stage('Building Docker Image') {
            steps {
                echo 'Building Docker Image'
                // using Dockerfile to compile Java and build the image
                sh '/usr/local/bin/docker build -t $IMAGE_NAME:latest .' 
            }
        }

        stage('Push to Docker Hub') {
            steps {
                echo 'Pushing to Docker Hub'
                withCredentials([usernamePassword(credentialsId: DOCKER_CRED_ID, passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'echo $PASS | /usr/local/bin/docker login -u $USER --password-stdin'
                    sh '/usr/local/bin/docker push $IMAGE_NAME:latest'
                }
            }
        }

        stage('Deploy (Ansible)') {
            steps {
                echo 'Deploying the container via Ansible'
                sh '/opt/homebrew/bin/ansible-playbook deploy.yml -i localhost,'
            }
        }
       }

       post{
            always{
                sh '/usr/local/bin/docker logout'
            }
       }
    
}