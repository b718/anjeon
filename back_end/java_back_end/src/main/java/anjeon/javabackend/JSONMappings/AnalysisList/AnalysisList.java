package anjeon.javabackend.JSONMappings.AnalysisList;

import anjeon.javabackend.JSONMappings.Analysis.Analysis;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AnalysisList {

  private String id;
  private List<Analysis> analyses;

  public AnalysisList(@JsonProperty("analyses") List<Analysis> analysisList) {
    this.analyses = analysisList;
  }

  public List<Analysis> getAnalyses() {
    return analyses;
  }
}
