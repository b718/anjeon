from sklearn.pipeline import Pipeline
from sklearn.ensemble import RandomForestClassifier
from sklearn.feature_extraction.text import CountVectorizer

class RandomForests:
    def __init__(self, X_train, y_train):
        self.pipeLine = Pipeline(
            steps=[('bag_of_words', CountVectorizer()),
                    ('random_forest', RandomForestClassifier())]
            )
        self.train(X_train, y_train)

    def train(self, X_train, y_train):
        self.pipeLine.fit(X_train, y_train)

    def predict(self, text):
        return self.pipeLine.predict_proba([text])[0]