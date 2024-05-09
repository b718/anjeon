from sklearn.pipeline import Pipeline
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.linear_model import LogisticRegression as LogisticRegressionModel

class LogisticRegression:
    def __init__(self, X_train, y_train):
        self.pipeLine = Pipeline(
            steps=[('bag_of_words', CountVectorizer()),
                    ('logistic_regression', LogisticRegressionModel(max_iter=1000))]
            )
        self.train(X_train, y_train)
    
    def train(self, X_train, y_train):
        self.pipeLine.fit(X_train, y_train)
    
    def predict(self, text):
        pass