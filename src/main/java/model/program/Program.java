package main.java.model.program;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Program {
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