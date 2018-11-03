package br.com.manygames.githubprovider.repo

import br.com.manygames.githubprovider.model.Issue
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.rules.ExpectedException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension
import sun.plugin.util.ProgressMonitor

@ExtendWith(SpringExtension::class)
@DataJpaTest
class GithubRepositoryTest(@Autowired val entityManager: TestEntityManager,
                           @Autowired val githubRepository: GithubRepository) {

    @Rule
    val thrown: ExpectedException = ExpectedException.none()

    @Test
    fun `When findByNumber then return Issue`() {
        val newIssue = Issue(33, 33, "opened", "33 issue", "http://issue33")
        entityManager.persist(newIssue)
        entityManager.flush()

        val returnedIssue: Issue = githubRepository.findByNumber(newIssue.number).get()
        assertThat(returnedIssue).isEqualTo(newIssue)
    }

    @Test
    fun `When findByNumber with no existing number then expect NoSuchElementException`() {
        thrown.expect(NoSuchElementException::class.java)

        val newIssue = Issue(33, 33, "opened", "33 issue", "http://issue33")
        entityManager.persist(newIssue)
        entityManager.flush()

        val invalidNumberIssue = Issue(33, Int.MIN_VALUE, "opened", "33 issue", "http://issue33")
        githubRepository.findByNumber(invalidNumberIssue.number)
    }
}