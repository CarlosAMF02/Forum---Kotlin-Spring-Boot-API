package br.com.forum.mappers

import br.com.forum.dto.NewTopicDTO
import br.com.forum.model.Topic
import br.com.forum.service.CourseService
import br.com.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class NewTopicDTOMapper(
        private val courseService: CourseService,
        private val userService: UserService
) : Mapper<NewTopicDTO, Topic> {

    override fun map(t: NewTopicDTO): Topic {
        return Topic(
                title = t.title,
                message = t.message,
                author = userService.getById(t.authorId),
                course = courseService.getById(t.courseId)
        )
    }
}