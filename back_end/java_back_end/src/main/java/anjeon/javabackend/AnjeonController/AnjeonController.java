package anjeon.javabackend.AnjeonController;

import anjeon.javabackend.JSONMappings.Analysis.Analysis;
import anjeon.javabackend.JSONMappings.PythonService.PythonService;
import anjeon.javabackend.JSONMappings.UserInputJSON.UserInputJSON;
import com.google.gson.Gson;
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
  public ResponseEntity<Analysis> analyzeData(@RequestBody UserInputJSON userInputJson) {
    String pythonServiceBody = gson.toJson(new PythonService(userInputJson.getText()));
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
    Analysis response = gson.fromJson(pythonServiceResponse, Analysis.class);
    return ResponseEntity.ok(response);
  }
}
