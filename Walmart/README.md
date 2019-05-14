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
	1. OrderDirection format strictly follows: N5S10. Make sure input is valid.
	2. OrderTime always within a day, since there is no date information.
	3. Orders come as a data stream, you never know when and what is the next order.
	4. OrderDistance is always within the range of the Drone.
	5. OrderID format strictly follows: WMXXXX (4 digits)
	6. When only one order comes, deliver it regardless its distance, since you never know when is the next order.
	7. NPS Calculation:
		 0 <= Waiting Time <= 1 hour : Promoters
		 1 < Waiting Time <= 3 hours : Neutral
		 3 < Waiting Time            : Detractors
	8. Time is always valid and are in the same day.
	9. When meeting the situation: only one order comes, the delivery time > 3 hours(Must be detractors). 
	   Instead of deliver it at the very last, the scheduler is going to deliver this since the scheduler
	   doesn't know when is the next order's going to come.
```

## Instruction
