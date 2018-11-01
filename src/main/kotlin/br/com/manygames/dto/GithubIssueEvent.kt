package br.com.manygames.dto

data class GithubIssueEvent(
        val action: String? = "",
        val issue: Issue? = Issue(),
        val repository: Repository? = Repository(),
        val sender: Sender? = Sender()
)