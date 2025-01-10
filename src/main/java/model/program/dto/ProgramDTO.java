package main.java.model.program.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ProgramDTO {
	String showId;
	String types;
	String title;
	String director;
	String country;
	int releaseYear;
	int duration;
	String listedIn;
	String description;
	
}
