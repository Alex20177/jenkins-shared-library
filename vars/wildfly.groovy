def deploy(credId){

    withCredentials([usernamePassword( credentialsId: "$credId", usernameVariable: 'MYUSER', passwordVariable: 'MYPWD' )]) { 
    
        echo 'Starting undeploy app'                
	    sh "mvn -DskipTests=true -DJBOSS_USER=$MYUSER -DJBOSS_PASS=$MYPWD wildfly:undeploy"
	    
        sleep(time:25,unit:"SECONDS")

        echo 'Starting deploy app'  
	    sh "mvn -DskipTests=true -DJBOSS_USER=$MYUSER -DJBOSS_PASS=$MYPWD wildfly:deploy"
	    
        archiveArtifacts(allowEmptyArchive: false, artifacts: 'target/*.war')

    }   

	// sh "mvn -DskipTests=true -DJBOSS_USER=$user -DJBOSS_PASS=$pass wildfly:undeploy"
	// sleep(time:25,unit:"SECONDS")
	// sh "mvn -DskipTests=true -DJBOSS_USER=$user -DJBOSS_PASS=$pass wildfly:deploy"
	// archiveArtifacts(allowEmptyArchive: false, artifacts: 'target/*.war')
			
}