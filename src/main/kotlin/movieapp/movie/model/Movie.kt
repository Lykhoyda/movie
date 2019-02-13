package movieapp.movie.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "movies")
data class Movie(@Id val id: Int,
                 val title: String,
                 val year: Int,
                 val genre: MovieGenre,
                 val ratings: MutableList<MovieRating>,
                 val cast: List<Actor>)

