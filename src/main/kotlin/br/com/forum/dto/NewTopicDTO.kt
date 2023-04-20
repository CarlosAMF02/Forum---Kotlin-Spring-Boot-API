package br.com.forum.dto

data class NewTopicDTO (
        val title: String,
        val message: String,
        val courseId: Long,
        val authorId: Long
)