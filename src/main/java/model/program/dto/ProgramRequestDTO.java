package main.java.model.program.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramRequestDTO {
    private String showId;
    private String types;
    private String title;
    private String director;
    private String country;
    private int releaseYear;
    private int duration;
    private String listedIn;
    private String description;
}
