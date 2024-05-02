package anjeon.javabackend.JSONMappings.PythonService;

import java.util.List;

public class PythonService {
  private String id;
  private List<String> userNameInput;
  private List<String> userTextInput;

  public PythonService(List<String> userNameInput, List<String> userTextInput) {
    this.userNameInput = userNameInput;
    this.userTextInput = userTextInput;
  }

  public List<String> getUserNameInput() {
    return userNameInput;
  }

  public List<String> getUserTextInput() {
    return userTextInput;
  }
}
