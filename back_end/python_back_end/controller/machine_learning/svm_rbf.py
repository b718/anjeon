from sklearn.pipeline import Pipeline
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.svm import SVC

class SvmRbf:
    def __init__(self, X_train, y_train):
        self.pipeLine = Pipeline(
            steps=[('bag_of_words', CountVectorizer()),
                    ('svm_rbf', SVC(kernel='rbf', probability=True))]
            )
        self.train(X_train, y_train)
    
    def train(self, X_train, y_train):
        self.pipeLine.fit(X_train, y_train)

    def predict(self, text):
        return self.pipeLine.predict_proba([text])[0]
        