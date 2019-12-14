job('NodeJS Job') {
  scm {
    git('https://github.com/verhichi/cicd_with_jenkins_spa.git') {  node ->
      node / gitConfigName('DSL User')
      node / gitConfigEmail('jenkins-dsl@example.com')
    }
  }
  triggers {
    scm('H/5 * * * *')
  }
  wrappers {
    nodejs('nodejs_12.13.1')
  }
  steps {
    shell("npm install")
    shell("npm run build")
  }
}