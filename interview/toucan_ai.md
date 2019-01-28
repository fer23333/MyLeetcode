We're looking for someone interested in pushing the boundaries of open NLP problems like neural question answering, question generation, emotion analysis, and open-domain casual conversation. We're a young startup looking to make our first hires, so applicants can expect to play a key role in making product and business decisions. The ideal candidate: 


Some experience with Natural Language Processing, either research or practical
Experience coding in Python
Familiar with modern machine learning & deep learning techniques (ideally, but not necessarily, in the PyTorch framework)
Preferably familiar with a React-based web-development stack 

Integrated a live chatting robot trained with Tensorflow and NLP model with LSTM for real-time customer service.

# supervised learning:

## main task : 
 1. regression : predicting a continuous value
 
 2.classification 


## supervised learning part i:

### Linear regression (ordinary least squares)

### Gradient descent
it will come up over and over again, especially in neural networks. Machine learning libraries like scikit-learn and TensorFlow use it in the background everywhere, so it’s worth understanding the details.

The goal of gradient descent is to find the minimum of our model’s loss function by iteratively getting a better and better approximation of it.

### overfitting

to avoid that

1. Use more training data. The more you have, the harder it is to overfit the data by learning too much from any single training example.

2. Use regularization. Add in a penalty in the loss function for building a model that assigns too much explanatory power to any one feature or allows too many features to be taken into account.


## supervised learning part ii:

### Classification: predicting :
Classification predicts a discrete target label Y. Classification is the problem of assigning new observations to the class to which they most likely belong, based on a classification model built from labeled training data.

The accuracy of your classifications will depend on the effectiveness of the algorithm you choose, how you apply it, and how much useful training data you have.

### a label Logistic regression: 0 or 1?

![alt ext](https://cdn-images-1.medium.com/max/1600/1*aetAOm7gZEhnAfJzI4gl9A.png)

Logistic regression is a method of classification: the model outputs the probability of a categorical target variable Y belonging to a certain class.

To predict the Y label — spam/not spam, cancer/not cancer, fraud/not fraud, etc. — you have to set a probability cutoff, or threshold

The *threshold* depends on your tolerance for false positives vs. false negatives
![alt ext](https://cdn-images-1.medium.com/max/1600/0*xBLfyr2KkNXajfQp.).

### Minimizing loss with logistic regression

As in the case of linear regression, we use gradient descent to learn the beta parameters that minimize loss.

In logistic regression, the cost function is basically a measure of how often you predicted 1 when the true answer was 0, or vice versa. Below is a regularized cost function just like the one we went over for linear regression.
![alt text](https://cdn-images-1.medium.com/max/1600/1*Tn4B-RYmcb45YsEiZM5Ktg.png)
### Support vector machines (SVMs)


