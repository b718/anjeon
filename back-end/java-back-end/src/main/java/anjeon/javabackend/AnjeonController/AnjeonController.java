package anjeon.javabackend.AnjeonController;

import anjeon.javabackend.JSONMappings.Analysis.Analysis;
import anjeon.javabackend.JSONMappings.PythonService.PythonService;
import anjeon.javabackend.JSONMappings.UserInputJSON.UserInputJSON;
import anjeon.javabackend.UtilsAPI.UtilsAPI;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnjeonController {

  private final Gson gson;

  public AnjeonController(Gson gson) {
    this.gson = gson;
  }

  @PostMapping("/analyze-data")
  public ResponseEntity<Analysis> analyzeData(@RequestBody UserInputJSON userInputJSON) {
    List<String> userNameInput = UtilsAPI.changeString(userInputJSON.getUserNameInput());
    List<String> userTextInput =
        UtilsAPI.findUserDialogues(userInputJSON.getUserTextInput(), userNameInput);

    String pythonServiceJSON = gson.toJson(new PythonService(userNameInput, userTextInput));

    return ResponseEntity.ok(new Analysis("0.9"));
  }
}
