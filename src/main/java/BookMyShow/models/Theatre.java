package BookMyShow.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Theatre {
    private String theatreId;
    private String name;
    private List<Hall> halls;
}
