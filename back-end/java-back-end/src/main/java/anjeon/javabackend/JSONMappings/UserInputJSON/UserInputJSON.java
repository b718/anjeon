package anjeon.javabackend.JSONMappings.UserInputJSON;

public class UserInputJSON {
  private String id;
  private String userNameInput;
  private String userTextInput;

  public UserInputJSON(String userNameInput, String userTextInput) {
    this.userNameInput = userNameInput;
    this.userTextInput = userTextInput;
  }

  public String getUserNameInput() {
    return userNameInput;
  }

  public String getUserTextInput() {
    return userTextInput;
  }
}
