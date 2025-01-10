package main.java.model.program.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Builder
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("넷플릭스 프로그램 제목 = ");
		builder.append(title);
		builder.append(", 감독 = ");
		builder.append(director);
		builder.append(", 국적 = ");
		builder.append(country);
		builder.append(", 출시년도 = ");
		builder.append(releaseYear);
		builder.append(", 러닝타임 = ");
		builder.append(duration);
		builder.append(", 장르 = ");
		builder.append(listedIn);
		builder.append(", 줄거리 = ");
		builder.append(description);
		return builder.toString();
	}
	
	
}