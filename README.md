# Portfolio-of-Investment-in-GUI-2021-
MANJOT SINGH

LIMITATIONS : The limits of my code are that the code isn't the most effective.
 It tends to be adjusted and rearranged to ensure the code is running as productively as could be expected.

- The user does not input incompatible variable types, for example a string where a double is required.


HOW TO COMPILE/RUN(execute) :

1. First of all you need to make sure that you are in msingh48_a3
2. To compile the program run the command : javac ePortfolio/*.java
   This command will create .class files for all the .java files inside the package
3. To execute the package run command : java ePortfolio.gui
   here gui is name of my main class files

TESTING :

1. User can select any task he wants to perform from the command Menu

2. If the user click on Buy The buy panel will open then he can choose the type of investment and write all the information that is mentioned
   If there is some ERROR or you forgot to mentioned all the details asked An ERROR will display in the messgae box below.    

3. Buy one more investment for each list to make sure that arraylist is functioning properly(both stock and mutualfund arraylist)
   If quantity will add when you buy the same investment.

4. If You buy an investment with same symbol but different type of investment it will not allow you to buy that investment because it already
   exist in the other type of investment.


5. Try to completely sell all shares  of an investment by opening sell and check if the investment is removed from the Arraylist.

6. Sell a portion of an investment and check if the payment received being displayed on the screen is correct or NOT.

7. Use Update to change investment prices and check if the values are changed for each one of them . Make sure to check the bookvalue.

8. When you are in Update panel try Next and Prev And Check that the Symbol and Name fields are non editable.

9. Test getGain to get the get overall gain value at the Top and all the individual gain in the message box will be displayed.
	
10. Test the search method using several variations such as:
    - Just write the symbol
    - just write the name/Keyword
    - just write the lower price(then high price will be the max by default)
    - just write the higher price(the lower price will be minimum price by default)
    If none of the information is provided then all the existing Investments in Array List will be printed 

NOTE:

-Try all the possible ways to check the run function(mentioned above) and Warns the user when a space is found in the symbol input 
 or if the price is given in the wrong format.
-Check in all the Gui pages that the message box have scroll bar.
-Check if Reset button resets everything in that paticular page. 
                                              
EDGE CASES:
	-Enter negative values for the price and quantity with the buy/sell function
	-Use SEARCH to search for the first, middle, and last investments for both lists using the variations states at #8 (this should generally mean that your search method is working well)
	-try all the combinations for price ranges for the search function, such as x-y, x, x-, and -x where x and y  can be any real number

IMPROVEMENTS:

I could have made by gui look more better with the fonts and by adding more detailed ERROR when the user make any mistake. Moreover, my gui is not resisable to whenever the user tries to resize it it will not able to be resized because i have set my resizabiity to false, the reason is that all my gui pages look diffesrent and does not look as i wanted them to look. If i had more time I would have made sure that my gui was resizable and had more color contrast to make it look good. 

