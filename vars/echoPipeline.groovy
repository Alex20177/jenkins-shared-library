def call(body){

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline(){
        
        agent any

        stages {
        
            stage('echo from other side'){
            
                steps{
                
                    echo "${config.message}"

                }

            }

        }

    }

}