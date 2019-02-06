package br.com.manygames.githubprovider.web.controller

import br.com.manygames.githubprovider.domain.Issue
import br.com.manygames.githubprovider.domain.service.IssueService
import br.com.manygames.githubprovider.web.dto.GithubIssueDto
import io.javalin.Context

class IssueController (private val issueService: IssueService){
    fun save(ctx: Context){
        var gitObject = ctx.body<GithubIssueDto>()
        var issue = gitObject.getModel()
        issueService.create(issue)
    }

    fun getAll(ctx: Context){
        issueService.getAll().also {
            ctx.json(it)
        }
    }
}