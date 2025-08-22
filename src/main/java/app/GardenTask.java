package app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder

public class GardenTask extends Task {
    private String gardenLocation;

    public GardenTask (String title, String description, LocalDate duedate, String gardenLocation) {
        super(title, description, duedate);
        this.gardenLocation = gardenLocation;

    }
}
