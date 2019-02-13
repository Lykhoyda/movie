package movieapp.movie.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")

data class User(
        @Id val id: Int,
        val username: String,
        val password: String,
        val role: String,
        val description: String
)