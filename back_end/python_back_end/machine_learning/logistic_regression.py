import sklearn
import sklearn.pipeline

class LogisticRegression:
    def __init__(self, X_train, y_train):
        self.pipeLine = sklearn.pipeline.Pipeline(
            steps=[('bag_of_words', sklearn.feature_extraction.text.CountVectorizer()),
                    ('logistic_regression', sklearn.linear_model.LogisticRegression())]
            )
        self.train(X_train, y_train)
    
    def train(self, X_train, y_train):
        self.pipeLine.fit(X_train, y_train)
    
    def predict(self, text):
        pass