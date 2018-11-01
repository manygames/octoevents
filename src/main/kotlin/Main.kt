import br.com.manygames.dto.GithubIssueEvent
import io.javalin.Javalin

fun main(args: Array<String>) {
    val app = Javalin.create().apply {
        enableStaticFiles("/public")
    }.start(4040)

    app.post("/events") {ctx ->
        val issueEvent = ctx.body<GithubIssueEvent>()
        ctx.status(200)
    }
}