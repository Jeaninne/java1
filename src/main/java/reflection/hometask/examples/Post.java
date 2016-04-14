package reflection.hometask.examples;

import java.time.LocalDate;

import reflection.hometask.annotations.CustomDateFormat;
import reflection.hometask.annotations.Example;
import reflection.hometask.annotations.JsonValue;

@Example
public class Post {

	private Integer post_id;
	private Integer actor_id;
	@JsonValue(name = "personal pic")
	private String picOfPersonWhoPosted;
	private String nameOfPersonWhoPosted;
	private String message;
	private int likesCount;
	@CustomDateFormat(format = "dd-MM-yyyy")
	private LocalDate timeOfPost;
	private LocalDate timeOfEditing;

	public Post() {
		picOfPersonWhoPosted = "http://example.com/init.jpg";
		nameOfPersonWhoPosted = "Anonumus";
		timeOfPost = LocalDate.now();
		timeOfEditing = LocalDate.now();
	}
}
