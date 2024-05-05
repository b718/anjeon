package anjeon.javabackend.JSONMappings.UserAndDialogue;

import java.util.List;

public class UserAndDialogue {

  private String id;
  private String user;
  private List<String> dialogues;

  public UserAndDialogue(String user, List<String> dialogues) {
    this.user = user;
    this.dialogues = dialogues;
  }

  public String getUser() {
    return user;
  }

  public List<String> getDialogues() {
    return dialogues;
  }
}
