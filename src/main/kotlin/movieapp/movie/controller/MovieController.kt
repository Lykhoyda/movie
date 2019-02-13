package movieapp.movie.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("api")
@RestController
class MovieController {

    @GetMapping("/movies")
    fun getMovies(): String {
        return """{"id":1}"""
    }

}