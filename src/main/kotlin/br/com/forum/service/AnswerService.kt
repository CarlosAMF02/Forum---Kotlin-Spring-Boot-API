package br.com.forum.service

import br.com.forum.model.Answer
import br.com.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class AnswerService( private val topicService: TopicService) {

    fun listAnswersByTopic(id: Long): List<Answer> {
        return topicService.getAnswersByTopicId(id)
    }
}