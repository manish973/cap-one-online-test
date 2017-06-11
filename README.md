Import the project as maven project.

RestConsumer is the main class and can be runnable as it is. If you want to change the user credentials, change the final varaibles declared in the main class level.


If you want to run it from the command prompt, export the proect as an executable jar from the ide and use command 

java com.manish.sample.RestConsumer


Exaplanation of codes:

The Restconsumer class, calls a restful service from the given rest url and converts the json output into a Transaction List.
Once it has the transaction list, it calculates total spent and income for any given month.It also calculates the average spent and income by the month where the income average is any amount greater than $500 and spent average is any amount greater than %500.

It also generates a seperate output of total and averages where donuts expenses are excluded from the calculation.

Issues:
If a particular month  does not have spent amount greater than 500, it shows a Nan. It can be fixed by putting a condition but i wanted to show the raw format of the code.

Sorting of the year month is off because default sorting of strings.
