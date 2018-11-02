package br.com.manygames.githubprovider

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication


@SpringBootApplication
class GithubIssueEventApplication

fun main(args: Array<String>) {
    runApplication<GithubIssueEventApplication>(*args)
}
