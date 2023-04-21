package br.com.forum.mappers

import br.com.forum.dto.ViewTopicDTO
import br.com.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class ViewTopicDTOMapper: Mapper<Topic, ViewTopicDTO> {
    override fun map(t: Topic): ViewTopicDTO {
        return ViewTopicDTO(
                id = t.id,
                title = t.title,
                message = t.message,
                status = t.status,
                creationDate = t.creationDate)
    }
}