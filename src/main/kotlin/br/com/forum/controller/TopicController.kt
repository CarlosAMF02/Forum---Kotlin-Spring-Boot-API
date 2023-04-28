package br.com.forum.controller

import br.com.forum.dto.EditTopicDTO
import br.com.forum.dto.NewTopicDTO
import br.com.forum.dto.ViewTopicDTO
import br.com.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
    fun register(@RequestBody @Valid newTopicDTO: NewTopicDTO) {
        topicService.register(newTopicDTO)
    }

    @PutMapping
    fun edit (@RequestBody @Valid editTopicDTO: EditTopicDTO) {
        topicService.edit(editTopicDTO)
    }
}