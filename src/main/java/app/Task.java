package app;

import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Task {
    private String title;
    private String description;
    private LocalDate duedate;
}
