package br.com.forum.controller

import br.com.forum.dto.EditTopicDTO
import br.com.forum.dto.NewTopicDTO
import br.com.forum.dto.ViewTopicDTO
import br.com.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/api/topico")
class TopicController (private val topicService: TopicService) {

    @GetMapping
    fun list(): List<ViewTopicDTO> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable(name = "id") id: Long): ViewTopicDTO {
        return topicService.getById(id)
    }

    @PostMapping
    fun register(
            @RequestBody @Valid newTopicDTO: NewTopicDTO,
            uriBuilder: UriComponentsBuilder) : ResponseEntity<ViewTopicDTO> {
        val viewTopic = topicService.register(newTopicDTO)
        val uri = uriBuilder.path("/api/topicos/${viewTopic.id}").build().toUri()
        return ResponseEntity.created(uri).body(viewTopic)
    }

    @PutMapping
    fun edit (@RequestBody @Valid editTopicDTO: EditTopicDTO): ResponseEntity<ViewTopicDTO> {
        val viewTopic = topicService.edit(editTopicDTO)

        return ResponseEntity.ok(viewTopic)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete (@PathVariable(name = "id") id: Long) {
        topicService.remove(id)
    }
}