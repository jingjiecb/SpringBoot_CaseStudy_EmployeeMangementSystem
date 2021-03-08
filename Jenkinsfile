pipeline {
  agent any
  triggers {
    GenericTrigger(
     causeString: 'Triggered on dev',
     token: 'abc123',
     printContributedVariables: true,
     printPostContent: true,
     silentResponse: false,
     regexpFilterText: '^refs/heads/dev$',
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
