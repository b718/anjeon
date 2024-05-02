package anjeon.javabackend.JSONMappings.Analysis;

public class Analysis {
  private String id;
  private String probability;

  public Analysis(String probability) {
    this.probability = probability;
  }

  public String getProbability() {
    return probability;
  }
}
