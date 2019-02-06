package br.com.manygames.githubprovider.config

import br.com.manygames.githubprovider.domain.repository.IssueRepository
import br.com.manygames.githubprovider.domain.service.IssueService
import br.com.manygames.githubprovider.web.Router
import br.com.manygames.githubprovider.web.controller.IssueController
import org.koin.dsl.module.module

object ModulesConfig {
    private var configModule = module {
        single { Router(get()) }
    }

    private var issueModule = module {
        single { IssueController(get()) }
        single { IssueService(get()) }
        single { IssueRepository() }
    }

    internal val allModules = listOf(ModulesConfig.configModule, ModulesConfig.issueModule)
}