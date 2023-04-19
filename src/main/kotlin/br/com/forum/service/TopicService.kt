package br.com.forum.service

import br.com.forum.model.Course
import br.com.forum.model.Topic
import br.com.forum.model.User
import org.springframework.stereotype.Service


@Service
class TopicService {
    fun list(): List<Topic> {
        val user = User(id = 1, name = "Carlos", email = "carlos@email.com")
        val course = Course(id = 1, name = "Kotlin - Spring Boot", category = "Programação")
        val topic = Topic(id = 1, title = "Dúvida Kotlion", message = "Variáveis no Kotlin", course = course, author = user)

        return listOf(topic, topic, topic)
    }
}