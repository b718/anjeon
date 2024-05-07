package anjeon.javabackend.JSONMappings.AnalysisList;

import anjeon.javabackend.JSONMappings.Analysis.Analysis;
import java.util.List;

public class AnalysisList {

  private String id;
  private List<Analysis> analyses;

  public AnalysisList(List<Analysis> analysisList) {
    this.analyses = analysisList;
  }

  public List<Analysis> getAnalysesa() {
    return analyses;
  }
}
