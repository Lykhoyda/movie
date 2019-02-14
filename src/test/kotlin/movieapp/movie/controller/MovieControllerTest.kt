package movieapp.movie.controller

import movieapp.movie.model.Movie
import movieapp.movie.model.MovieGenre
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.spy
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory
import org.springframework.web.context.WebApplicationContext
import java.util.*
import javax.xml.validation.Validator

@ExtendWith(MockitoExtension::class)
class MovieControllerTest {

    @InjectMocks
    lateinit var controller: MovieController

    lateinit var mockMvc: MockMvc

    @Mock
    lateinit var validator: Validator

    val validatorBean = LocalValidatorFactoryBean()
    val customBeanFactory = DefaultListableBeanFactory()
    val spyBeanFactory = spy(customBeanFactory)

    @BeforeEach
    fun setUp() {
        validatorBean.constraintValidatorFactory = SpringConstraintValidatorFactory(spyBeanFactory)

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setValidator(validatorBean)
                .build()
    }

    @Test
    fun `Get Movies - Happy Path`() {
        // when
        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk)
                .andExpect(content().json("""[{"id":1,"title":"Avengers","year":2018,"genre":{"name":"Action","description":"Action"},"ratings":[],"cast":[]}]"""))
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