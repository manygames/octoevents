package br.com.manygames.controller

import br.com.manygames.dto.GithubIssueEvent
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class WebController {
    @PostMapping("/events")
    @ResponseStatus(value = HttpStatus.OK)
    fun receiveEvents(@RequestBody issueEvent: GithubIssueEvent){
        issueEvent.action;
        issueEvent.issue;
    }
}