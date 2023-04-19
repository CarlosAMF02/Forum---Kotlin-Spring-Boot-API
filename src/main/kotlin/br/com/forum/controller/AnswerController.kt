package br.com.forum.controller

import br.com.forum.model.Answer
import br.com.forum.service.AnswerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/topico/{id}/resposta")
class AnswerController(private val answerService: AnswerService) {

    @GetMapping
    fun list(@PathVariable id: Long): List<Answer> {
        return answerService.listAnswersByTopic(id)
    }

}