# Walmart Labs interview: Drone Delievry 

```
Author: Lei Zhang

Interviewer:
Surafel Korse - Staff Software Engineer, Walmart Retail Technology – East
Yatman Hau - Sr. Software Engineer, Walmart Retail Technology – East
Shreedhar Ramachandra - Senior Software Engineer, Walmart Retail Technology - East

Thanks for your time!

Date: 05/16/2019
```

## Assumption

```
1. OrderDirection format strictly follows: N/S X + E/W Y. OrderID format strictly follows: WMXXXX (4 digits). 
Order TimeStamp format strictly follows: HH:MM:SS and will not exceed 24(24-hour Time Format) . All input formats are valid.
2. Assume drone only goes straight and we calculate distance X+Y not sqrt(X^2 + Y^2)
3. OrderTime always within a day, we do not consider overtime order or can't finish before 10PM.
Time is always valid and are in the same day. We can assume Input is from 6 a.m. until 10 p.m. And the drone is able to finish the work same day(clear the order in warehouse).

3.(alternative way) drone only works from 6:00 - 22:00. start to work at 6 and if the task can't be finished by 22:00, give up that delivery.
4. Orders come as a data stream, you never know if you have next order or when will you have next order.
5. OrderDistance is always within the range of the Drone(within warehouse delivery range).
6. NPS Calculation:
	 0 <= Waiting Time <= 1 hour : Promoters
	 1 < Waiting Time <= 3 hours : Neutral
	 3 < Waiting Time            : Detractors
7. When only one order comes, deliver it regardless its distance, since you never know when is the next order.
8. If and Only if one order exists, even the delivery time > 3 hours(Must be detractors). 
   the scheduler has to deliver this item.
   But if delivery time > 3 hours and it's not the only item, put this item the last to deliver.
9. Drone delivers one item at a time and have to go back to warehouse to pick up the next item.
10. when dealing with multiple orders. 
	
```

## Instruction



## Future Usage

http://www.optimization-online.org/DB_FILE/2017/09/6206.pdf
```
1. Starve situation
2. Time outside of 6:00am - 10:00pm  need to wait till the next day
3. Should work under -- Different ID format; Different position format; Different timestamp format
	eg: If not Manhattan distance ? 
4. Order which is tooooooo far away (eg: cross state) --> push to corresponding warehouse
5. If memory is filled up by the input stream ?
6. How about drone can carry N goods at a time?
7. Certain goods(eg:food) need to be delivered within a time? (Can't be in waiting queue for too long)
8. If current task is too far, wait for a certain time.
9. What if there are multiple Drones doing the delivery job 
	Multi-threads with synchronizing, lock waiting queue
10. Scheduler can set a extra waiting time as "et". When far order comes, wait an extra time of "et",
   if there is no shorter ones coming, then deliver; otherwise, deliver the shorter one.
   the threshold of et is
				et = (EarlierLongerTime - LaterShorterTime)/2   (I calculate it with Math)
   Since LaterShorterTime is unknown when we only have the EarlierLongerTime,
   we can estimate it as 
				LaterShorterTime = (1/n) * EarlierLongerTime 
   So the final et can be estimated as
				et = ((n - 1)/n) EarlierLongerTime / 2
   in which, n is set by the programmer, EarlierLongerTime = n * LaterShorterTime
   But this also has an issue: Suppose we have a EarlierLongerTime = t,  it waited for t/2. After
   waiting, it is delivered, and as soon as it is delivered, a shorter task comes. If long task
   didn't wait, it should have come back earlier so that the shorter task won't be detractors. But
   since long task wait for t/2, the shorter task now becomes detractors. The solution to this problem
   is to calculate the possibilities of wait or not wait situation, and choose whether use wait or not.
   
   
   compare different kinds of ways of delivering: closet first, farthest first, smart wait(need to test parameters).
   
   add machie learning algorithm to find the optimal way(with enough dataset, more concise model and better result)
   
    multiple warehouse, multiple drones, carry multiple items.


```
