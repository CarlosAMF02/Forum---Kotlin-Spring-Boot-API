package br.com.forum.service

import br.com.forum.model.Course
import br.com.forum.model.Topic
import br.com.forum.model.User
import org.springframework.stereotype.Service


@Service
class TopicService(private var topics: List<Topic>) {

    init {
        val user = User(id = 1, name = "Carlos", email = "carlos@email.com")
        val course = Course(id = 1, name = "Kotlin - Spring Boot", category = "Programação")
        val topic1 = Topic(id = 1, title = "Dúvida Kotlin", message = "Variáveis no Kotlin", course = course, author = user)
        val topic2 = Topic(id = 2, title = "Dúvida Kotlin", message = "Tipo var e val", course = course, author = user)
        val topic3 = Topic(id = 3, title = "Dúvida Kotlin", message = "IDE", course = course, author = user)

        topics = listOf(topic1, topic2, topic3)
    }

    fun list(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.stream().filter { t -> t.id == id }.findFirst().get()
    }
}