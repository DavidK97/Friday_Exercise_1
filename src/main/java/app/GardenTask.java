package app;

import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
@ToString

public class GardenTask extends Task {
    private String gardenLocation;

    public GardenTask (String title, String description, LocalDate duedate, String gardenLocation) {
        super(title, description, duedate);
        this.gardenLocation = gardenLocation;

    }
}
