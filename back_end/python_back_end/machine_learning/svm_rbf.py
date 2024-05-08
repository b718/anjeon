import sklearn

class SvmRbf:
    def __init__(self, X_train, y_train):
        self.pipeLine = sklearn.pipeline.Pipeline(
            steps=[('bag_of_words', sklearn.feature_extraction.text.CountVectorizer()),
                    ('svm_rbf', sklearn.svm.SVC(kernel='rbf'))]
            )
        self.train(X_train, y_train)
    
    def train(self, X_train, y_train):
        self.pipeLine.fit(X_train, y_train)

    def predict(self, text):
        pass