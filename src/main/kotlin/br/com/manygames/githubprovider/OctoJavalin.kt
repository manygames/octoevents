package br.com.manygames.githubprovider

import br.com.manygames.githubprovider.config.AppConfig

fun main(vararg args: String) {
    AppConfig().setup().start()
//    val app = Javalin.create().apply {
//        enableCorsForAllOrigins()
//        enableStaticFiles("/public")
//    }.start(4040)
//
//    val issueService = IssueService()
//
//    app.routes {
//        get("events") { ctx ->
//            ctx.json(issueService.getAll())
//        }
//
//        post("event") {ctx ->
//            ctx.validatedBody<GithubIssueDto>().getOrThrow().getModel()?.also { issue ->
//                issueService.create(issue)
//            }
//        }
//    }
}