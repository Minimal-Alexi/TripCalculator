pipeline {
    agent any
    environment {
        // Define Docker Hub credentials ID
        DOCKERHUB_CREDENTIALS_ID = '766ad170-3f44-470a-bf6f-15ea59065be6'
        // Define Docker Hub repository name
        DOCKERHUB_REPO = 'popalexdocker/week7hw'
        // Define Docker image tag
        DOCKER_IMAGE_TAG = 'latest_v1'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/viettrung2103/SEP1_Week7_Spring2025_Inclass_solution-jenkin-dockerhub.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }
        stage('Docker Login') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS_ID,
                                                     usernameVariable: 'DOCKERHUB_USER',
                                                     passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                        bat "docker login -u %DOCKERHUB_USER% --password %DOCKERHUB_PASSWORD%"
                    }
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} ."
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    bat "docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
                }
            }
        }
    }
}