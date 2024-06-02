package anjeon.javabackend.JSONMappings.UserInputJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInputJSON {
  private String id;
  private String text;

  public UserInputJSON(@JsonProperty("text") String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
