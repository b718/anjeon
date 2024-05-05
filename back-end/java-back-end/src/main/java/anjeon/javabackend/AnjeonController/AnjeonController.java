package anjeon.javabackend.AnjeonController;

import anjeon.javabackend.JSONMappings.Analysis.Analysis;
import anjeon.javabackend.JSONMappings.PythonService.PythonService;
import anjeon.javabackend.JSONMappings.UserAndDialogue.UserAndDialogue;
import anjeon.javabackend.JSONMappings.UserInputJSON.UserInputJSON;
import anjeon.javabackend.UtilsAPI.UtilsAPI;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnjeonController {

  private final Gson gson;

  public AnjeonController(Gson gson) {
    this.gson = gson;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping("/analyze-data")
  public ResponseEntity<Analysis> analyzeData(@RequestBody UserInputJSON userInputJSON) {
    List<String> userNameInput = UtilsAPI.changeString(userInputJSON.getUserNameInput());
    Map<String, List<String>> userToDialogueMap =
        UtilsAPI.findUserDialogues(userInputJSON.getUserTextInput(), userNameInput);

    List<UserAndDialogue> userAndDialogueList = new ArrayList<>();

    for (String key : userToDialogueMap.keySet()) {
      List<String> value = userToDialogueMap.get(key);

      if (value.isEmpty()) {
        continue;
      }

      userAndDialogueList.add(new UserAndDialogue(key, userToDialogueMap.get(key)));
    }

    String pythonServiceJSON = gson.toJson(new PythonService(userAndDialogueList));

    // Send request to python here!

    return ResponseEntity.ok(new Analysis("0.9"));
  }
}
