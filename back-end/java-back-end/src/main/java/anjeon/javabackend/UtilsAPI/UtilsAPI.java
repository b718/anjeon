package anjeon.javabackend.UtilsAPI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UtilsAPI {

  public static List<String> changeString(String input) {
    List<String> result = new ArrayList<>(List.of(input.split(",")));

    for (int i = 0; i < result.size(); i++) {
      result.set(i, result.get(i).trim().toLowerCase());
    }

    return result;
  }

  public static List<String> findUserDialogues(String input, List<String> users) {
    Set<String> userSet = new HashSet<>(users);

    return null;
  }
}
