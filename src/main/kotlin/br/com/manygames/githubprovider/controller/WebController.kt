package br.com.manygames.githubprovider.controller

import br.com.manygames.githubprovider.dto.GithubIssueDto
import br.com.manygames.githubprovider.model.Issue
import br.com.manygames.githubprovider.repo.GithubRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class WebController {

    @Autowired
    lateinit var repository: GithubRepository

    @PostMapping("/events")
    @ResponseStatus(value = HttpStatus.OK)
    fun receiveEvents(@RequestBody issueEvent: GithubIssueDto) {
        val issueModel: Issue = fromDtoToModel(issueEvent)
        repository.save(issueModel)
    }

    @GetMapping("/issues/{number}/events")
    fun getEventByNumber(@PathVariable number: Int) = repository.findByNumber(number)

    private fun fromDtoToModel(issueEvent: GithubIssueDto): Issue {
        val issueModel = Issue(
                issueEvent.issue?.id!!.toInt(),
                issueEvent.issue?.number!!.toInt(),
                issueEvent.action!!,
                issueEvent.issue?.title!!,
                issueEvent.issue?.url!!)
        return issueModel
    }
}