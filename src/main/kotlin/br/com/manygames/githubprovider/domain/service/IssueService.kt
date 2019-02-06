package br.com.manygames.githubprovider.domain.service

import br.com.manygames.githubprovider.domain.Issue
import br.com.manygames.githubprovider.domain.repository.IssueRepository

class IssueService(private val issueRepository: IssueRepository){
    fun create(issue: Issue){
        return issueRepository.create(issue)
    }

    fun getAll(): List<Pair<String, String>> {
        return issueRepository.getAll()
    }
}