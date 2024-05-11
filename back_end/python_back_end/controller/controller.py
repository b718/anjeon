import flask
import collections
from machine_learning import (words_to_features, svm_rbf, random_forests, logistic_regression)
from api_utils import (api_utils)
from flask_cors import CORS, cross_origin

app = flask.Flask(__name__)
CORS(app, resources={r"/*": {"origins": "*"}})
app.config['CORS_HEADERS'] = 'Content-Type'

@app.route("/")
def startServer():
    wordToFeatures = words_to_features.WordsToFeatures()
    print("Words To Features Done")

    global randomForests 
    randomForests = random_forests.RandomForests(wordToFeatures.X_train, wordToFeatures.y_train)
    print("Random Forests Done")

    global logisticRegression
    logisticRegression = logistic_regression.LogisticRegression(wordToFeatures.X_train, wordToFeatures.y_train)
    print("Logistic Regression Done")

    global svmRbf
    svmRbf = svm_rbf.SvmRbf(wordToFeatures.X_train, wordToFeatures.y_train)    
    print("SVM RBF Done")

    return "Anjeon Python On!"


@app.route("/analyze-probability", methods=["POST"])
def analyzeProbability():
    data = flask.request.get_json()["usersAndDialogues"]
    nameMap = api_utils.ApiUtilities.userAndDialogueToDict(data)
    models = [randomForests, logisticRegression, svmRbf]
    JSONMap = collections.defaultdict(list)
    JSONMap["analyses"] = api_utils.ApiUtilities.getProbabilites(nameMap, models)
    return flask.jsonify(JSONMap), 200

if (__name__ == "__main__"):
    app.run(port=8000, debug=True)
