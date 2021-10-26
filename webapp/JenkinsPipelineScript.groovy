job('First_Jenkins_Project_Via_DSL'){
    description('First Jenkins Project Via DSL')
    scm{
        git('https://github.com/nilamazing/hello-world.git','master')
    }
    triggers{
        scm('* * * * *')
    }
    steps{
        maven{
            mavenInstallation("MAVEN_HOME")
        }
        maven('clean package', 'webapp/pom.xml')
    }
    publishers{
        archiveArtifacts{
            pattern('**/*.war')
            onlyIfSuccessful()
        }
    }
}