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


# Reinforcement Learning

1. The exploration/exploitation tradeoff
2. Markov Decision Processes (MDPs), the classic setting for RL tasks
3. Q-learning, policy learning, and deep reinforcement learning
4. and lastly, the value learning problem

## The exploration/exploitation tradeoff

This brings up the exploration/exploitation tradeoff. One simple strategy for exploration would be for the mouse to take the best known action most of the time (say, 80% of the time), but occasionally explore a new, randomly selected direction even though it might be walking away from known reward.

This strategy is called the epsilon-greedy strategy, where epsilon is the percent of the time that the agent takes a randomly selected action rather than taking the action that is most likely to maximize reward given what it knows so far (in this case, 20%). We usually start with a lot of exploration (i.e. a higher value for epsilon). Over time, as the mouse learns more about the maze and which actions yield the most long-term reward, it would make sense to steadily reduce epsilon to 10% or even lower as it settles into exploiting what it knows.

##  Markov Decision Processes (MDPs)

MDPs include:
```
A finite set of states. These are the possible positions of our mouse within the maze.

A set of actions available in each state. This is {forward, back} in a corridor and {forward, back, left, right} at a crossroads.

Transitions between states. For example, if you go left at a crossroads you end up in a new position. These can be a set of probabilities that link to more than one possible state (e.g. when you use an attack in a game of Pokémon you can either miss, inflict some damage, or inflict enough damage to knock out your opponent).

Rewards associated with each transition. In the robot-mouse example, most of the rewards are 0, but they’re positive if you reach a point that has water or cheese and negative if you reach a point that has an electric shock.

A discount factor γ between 0 and 1. This quantifies the difference in importance between immediate rewards and future rewards. For example, if γ is .9, and there’s a reward of 5 after 3 steps, the present value of that reward is .9³*5.

Memorylessness. Once the current state is known, the history of the mouse’s travels through the maze can be erased because the current Markov state contains all useful information from the history. In other words, “the future is independent of the past given the present”.
```

![alt text](https://cdn-images-1.medium.com/max/1600/0*qHo_9UFMQd7kJlr2.)

we are trying to max the reward
Let’s look at this sum term by term. First of all, we’re summing across all time steps t. Let’s set γ at 1 for now and forget about it. r(x,a) is a reward function. For state x and action a (i.e., go left at a crossroads) it gives you the reward associated with taking that action a at state x. Going back to our equation, we’re trying to maximize the sum of future rewards by taking the best action in each state.



## Q-learning: learning the action-value function

Q-learning is a technique that evaluates which action to take based on an action-value function that determines the value of being in a certain state and taking a certain action at that state.

We have a function Q that takes as an input one state and one action and returns the expected reward of that action (and all subsequent actions) at that state. Before we explore the environment, Q gives the same (arbitrary) fixed value. But then, as we explore the environment more, Q gives us a better and better approximation of the value of an action a at a state s. We update our function Q as we go.

```
Learning rate alpha: this is how aggressive we want to be when updating our value. When alpha is close to 0, we’re not updating very aggressively. When alpha is close to 1, we’re simply replacing the old value with the updated value.

The reward is the reward we got by taking action at at state st. So we’re adding this reward to our old estimate.

We’re also adding the estimated future reward, which is the maximum achievable reward Q for all available actions at xt+1.

Finally, we subtract the old value of Q to make sure that we’re only incrementing or decrementing by the difference in the estimate (multiplied by alpha of course).
```

Now that we have a value estimate for each state-action pair, we can select which action to take according to our action-selection strategy (we don’t necessarily just choose the action that leads to the most expected reward every time, e.g. with an epsilon-greedy exploration strategy we’d take a random action some percentage of the time).

In the robot mouse example, we can use Q-learning to figure out the value of each position in the maze and the value of the actions {forward, backward, left, right} at each position. Then we can use our action-selection strategy to choose what the mouse actually does at each time step.


## Policy learning: a map from state to action

Policy learning is a more straightforward alternative in which we learn a policy function, π, which is a direct map from each state to the best corresponding action at that state. Think of it as a behavioral policy: “when I observe state s, the best thing to do is take action a”. For example, an autonomous vehicle’s policy might effectively include something like: “if I see a yellow light and I am more than 100 feet from the intersection, I should brake. Otherwise, keep moving forward.”

