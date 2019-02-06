package br.com.manygames.githubprovider.config

import br.com.manygames.githubprovider.config.ModulesConfig.allModules
import br.com.manygames.githubprovider.web.Router
import io.javalin.Javalin
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

class AppConfig : KoinComponent{
    private val router: Router by inject()

    fun setup(): Javalin {
        StandAloneContext.startKoin(allModules)
        return Javalin.create().also {app ->
            router.register(app)
            app.port(4040)
        }
//        start(4040)
    }
}