package movieapp.movie.controller

import movieapp.movie.model.Movie
import movieapp.movie.model.MovieGenre
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.util.*

@SpringBootTest
class MovieControllerTest {

    @Autowired
    lateinit var context: WebApplicationContext

    @Autowired
    lateinit var controller: MovieController

    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build()
    }

    @Test
    fun `Get Movies - Happy Path`() {
        // when
        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("id", equalTo(1))
                        // .header("Authorization", getBasicAuthorization())
                )
    }


    companion object {
        fun getMovie(): Movie {
            return Movie(
                    id = 1,
                    title = "movieTitle",
                    year = 2018,
                    genre = MovieGenre("comedy", "genreDescription"),
                    ratings = ArrayList(),
                    cast = ArrayList())
        }
    }
}