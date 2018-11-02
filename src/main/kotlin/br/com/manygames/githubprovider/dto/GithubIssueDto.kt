package br.com.manygames.githubprovider.dto

data class GithubIssueDto(
        val action: String? = "",
        val issue: IssueDto? = IssueDto(),
        val repository: RepositoryDto? = RepositoryDto(),
        val sender: SenderDto? = SenderDto()
)