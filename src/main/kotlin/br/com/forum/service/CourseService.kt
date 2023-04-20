package br.com.forum.service

import br.com.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(private var courses: List<Course>) {

    init {
        val course1 = Course(id = 1, name = "Kotlin e Spring Boot", category = "Programação")
        val course2 = Course(id = 2, name = "Java e Spring Boot", category = "Programação")
        val course3 = Course(id = 3, name = "Kotlin Básico", category = "Programação")

        courses = listOf(course1, course2, course3)
    }

    fun getById(id: Long): Course {
        return courses.stream().filter { course -> course.id == id }.findFirst().get()
    }
}