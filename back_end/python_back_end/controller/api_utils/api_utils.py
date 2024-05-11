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
        userDialogueList = []

        for name in nameMap:
            nameAndAnalysisMap = collections.defaultdict(list)
            nameAndAnalysisMap["name"] = name 

            for dialog in nameMap[name]:
                analysisTextMap = collections.defaultdict(str)
                probabilityOfBullying = 0

                for model in modelList:
                    probabilityOfBullying += model.predict(dialog)[0]

                probabilityOfBullying /= len(modelList) 
                analysisTextMap["text"] = dialog
                analysisTextMap["not_bullying_probability"] = str(round((1 - probabilityOfBullying) * 100, 2)) + "%"
                analysisTextMap["bullying_probability"] = str(round(probabilityOfBullying * 100, 2)) + "%"
                nameAndAnalysisMap["analysis"].append(analysisTextMap)

            userDialogueList.append(nameAndAnalysisMap)
        
        return userDialogueList
