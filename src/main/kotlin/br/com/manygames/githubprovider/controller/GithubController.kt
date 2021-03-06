package br.com.manygames.githubprovider.controller

import br.com.manygames.githubprovider.dto.GithubIssueDto
import br.com.manygames.githubprovider.repo.GithubRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class GithubController {

    @Autowired
    lateinit var repository: GithubRepository

    @PostMapping("/events")
    fun receiveEvents(@RequestBody issueDto: GithubIssueDto) {
        repository.save(issueDto.getModel())
    }

    @GetMapping("/issues/{number}/events")
    fun getEventByNumber(@PathVariable number: Int) = repository.findByNumber(number)

}