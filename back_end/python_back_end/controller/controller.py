import flask
import collections
from machine_learning import (wordsToFeatures, svm_rbf, random_forests, logistic_regression)

wordToFeatures = svmRbf = randomForests = logisticRegression = None
app = flask.Flask(__name__)

@app.route("/")
def startServer():
    wordToFeatures = wordsToFeatures.wordToFeatures()
    svmRbf = svm_rbf.SvmRbf(wordToFeatures.X_train, wordToFeatures.y_train)    
    randomForests = random_forests.randomForests(wordToFeatures.X_train, wordToFeatures.y_train)
    logisticRegression = logistic_regression.LogisticRegression(wordToFeatures.X_train, wordToFeatures.y_train)
    return "Anjeon Python On!"


@app.route("/analyze-probability", methods=["POST"])
def analyzeProbability():
    data = flask.request.get_json()
    nameMap = collections.defaultdict(list)

    for name in data.keys():
        nameMap[name] = data[name]
    
    return flask.jsonify("85%"), 200

if (__name__ == "__main__"):
    app.run(port=5000, debug=True)
