package anjeon.javabackend.JSONMappings.PythonService;

public class PythonService {
  private String id;
  private String text;

  public PythonService(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
