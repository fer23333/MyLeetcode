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

```
Here are the steps to k-means clustering:
1. Define the k centroids. Initialize these at random (there are also fancier algorithms for initializing the centroids that end up converging more effectively).
2. Find the closest centroid & update cluster assignments. Assign each data point to one of the k clusters. Each data point is assigned to the nearest centroid’s cluster. Here, the measure of “nearness” is a hyperparameter — often Euclidean distance.
3. Move the centroids to the center of their clusters. The new position of each centroid is calculated as the average position of all the points in its cluster.
Keep repeating steps 2 and 3 until the centroid stop moving a lot at each iteration (i.e., until the algorithm converges).
```
![alt text](https://cdn-images-1.medium.com/max/1600/0*i8ErSXipZpjNWjk4.)

### Hierarchical clustering
Hierarchical clustering is similar to regular clustering, except that you’re aiming to build a hierarchy of clusters. This can be useful when you want flexibility in how many clusters you ultimately want.

```
Here are the steps for hierarchical clustering:
1. Start with N clusters, one for each data point.
2. Merge the two clusters that are closest to each other. Now you have N-1 clusters.
3. Recompute the distances between the clusters. There are several ways to do this (see this tutorial for more details). One of them (called average-linkage clustering) is to consider the distance between two clusters to be the average distance between all their respective members.
4. Repeat steps 2 and 3 until you get one cluster of N data points. You get a tree (also known as a dendrogram) like the one below.
5. Pick a number of clusters and draw a horizontal line in the dendrogram. For example, if you want k=2 clusters, you should draw a horizontal line around “distance=20000.” You’ll get one cluster with data points 8, 9, 11, 16 and one cluster with the rest of the data points. In general, the number of clusters you get is the number of intersection points of your horizontal line with the vertical lines in the dendrogram.
```

![alt text](https://cdn-images-1.medium.com/max/1600/1*DSrma_nUW4w9NLSccMAeYQ.png)

### Dimensionality reduction

two common techniques in practice: *principal component analysis and singular value decomposition.*
Dimensionality reduction looks a lot like compression. This is about trying to reduce the complexity of the data while keeping as much of the relevant structure as possible

#### Principal component analysis (PCA)

To select the most significant principal components, we look at how much of the data’s variance they capture and order them by that metric.

Another way of thinking about this is that PCA remaps the space in which our data exists to make it more compressible. The transformed dimension is smaller than the original dimension.

By making use of the first several dimensions of the remapped space only, we can start gaining an understanding of the dataset’s organization. This is the promise of dimensionality reduction: reduce complexity (dimensionality in this case) while maintaining structure (variance).

#### Singular value decomposition (SVD)

Let’s represent our data like a big A = m x n matrix. SVD is a computation that allows us to decompose that big matrix into a product of 3 smaller matrices 

![alt text](https://cdn-images-1.medium.com/max/1600/0*TOPSIsdW8kCzUTnl.)


# Neural Networks & Deep Learning
```
Y = f(X) + ϵ
Training: machine learns f from labeled training data
Testing: machine predicts Y from unlabeled testing data
```

The real world is messy, so sometimes f is complicated. In natural language problems large vocabulary sizes mean lots of features. Vision problems involve lots of visual information about pixels. Playing games requires making a decision based on complex scenarios with many possible futures. The learning techniques we’ve covered so far do well when the data we’re working with is not insanely complex, but it’s not clear how they’d generalize to scenarios like these.

Deep learning is really good at learning f, particularly in situations where the data is complex. In fact, artificial neural networks are known as universal function approximators because they’re able to learn any function, no matter how wiggly, with just a single hidden layer.

![alt text](https://cdn-images-1.medium.com/max/1600/1*v-cD3i3sa1uztkQliinImQ.png)

The input X is, say, a greyscale image represented by a w-by-h matrix of pixel brightnesses. The output Y is a vector of class probabilities. This means we have as an output the probability of each class being the correct label. If this neural net is working well, the highest probability should be for the correct class. And the layers in the middle are just doing a bunch of matrix multiplication by summing activations x weights with non-linear transformations (activation functions) after every hidden layer to enable the network to learn a non-linear function.

Incredibly, you can use gradient descent in the exact same way that we did with linear regression in Part 2.1 to train these parameters in a way that minimizes loss. So with a lot of examples and a lot of gradient descent, the model can learn how to classify images of animals correctly. And that, in a nutshell’s nutshell, is “deep learning”.

## Neurons, feature learning, and layers of abstraction

![alt text](https://cdn-images-1.medium.com/max/1600/1*Jyjubgdk41aFI41dT4FY0Q.png)

## Deep learning software packages. 
You’ll rarely need to implement all the parts of neural networks from scratch because of existing libraries and tools that make deep learning implementations easier. There are many of these: TensorFlow, Caffe, Torch, Theano, and more.

## Convolutional neural networks (CNNs). 
CNNs are designed specifically for taking images as input, and are effective for computer vision tasks. They are also instrumental in deep reinforcement learning. CNNs are specifically inspired by the way animal visual cortices work, and they’re the focus of the deep learning course we’ve been referencing throughout this article, Stanford’s CS231n.

## Recurrent neural networks (RNNs). 
RNNs have a sense of built-in memory and are well-suited for language problems. They’re also important
in reinforcement learning since they enable the agent to keep track of where things are and what happened historically even when those elements aren’t all visible at once. Christopher Olah wrote an excellent walkthrough of RNNs and LSTMs in the context of language problems.

