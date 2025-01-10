package main.java.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserResponseDTO {
	private String id;
	private UserRole role;

	@Override
	public String toString() {
		String role = this.role.name();
		return String.format("아이디 = '%s', 권한 = '%s'", id, role);
	}
}
