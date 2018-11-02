package br.com.manygames.githubprovider.repo

import br.com.manygames.githubprovider.model.Issue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GithubRepository : JpaRepository<Issue, Long>  {
    fun findByNumber(number: Int): Optional<Issue>
}