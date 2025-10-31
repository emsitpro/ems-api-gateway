pipeline {
    agent any

    environment {
        REGISTRY = "docker.io/emsitpro"
        IMAGE_NAME = "ems-api-gateway"
        DOCKER_CREDS = credentials('docker-hub-credentials') // credentials Docker Hub di Jenkins
        KUBECONFIG_FILE = credentials('kubeconfig-jenkins')  // credentials kubeconfig
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-ssh-key',
                    url: 'git@github.com:emsitpro/ems-api-gateway.git'
            }
        }

        stage('Build Quarkus (Gradle)') {
            steps {
                chmod +x gradlew
                sh './gradlew clean build -x test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh """
                        docker build -t $REGISTRY/$IMAGE_NAME:${BUILD_NUMBER} .
                    """
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    sh """
                        echo ${DOCKER_CREDS_PSW} | docker login -u ${DOCKER_CREDS_USR} --password-stdin
                        docker push $REGISTRY/$IMAGE_NAME:${BUILD_NUMBER}
                    """
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                withCredentials([file(credentialsId: 'kubeconfig-jenkins', variable: 'KUBECONFIG')]) {
                    sh '''
                        export KUBECONFIG=$KUBECONFIG
                        sed -i "s|image: .*|image: docker.io/emsitpro/ems-api-gateway:${BUILD_NUMBER}|" kubernetes/deployment.yaml
                        kubectl apply -f kubernetes/deployment.yaml -n default
                        kubectl apply -f kubernetes/service.yaml -n default
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "Deployment sukses ke Kubernetes (namespace: default)"
        }
        failure {
            echo "Pipeline gagal. Cek logs Jenkins."
        }
    }
}
