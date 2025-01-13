package main.java.model.program.dto;

import main.java.model.program.Program;

public class ProgramMapper {
    public static ProgramRequestDTO toDTO(String showId, String types, String title, String director, String country, int releaseYear, int duration, String listedIn, String description) {
        ProgramRequestDTO dto = ProgramRequestDTO.builder()
                .showId(showId)
                .types(types)
                .title(title)
                .director(director)
                .country(country)
                .releaseYear(releaseYear)
                .duration(duration)
                .listedIn(listedIn)
                .description(description)
                .build();
        return dto;
    }
}
