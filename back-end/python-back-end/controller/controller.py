import flask
import collections
from machine_learning import wordToFeatures

app = flask.Flask(__name__)

@app.route("/")
def startServer():
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
