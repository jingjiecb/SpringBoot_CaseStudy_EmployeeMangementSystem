pipeline {
    agent any

    stages {
        stage('master build') {
            when{
                branch 'master'
            }
            steps {
                echo 'master build'
            }
        }
        stage('dev build') {
            when{
                branch 'dev'
            }
            steps {
                echo 'dev build'
            }
        }
    }
}
