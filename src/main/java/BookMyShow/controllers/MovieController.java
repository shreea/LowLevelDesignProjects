package BookMyShow.controllers;

import BookMyShow.models.dao.MovieDAO;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController("/v1/movies")
public class MovieController {
    @GetMapping("/{city-id}")
    public List<MovieDAO> getMoviesInCity(@PathParam("city-id") String cityId) {
        return new LinkedList<>();
    }
    @GetMapping("/{movie-id}")
    public MovieDAO getMovie(@PathParam("movie-id") String movieId) {
        return new MovieDAO();
    }

}
