pipeline {
    agent any
    stages {
                stage('CleanApp') {
            steps {
                sh 'mvn clean'
            }
        }
			stage('Tests') {
            steps {
		    sh 'mvn clean install'
            }
        } 
	       stage('Notification'){
		    steps{
			emailext attachmentsPattern: '**/selenium-automation-report.html', body: 'Hi Team ,Please Find attachment for Passes TestCases', subject: 'AutomationTest', to: 'siva0750@gmail.com,agonzalez@arexdata.com'    
		    }
	    }
    }
    post {
        always {
            echo 'checking Maven Version again'
			   sh 'mvn --version'
			   echo 'Maven version has been Verified'
			   emailext attachmentsPattern: '**/selenium-automation-report.html', from:'JenkinsAutomationReports@arexdata.com', body: 'Hi Team ,Please Find the Attachment For Failed Test Cases below', subject: 'AutomationTest', to: 'nakhter0441@gmail.com,lakshmipathi.kantipalli57@gmail.com'    			   
        }
        success {
            echo 'I succeeded!'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
	    emailext attachmentsPattern: '**/selenium-automation-report.html', from:'JenkinsAutomationReports@arexdata.com', body: 'Hi Team ,Please Find the Attachment For Failed Test Cases below', subject: 'AutomationTest', to: 'nakhter0441@gmail.com,lakshmipathi.kantipalli57@gmail.com'    
        }
        changed {
            echo 'Things were different before...'
        }
    }
}  
