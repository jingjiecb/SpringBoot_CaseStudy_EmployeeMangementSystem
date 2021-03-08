/*
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
*/
pipeline {
  agent any
  triggers {
    GenericTrigger(
     genericVariables: [
      [key: 'ref', value: '$.ref']
     ],
     causeString: 'Triggered on $ref',
     token: 'abc123',
     printContributedVariables: true,
     printPostContent: true,
     silentResponse: false,
     regexpFilterText: '$ref',
     regexpFilterExpression: 'refs/heads/' + BRANCH_NAME
    )
  }
  stages {
    stage('Some step') {
      steps {
        sh "echo $ref"
      }
    }
  }
}
