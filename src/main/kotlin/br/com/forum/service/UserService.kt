package br.com.forum.service

import br.com.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(private var authors: List<User>) {
    init {
        val user1 = User(id = 1, name = "Carlos", email = "carlos@email.com")
        val user2 = User(id = 2, name = "Bruno", email = "bruno@email.com")
        val user3 = User(id = 3, name = "Rafael", email = "rafael@email.com")

        authors = listOf(user1, user2, user3)
    }

    fun getById(id: Long): User {
        return authors.stream().filter { author -> author.id == id }.findFirst().get()
    }
}