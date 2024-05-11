package anjeon.javabackend.AnjeonController;

import anjeon.javabackend.JSONMappings.AnalysisList.AnalysisList;
import anjeon.javabackend.JSONMappings.PythonService.PythonService;
import anjeon.javabackend.JSONMappings.UserAndDialogue.UserAndDialogue;
import anjeon.javabackend.JSONMappings.UserInputJSON.UserInputJSON;
import anjeon.javabackend.UtilsAPI.UtilsAPI;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class AnjeonController {

  private final Gson gson;
  private final WebClient webClient;
  private final String pythonServiceURL = "http://127.0.0.1:8000";

  public AnjeonController(Gson gson) {
    this.gson = gson;
    this.webClient = WebClient.create(pythonServiceURL);
  }

  @CrossOrigin(origins = "*")
  @PostMapping("/analyze-data")
  public ResponseEntity<AnalysisList> analyzeData(@RequestBody UserInputJSON userInputJSON) {
    List<String> userNameInput = UtilsAPI.changeString(userInputJSON.getUserNameInput());
    Map<String, List<String>> userToDialogueMap =
        UtilsAPI.findUserDialogues(userInputJSON.getUserTextInput(), userNameInput);
    List<UserAndDialogue> userAndDialogueList =
        UtilsAPI.getUserAndDialogueObjectList(userToDialogueMap);

    String pythonServiceBody = gson.toJson(new PythonService(userAndDialogueList));

    // Send request to python here!
    String pythonServiceResponse =
        webClient
            .post()
            .uri("/analyze-probability")
            .header("Content-Type", "application/json")
            .bodyValue(pythonServiceBody)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(String.class)
            .block();

    AnalysisList response = gson.fromJson(pythonServiceResponse, AnalysisList.class);
    return ResponseEntity.ok(response);
  }
}
