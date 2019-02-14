package movieapp.movie.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("api")
@RestController
class MovieController {

    @GetMapping("/movies")
    fun getMovies(): String {
        return """[{"id":1,"title":"Avengers","year":2018,"genre":{"name":"Action","description":"Action"},"ratings":[],"cast":[]}]"""
    }

}