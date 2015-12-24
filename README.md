# Potfolio-Benchmark-Problem
Programming Challenge Description:
The Problem
Instead of counting how many holdings are in your portfolio, build a string in the following format for each holding

[ticker, name, quantity]
For example, if my portfolio was:

Ticker    Name          Quantity
VOD       Vodafone      10
GOOG      Google        15
MSFT      Microsoft     12
The output for this portfolio would be :

[GOOG, Google, 15], [MSFT, Microsoft, 12], [VOD, Vodafone, 10]
Ensure you order alphabetically by ticker and note the comma and space between each holding.

Recommendation - create an object to model a portfolio holding. It will be used in all future questions.

Remember to copy your code to a text editor for use in the following question.


Input:
Read your portfolio from standard input.

The Portfolio will be represented in the following format: ticker, name, quantity and each holding is separated by the '@' symbol.

For example:

VOD,Vodafone,10@GOOG,Google,15@MSFT,Microsoft,12

Output:
Print your result to standard output

It should be a string in the following format for each holding with each holding separated by a comma and a space.

 [ticker, name, quantity], [ticker, name, quantity]
Order the holdings alphabetically ascending by ticker


Test 1
Test Input Download Test Input
VOD,Vodafone,10@GOOG,Google,15@MSFT,Microsoft,12
Expected Output Download Test Output
[GOOG, Google, 15], [MSFT, Microsoft, 12], [VOD, Vodafone, 10]
Test 2
Test Input Download Test Input
BLK,BlackRock,65@JPM,JPMorgan,78@BK,Bank of New York Mellon,13@WFC,Wells Fargo & Co,25
Expected Output Download Test Output
[BK, Bank of New York Mellon, 13], [BLK, BlackRock, 65], [JPM, JPMorgan, 78], [WFC, Wells Fargo & Co, 25]
