package anjeon.javabackend.JSONMappings.PythonService;

import anjeon.javabackend.JSONMappings.UserAndDialogue.UserAndDialogue;
import java.util.List;

public class PythonService {
  private String id;
  private List<UserAndDialogue> usersAndDialogues;

  public PythonService(List<UserAndDialogue> usersAndDialogues) {
    this.usersAndDialogues = usersAndDialogues;
  }

  public List<UserAndDialogue> getUsersAndDialogues() {
    return usersAndDialogues;
  }
}
