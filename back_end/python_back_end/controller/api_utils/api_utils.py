import collections
import datetime
import csv
import os
class ApiUtilities:
    def getProbabilites(data, modelList):
        analysisTextMap = collections.defaultdict(str)
        probabilityOfBullying = 0

        for model in modelList:
            probabilityOfBullying += model.predict(data)[0]

        # probabilityOfBullying /= len(modelList) 
        analysisTextMap["text"] = data
        analysisTextMap["not_bullying_probability"] = '{:.2f}'.format((1 - probabilityOfBullying) * 100) + "%"
        analysisTextMap["bullying_probability"] = '{:.2f}'.format(probabilityOfBullying * 100) + "%"
        return analysisTextMap

    def createCSVFile(analysisTextMap, s3):
        '''
        analysisTextMap["text"] = data
        analysisTextMap["not_bullying_probability"] = '{:.2f}'.format((1 - probabilityOfBullying) * 100) + "%"
        analysisTextMap["bullying_probability"] = '{:.2f}'.format(probabilityOfBullying * 100) + "%"
        '''
        
        headers = ["tweet_text","cyberbullying_type"]
        fileName = f"text_{datetime.datetime.now().strftime('%Y-%m-%d-%H-%M-%S')}"
        result = "not_cyberbullying" if float(analysisTextMap["not_bullying_probability"][:-1]) >= 70 else "cyberbullying"

        with open(f"{fileName}.csv", "w") as file:
            bullyText = csv.writer(file)
            bullyText.writerow(headers)
            bullyText.writerow([analysisTextMap["text"], result])
        
        s3.upload_file(f"{fileName}.csv", "anjeon-text-bucket", f"{fileName}.csv")
        os.remove(f"{fileName}.csv")
        
        

        