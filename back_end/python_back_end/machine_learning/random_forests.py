import sklearn
import sklearn.pipeline 
import sklearn.ensemble

class randomForests:
    def __init__(self, X_train, y_train):
        self.pipeLine = sklearn.pipeline.Pipeline(
            steps=[('bag_of_words', sklearn.feature_extraction.text.CountVectorizer()),
                    ('random_forest', sklearn.ensemble.RandomForestClassifier())]
            )
        self.train(X_train, y_train)

    def train(self, X_train, y_train):
        self.pipeLine.fit(X_train, y_train)

    def predict(self, text):
        pass