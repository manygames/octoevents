package br.com.manygames.githubprovider.web

import br.com.manygames.githubprovider.web.controller.IssueController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import org.koin.standalone.KoinComponent

class Router(private val issueController: IssueController) : KoinComponent {
    fun register(app: Javalin){
        app.routes {
            path("events") {
                get(issueController::getAll)
            }
        }
    }
}