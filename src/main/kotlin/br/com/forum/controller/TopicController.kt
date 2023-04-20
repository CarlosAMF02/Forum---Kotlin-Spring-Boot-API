package br.com.forum.controller

import br.com.forum.dto.NewTopicDTO
import br.com.forum.model.Topic
import br.com.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/topico")
class TopicController (private val topicService: TopicService) {

    @GetMapping
    fun list(): List<Topic> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable(name = "id") id: Long): Topic {
        return topicService.getById(id)
    }

    @PostMapping
    fun register(@RequestBody newTopicDTO: NewTopicDTO) {
        topicService.register(newTopicDTO)
    }
}