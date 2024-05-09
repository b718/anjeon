import flask
import collections
from machine_learning import (words_to_features, svm_rbf, random_forests, logistic_regression)

wordToFeatures = svmRbf = randomForests = logisticRegression = None
app = flask.Flask(__name__)

@app.route("/")
def startServer():
    wordToFeatures = words_to_features.WordsToFeatures()
    print("Words To Features Done")

    randomForests = random_forests.RandomForests(wordToFeatures.X_train, wordToFeatures.y_train)
    print("Random Forests Done")

    logisticRegression = logistic_regression.LogisticRegression(wordToFeatures.X_train, wordToFeatures.y_train)
    print("Logistic Regression Done")

    svmRbf = svm_rbf.SvmRbf(wordToFeatures.X_train, wordToFeatures.y_train)    
    print("SVM RBF Done")

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
