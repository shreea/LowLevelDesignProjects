package BookMyShow.models;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
@Data
public class Show {
    private String showId;
    private Timestamp startTime;
    private List<ShowSeat> showSeats;
}
