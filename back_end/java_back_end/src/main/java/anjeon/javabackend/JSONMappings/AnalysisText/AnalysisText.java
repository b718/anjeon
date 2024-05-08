package anjeon.javabackend.JSONMappings.AnalysisText;

public class AnalysisText {

  private String id;
  private String not_bullying_probability;
  private String bullying_probability;
  private String text;

  public AnalysisText(String not_bullying_probability, String bullying_probability, String text) {
    this.not_bullying_probability = not_bullying_probability;
    this.bullying_probability = bullying_probability;
    this.text = text;
  }

  public String getNot_bullying_probability() {
    return not_bullying_probability;
  }

  public String getBullying_probability() {
    return bullying_probability;
  }

  public String getText() {
    return text;
  }
}
