package br.com.forum.dto

import br.com.forum.model.Course
import br.com.forum.model.User
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewTopicDTO (
        @field:NotEmpty
        @field:Size(min = 5, max = 100)
        val title: String,
        @field:NotEmpty
        val message: String,
        @field:NotNull
        val courseId: Long,
        @field:NotNull
        val authorId: Long,
        val author: User?,
        val course: Course?
)