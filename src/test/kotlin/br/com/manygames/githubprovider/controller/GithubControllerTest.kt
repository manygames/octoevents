package br.com.manygames.githubprovider.controller

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GithubControllerTest(@Autowired val restTemplate: TestRestTemplate){
    @Test
    fun `Assert json response contains corresponding event id and status code`() {
        val entity = restTemplate.getForEntity<String>("/issues/1/events")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        val correspondingId = "376467047"
        assertThat(entity.body).contains(correspondingId)
    }
}