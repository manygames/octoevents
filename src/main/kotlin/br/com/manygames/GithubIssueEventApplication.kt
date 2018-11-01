package br.com.manygames

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class GithubIssueEventApplication

fun main(args: Array<String>) {
    runApplication<GithubIssueEventApplication>(*args)
}

/*
fun br.com.manygames.main(args: Array<String>) {
    val app = Javalin.create().apply {
        enableStaticFiles("/public")
    }.start(4040)

    app.post("/events") {ctx ->
        val issueEvent = ctx.body<GithubIssueEvent>()
        ctx.status(200)
    }
}*/
