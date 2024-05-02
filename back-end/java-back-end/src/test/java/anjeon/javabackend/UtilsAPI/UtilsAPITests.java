package anjeon.javabackend.UtilsAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilsAPITests {

  @Test
  void checkStringSplits() {
    String testString = "phil,    asdaaASDAASdsad,   bill asdas, silver12321W";
    List<String> result = UtilsAPI.changeString(testString);
    List<String> expectedResults = List.of("phil", "asdaaasdaasdsad", "bill asdas", "silver12321w");
    System.out.println(result);
    System.out.println("Expected: " + expectedResults);
    assertEquals(result, expectedResults);
  }
}
