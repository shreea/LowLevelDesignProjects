package BookMyShow.controllers;

import BookMyShow.models.dao.TheatreDAO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/v1/theatres")
public class TheatreController {

    public TheatreDAO createTheatre(TheatreDAO theatreDAO) {
        return new TheatreDAO();
    }
}
