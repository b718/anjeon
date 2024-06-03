package anjeon.javabackend.UtilsAPI;

import anjeon.javabackend.JSONMappings.UserInputJSON.UserInputJSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
  void testNewUserInput() {
    String text = "{userTextInput: 'asd'}";
    String json = gson.toJson(new UserInputJSON("asd"));
    UserInputJSON test = gson.fromJson(text, UserInputJSON.class);
    System.out.println(test.getText());
    System.out.println(json);
  }
}
