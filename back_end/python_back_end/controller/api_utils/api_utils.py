import collections

class ApiUtilities:
    def getProbabilites(data, modelList):
        analysisTextMap = collections.defaultdict(str)
        probabilityOfBullying = 0

        for model in modelList:
            probabilityOfBullying += model.predict(data)[0]

        probabilityOfBullying /= len(modelList) 
        analysisTextMap["text"] = data
        analysisTextMap["not_bullying_probability"] = '{:.2f}'.format((1 - probabilityOfBullying) * 100) + "%"
        analysisTextMap["bullying_probability"] = '{:.2f}'.format(probabilityOfBullying * 100) + "%"
        return analysisTextMap
