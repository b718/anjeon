package anjeon.javabackend.UtilsAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import anjeon.javabackend.JSONMappings.Analysis.Analysis;
import anjeon.javabackend.JSONMappings.AnalysisList.AnalysisList;
import anjeon.javabackend.JSONMappings.AnalysisText.AnalysisText;
import anjeon.javabackend.JSONMappings.PythonService.PythonService;
import anjeon.javabackend.JSONMappings.UserAndDialogue.UserAndDialogue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilsAPITests {
  private static Gson gson;

  @BeforeAll
  static void setUp() {
    gson = new GsonBuilder().setPrettyPrinting().create();
  }

  @Test
  void checkStringSplits() {
    String testString = "phil,    asdaaASDAASdsad,   bill asdas, silver12321W";
    List<String> result = UtilsAPI.changeString(testString);
    List<String> expectedResults = List.of("phil", "asdaaasdaasdsad", "bill asdas", "silver12321w");
    System.out.println(result);
    System.out.println("Expected: " + expectedResults);
    assertEquals(result, expectedResults);
  }

  @Test
  void findUserDialogues() {
    String testUserText =
        "Dabin — Today at 2:36 PM\n"
            + "Tyrone de Watermelon Oh. that is called step machine to go heaven lol\n"
            + "Tyrone de Watermelon — Today at 2:47 PM\n"
            + "LOL\n"
            + "Yes it really is\n"
            + "Dabin — Today at 3:31 PM\n"
            + "just quick meeting\n"
            + "ready\n"
            + "testname — Today at 3:31 PM\n"
            + "Tyrone de Watermelon test message\n";
    List<String> testUserNames = List.of("dabin", "tyrone de watermelon", "testname");
    Map<String, List<String>> userToDialogueMap =
        UtilsAPI.findUserDialogues(testUserText, testUserNames);

    List<UserAndDialogue> userAndDialogueList = new ArrayList<>();

    for (String key : userToDialogueMap.keySet()) {
      userAndDialogueList.add(new UserAndDialogue(key, userToDialogueMap.get(key)));
    }

    String pythonServiceJSON = gson.toJson(new PythonService(userAndDialogueList));

    System.out.println(pythonServiceJSON);
  }

  @Test
  void getUserAndDialogueObjectList() {
    Map<String, List<String>> userToDialogueMap =
        Map.of("dabin", List.of("hello", "world"), "tyrone", List.of("hi", "there"));
    List<UserAndDialogue> userAndDialogueList =
        UtilsAPI.getUserAndDialogueObjectList(userToDialogueMap);

    List<Analysis> analysisList = new ArrayList<>();
    List<AnalysisText> analysisTextList;

    for (UserAndDialogue userAndDialogue : userAndDialogueList) {
      analysisTextList = new ArrayList<>();
      for (String dialogue : userAndDialogue.getDialogues()) {
        analysisTextList.add(new AnalysisText("60%", "40%", dialogue));
      }

      analysisList.add(new Analysis(userAndDialogue.getUser(), analysisTextList));
    }

    System.out.println(gson.toJson(new AnalysisList(analysisList)));
  }
}