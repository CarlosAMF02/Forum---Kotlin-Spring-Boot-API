package br.com.forum.dto

import br.com.forum.enums.TopicStatus
import java.time.LocalDateTime

data class ViewTopicDTO (
        val id: Long?,
        val title: String,
        val message: String,
        val status: TopicStatus,
        val creationDate: LocalDateTime
)