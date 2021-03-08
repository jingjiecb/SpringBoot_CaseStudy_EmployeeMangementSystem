pipeline {
  agent any
  triggers {
    GenericTrigger(
        causeString: 'Triggered by develop',
        genericVariables: [[key: 'ref', value: '$.ref']],
        printContributedVariables: true,
        printPostContent: true,
        regexpFilterExpression: 'refs/heads/' + BRANCH_NAME,
        regexpFilterText: 'refs/heads/dev',
        token: 'abc123'
    )
  }
  stages {
    stage('Some step') {
      steps {
        sh "echo dev"
      }
    }
  }
}
