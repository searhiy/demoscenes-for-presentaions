Story: Salary calculator

Meta:
@author Serhii K.

Narrative:
    As a salary deperment manager
    I want to calculate salaries for all worker in company by their rates
    So that I can see the results in console


Scenario:  calculation salary for junior engineer

Given as a junior
Then salary should be 2400

Scenario:  calculation salary for junior engineer with bonus

Given as a junior
When project delivered earlier
Then salary should be 2600


Scenario:  calculation salary for senior engineer

Given as a senior with hour rate 2
Then salary should be 2000

Scenario:  calculation salary for senior engineer with rate 15$ per hour

Given as a senior with hour rate 15
Then salary should be 12400

