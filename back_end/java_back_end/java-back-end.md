# Java Back-End For Anjeon

## Get Started

To get started, type we are use Gradle for this project. So, you need to install Gradle first. You
can download it from [Gradle](https://gradle.org/install/).

## Functions

### UtilsAPI

- `public static List<String> changeString(String input)` : Change the input string to a list of
  string. The input string is separated by a comma.
- `  public static Map<String, List<String>> findUserDialogues(String input, List<String> users)` :
  Find the dialogues of the users in the input string. The input string is separated by a comma. We
  return a map of the user and the list of dialogues of the user, so we can easily access it in the
  endpoints.
- `  public static List<UserAndDialogue> getUserAndDialogueObjectList(
  Map<String, List<String>> userToDialogueMap)` : Use the HashMap to group each user and their
  dialogues to prepare to send to Python Service to analyze probabilities of bullying text.

## AnjeonController

### Endpoints

- `public ResponseEntity<Analysis> analyzeData(@RequestBody UserInputJSON userInputJSON)` : This is
  a post mapping endpoint that receives a JSON object of the user input. The JSON object has a field
  called `input` which is the input string that we want to analyze. The endpoint will return a JSON
  object of the analysis result. The analysis result has a field called `result` which is a list of
  the user dialogues. The user dialogues are separated by the user-name.
    - This will communicate with our Python service to get the analysis of the input string.

