package br.com.manygames.repo

import br.com.manygames.model.Issue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GithubRepository : JpaRepository<Issue, Long>  {
    fun findByNumber(number: Int): Optional<Issue>
}