package anjeon.javabackend.JSONMappings.AnalysisText;

public class AnalysisText {

  private String id;
  private String probability;
  private String text;

  public AnalysisText(String probability, String text) {
    this.probability = probability;
    this.text = text;
  }

  public String getProbability() {
    return probability;
  }

  public String getText() {
    return text;
  }
}
