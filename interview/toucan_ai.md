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

![alt text](https://cdn-images-1.medium.com/max/1600/0*ZaEKARNxNgB7-H3F.)

### overfitting

to avoid that

1. Use more training data. The more you have, the harder it is to overfit the data by learning too much from any single training example.

2. Use regularization. Add in a penalty in the loss function for building a model that assigns too much explanatory power to any one feature or allows too many features to be taken into account.
![alt text](https://cdn-images-1.medium.com/max/1600/1*lb7lEh2Ob5PAJLtnAyGSBA.png)

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
It typically solves the same problem as logistic regression — classification with two classes — and yields similar performance. It’s worth understanding because the algorithm is geometrically motivated in nature, rather than being driven by probabilistic thinking.

A few examples of the problems SVMs can solve:

Is this an image of a cat or a dog?
Is this review positive or negative?
Are the dots in the 2D plane red or blue?

We’ll use the third example to illustrate how SVMs work. Problems like these are called toy problems because they’re not real — but nothing is real, so it’s fine.

![alt text](https://cdn-images-1.medium.com/max/1600/0*_J_T8BQq8g46GJ6n.)

We would like to classify new, unclassified points in this plane. To do this, SVMs use a separating line (or, in more than two dimensions, a multi-dimensional hyperplane) to split the space into a red zone and a blue zone. You can already imagine how a separating line might look in the graph above.

The distance to the nearest point on either side of the line is called the margin, and SVM tries to maximize the margin. You can think about it like a safety space: the bigger that space, the less likely that noisy points get misclassified.

### if you can’t separate the data cleanly
1. Soften the definition of “separate”.

2. Throw the data into higher dimensions.

## supervised learning part iii:

Non-parametric learners

### k-nearest neighbors (k-NN)
k-NN seems almost too simple to be a machine learning algorithm. The idea is to label a test data point x by finding the mean (or mode) of the k closest data points’ labels.

The fact that k-NN doesn’t require a pre-defined parametric function f(X) relating Y to X makes it well-suited for situations where the relationship is too complex to be expressed with a simple linear model.

### Decision trees, random forests
决策树 多叉树 算信息熵 离散化数据 然后做aggregate 防止过拟合
![alt text](https://cdn-images-1.medium.com/max/1600/0*Rin05YSBfRZBlCxI.)
![alt text](https://cdn-images-1.medium.com/max/1600/0*bZ2NR-JYpcYhb3WJ.)

There are many other clever ensemble models that combine decision trees and yield excellent performance — check out XGBoost (Extreme Gradient Boosting) as an example.

# unsupervised learning

“unsupervised” because you start with unlabeled data

extract feature

The two unsupervised learning tasks we will explore are clustering the data into groups by similarity and reducing dimensionality to compress the data while maintaining its structure and usefulness.

### k-means clustering

The goal of clustering is to create groups of data points such that points in different clusters are dissimilar while points within a cluster are similar.

With k-means clustering, we want to cluster our data points into k groups. A larger k creates smaller groups with more granularity, a lower k means larger groups and less granularity.

The output of the algorithm would be a set of “labels” assigning each data point to one of the k groups. In k-means clustering, the way these groups are defined is by creating a centroid for each group. The centroids are like the heart of the cluster, they “capture” the points closest to them and add them to the cluster.
![alt text](https://cdn-images-1.medium.com/max/1600/0*i8ErSXipZpjNWjk4.)
### Hierarchical clustering

### Dimensionality reduction

