package anjeon.javabackend.JSONMappings.Analysis;

import anjeon.javabackend.JSONMappings.AnalysisText.AnalysisText;
import java.util.List;

public class Analysis {
  private String id;
  private List<AnalysisText> analysis;
  private String name;

  public Analysis(String name, List<AnalysisText> analysisTextList) {
    this.name = name;
    this.analysis = analysisTextList;
  }

  public String getName() {
    return name;
  }

  public List<AnalysisText> getAnalysisTextList() {
    return analysis;
  }
}
