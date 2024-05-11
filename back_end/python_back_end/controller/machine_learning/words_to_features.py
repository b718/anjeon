import pandas as pd
import sklearn
import stop_words as sw
import re
import sklearn  
import sklearn.model_selection
class WordsToFeatures:
    # In this class, 0 means not cyberbullying and 1 means cyberbullying
    def __init__(self):
        self.__bullying_data_frame = pd.read_csv("data/cyberbullying_tweets.csv")
        self.stop_words_set = set(sw.get_stop_words("en"))
        self.__clean_bully_data_frame()
        self.split_data()

    def __clean_bully_data_frame(self):
        self.__bullying_data_frame["cyberbullying_type"] = self.__bullying_data_frame["cyberbullying_type"].apply(lambda label: 0 if label == "not_cyberbullying" else 1)
        self.__bullying_data_frame["tweet_text"] = self.__bullying_data_frame["tweet_text"].apply(lambda text: re.sub(r'http\S+', '', text))
        self.__bullying_data_frame["tweet_text"] = self.__bullying_data_frame["tweet_text"].apply(lambda text: re.sub(r'[^\x00-\x7F]+', '', text))
        self.__bullying_data_frame["tweet_text"] = self.__bullying_data_frame["tweet_text"].apply(lambda text: re.sub(r'[^a-zA-Z0-9\s]+', '', text))
        self.__bullying_data_frame["tweet_text"] = self.__bullying_data_frame["tweet_text"].apply(lambda text: text.lower())
        self.__bullying_data_frame["tweet_text"] = self.__bullying_data_frame["tweet_text"].apply(lambda text: ' '.join([word for word in text.split() if word not in self.stop_words_set]))

    def split_data(self):
        X = self.__bullying_data_frame["tweet_text"]
        y = self.__bullying_data_frame["cyberbullying_type"]
        self.X_train, self.X_test, self.y_train, self.y_test = sklearn.model_selection.train_test_split(X, y, test_size=0.2, random_state=123, shuffle=True)

    def predict(self, text):
        pass


    

