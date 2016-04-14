package reflection.hometask.examples;

import java.time.LocalDate;

import reflection.hometask.annotations.CustomDateFormat;
import reflection.hometask.annotations.Example;
import reflection.hometask.annotations.JsonValue;

@Example
public class Human {
	private String firstName;
	private String secondName;
	@JsonValue(name = "fun")
	private String hobby;
	@CustomDateFormat(format = "dd-MM-yyyy")
	private LocalDate birthDate;
	private String emptyValue;

	public Human() {
		firstName = "Michael";
		secondName = "Jackson";
		hobby = "dancing";
		birthDate = LocalDate.parse("1958-09-29");
	}
}
