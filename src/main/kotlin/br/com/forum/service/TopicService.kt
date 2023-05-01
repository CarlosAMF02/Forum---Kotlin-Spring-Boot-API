package br.com.forum.service

import br.com.forum.dto.EditTopicDTO
import br.com.forum.dto.NewTopicDTO
import br.com.forum.dto.ViewTopicDTO
import br.com.forum.exception.NotFoundException
import br.com.forum.mappers.NewTopicDTOMapper
import br.com.forum.mappers.ViewTopicDTOMapper
import br.com.forum.model.Answer
import br.com.forum.model.Course
import br.com.forum.model.Topic
import br.com.forum.model.User
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class TopicService(private var topics: List<Topic>,
                   private val viewTopicDTOMapper: ViewTopicDTOMapper,
                   private val newTopicDTOMapper: NewTopicDTOMapper,
) {

    private val notFoundMessage: String = "Tópico não encontrado"

    init {
        val user = User(id = 1, name = "Carlos", email = "carlos@email.com")
        val course = Course(id = 1, name = "Kotlin - Spring Boot", category = "Programação")
        val topic1 = Topic(id = 1, title = "Dúvida Kotlin", message = "Variáveis no Kotlin", course = course, author = user)
        val topic2 = Topic(id = 2, title = "Dúvida Kotlin", message = "Tipo var e val", course = course, author = user)
        val topic3 = Topic(id = 3, title = "Dúvida Kotlin", message = "IDE", course = course, author = user)

        topics = listOf(topic1, topic2, topic3)
    }

    fun list(): List<ViewTopicDTO> {
        return topics.stream().map {
            t -> viewTopicDTOMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun getById(id: Long): ViewTopicDTO {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        return viewTopicDTOMapper.map(topic)
    }

    fun getAnswersByTopicId(id: Long): List<Answer> {
        return topics.stream().filter { t -> t.id == id }.findFirst().get().answers
    }

    fun register(newTopicDTO: NewTopicDTO) : ViewTopicDTO {
        val topic: Topic = newTopicDTOMapper.map(newTopicDTO)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)

        return viewTopicDTOMapper.map(topic)
    }

    fun edit(editTopicDTO: EditTopicDTO): ViewTopicDTO {
        val topic = topics.stream().filter { t -> t.id == editTopicDTO.id }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val updatedTopic = Topic(
                id = editTopicDTO.id,
                title = editTopicDTO.title,
                message = editTopicDTO.message,
                author = topic.author,
                course = topic.course,
                answers = topic.answers,
                status = topic.status,
                creationDate = topic.creationDate
        )

        topics = topics.minus(topic).plus(updatedTopic)

        return viewTopicDTOMapper.map(updatedTopic)
    }

    fun remove(id: Long) {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topics = topics.minus(topic)
    }
}