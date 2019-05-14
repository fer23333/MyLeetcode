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
4. Orders come as a data stream, you never know if you have next order or when will you have next order.
5. OrderDistance is always within the range of the Drone(within warehouse delivery range).
6. NPS Calculation:
	 0 <= Waiting Time <= 1 hour : Promoters
	 1 < Waiting Time <= 3 hours : Neutral
	 3 < Waiting Time            : Detractors
7. When only one order comes, deliver it regardless its distance, since you never know when is the next order.
8. If and Only if one order exists, even the delivery time > 3 hours(Must be detractors). 
   Instead of delivering it at the very last, the scheduler is going to deliver this since the scheduler
   doesn't know when is the next order's going to come.
9. Drone delivers one item at a time and have to go back to warehouse to pick up the next item.
	
```

## Instruction
