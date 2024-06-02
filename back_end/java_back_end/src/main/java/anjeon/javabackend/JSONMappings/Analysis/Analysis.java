package anjeon.javabackend.JSONMappings.Analysis;

import anjeon.javabackend.JSONMappings.AnalysisText.AnalysisText;

public class Analysis {
  private String id;
  private AnalysisText analysis;

  public Analysis(AnalysisText analysisText) {
    this.analysis = analysisText;
  }

  public AnalysisText getAnalysisText() {
    return analysis;
  }
}
