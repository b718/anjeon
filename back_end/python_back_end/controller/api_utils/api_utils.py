import collections

class ApiUtilities:

    def userAndDialogueToDict(data):
        nameMap = collections.defaultdict(list)
        for obj in data:
            user, dialogues = obj["user"], obj["dialogues"]
            for dialogue in dialogues:
                nameMap[user].append(dialogue)
        return nameMap

    def getProbabilites(nameMap, modelList):
        for name in nameMap:
            dialogueAndProbabilities = []
            for dialog in nameMap[name]:
                probabilityOfBullying = 0
                for model in modelList:
                    probabilityOfBullying += model.predict(dialog)[0]
                probabilityOfBullying /= len(modelList) 
                dialogueAndProbabilities.append((dialog, str(round(probabilityOfBullying*100,2)) + "%"))
            nameMap[name] = dialogueAndProbabilities
