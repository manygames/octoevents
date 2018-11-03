package br.com.manygames.githubprovider.controller

import br.com.manygames.githubprovider.dto.GithubIssueDto
import org.assertj.core.api.Assertions.assertThat
import org.json.JSONObject
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GithubControllerTest(@Autowired val restTemplate: TestRestTemplate){

    @Test
    fun `Assert json response contains corresponding event id and status code`() {
        val eventNumber = 1
        val endpointToTest = "/issues/$eventNumber/events"
        val entity = restTemplate.getForEntity<String>(endpointToTest)

        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        val correspondingId = "376467047"
        assertThat(entity.body).contains(correspondingId)
    }

    @Test
    fun `When request's payload is empty return HttpStatus 500`() {
        val endpointToTest = "/events"
        val httpEntity = createEmptyPayloadRequest()

        val entity = restTemplate.postForEntity(
                endpointToTest,
                httpEntity,
                GithubIssueDto::class.java)
        assertThat(entity.statusCode).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    private fun createEmptyPayloadRequest(): HttpEntity<String> {
        val httpHeaders = HttpHeaders()
        httpHeaders.contentType = MediaType.APPLICATION_JSON
        val json = JSONObject()
        val httpEntity = HttpEntity(json.toString(), httpHeaders)
        return httpEntity
    }
}