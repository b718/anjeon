package anjeon.javabackend.UtilsAPI;

import anjeon.javabackend.JSONMappings.UserAndDialogue.UserAndDialogue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilsAPI {

  public static List<String> changeString(String input) {
    List<String> result = new ArrayList<>(List.of(input.split(",")));

    for (int i = 0; i < result.size(); i++) {
      result.set(i, result.get(i).trim().toLowerCase());
    }

    return result;
  }

  public static Map<String, List<String>> findUserDialogues(String input, List<String> users) {
    Map<String, List<String>> userDialogueMap = new HashMap<>();

    for (String name : users) {
      userDialogueMap.put(name, new ArrayList<>());
    }

    List<String> userTextInputSplit = List.of(input.toLowerCase().split("\n"));

    String currentUser = "";

    for (String query : userTextInputSplit) {
      boolean foundUser = false;

      for (int i = 0; i < query.length(); i++) {
        String currentQuery = query.substring(0, i);

        if (userDialogueMap.containsKey(currentQuery) && !currentUser.equals(currentQuery)) {
          userDialogueMap.get(currentQuery).add(query.substring(i));

          if (!currentUser.isEmpty()) {
            userDialogueMap.get(currentUser).add(query.substring(i));
          }

          currentUser = currentQuery;
          foundUser = true;
        }
      }

      if (!foundUser && !currentUser.isEmpty()) {
        userDialogueMap.get(currentUser).add(query);
      }
    }

    return userDialogueMap;
  }

  public static List<UserAndDialogue> getUserAndDialogueObjectList(
      Map<String, List<String>> userToDialogueMap) {
    List<UserAndDialogue> userAndDialogueList = new ArrayList<>();

    for (String key : userToDialogueMap.keySet()) {
      List<String> value = userToDialogueMap.get(key);

      if (value.isEmpty()) {
        continue;
      }

      userAndDialogueList.add(new UserAndDialogue(key, userToDialogueMap.get(key)));
    }

    return userAndDialogueList;
  }
}
