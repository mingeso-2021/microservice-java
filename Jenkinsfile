
pipeline {
	agent any
	environment{
		DOCKERHUB_CREDENTIALS = credentials('fanunez-dockerhub');
	}
	stages {
        stage('Init') {
            steps {
                echo "Init"
            }
        }
		stage('SonarQube analysis') {
    			steps {
    			echo "sonarqube with Backend"
				dir("/var/lib/jenkins/workspace/dev-microservice-admin") { //nombre del proyecto en jenkins
					withSonarQubeEnv('sonarqube') { // Will pick the global server connection you have configured
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
                    }
				}
			}
  		}
		stage('JUnit'){
			steps {
			    dir("/var/lib/jenkins/workspace/dev-microservice-admin/build/test-results/test") {
                    sh 'touch test.xml'
                    sh 'rm *.xml'
                }
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    			dir("/var/lib/jenkins/workspace/dev-microservice-admin") {
						sh './gradlew test'
					}
                }
				dir("/var/lib/jenkins/workspace/dev-microservice-admin/build/test-results/test") {
					junit '*.xml'
				}
			}
		}
		stage('Docker Build'){
            steps{
                dir("/var/lib/jenkins/workspace/dev-microservice-admin"){
                    sh 'docker build --build-arg JAR_FILE=build/libs/*.jar -t fanunez/microservice-mingeso .'
                }
            }
        }
        stage('Login'){
            steps{
                sh  'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Docker Hub'){
            steps{
                dir("/var/lib/jenkins/workspace/dev-microservice-admin"){
                    sh 'docker push fanunez/microservice-mingeso'
                }
            }
		}
		stage('End') {
            steps {
                echo "Deploying Backend"
            }
        }
	}
	post {
		always {
			sh 'docker logout'
		}
	}
}