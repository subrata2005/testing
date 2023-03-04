This test automation framework built with Selenium intends to automate a test web application: http://jupiter.cloud.planittesting.com. I have used Java for this implementation.

This example addresses the ability to structure code correctly, identify the elements of a page, design the tests for scalability, and prepare the solution to be executed within a continuous pipeline (i.e. Jenkins or other)   

I have not implemented a BDD/Gherkin solution, as this implementation intends to experience with framework implementation below the BDD layer.

Application URL: http://jupiter.cloud.planittesting.com

Test cases

Test case 1:
1.	From the home page go to contact page
2.	Click submit button
3.	Validate errors
4.	Populate mandatory fields
5.	Validate errors are gone


Test case 2:

1.	From the home page go to contact page
2.	Populate mandatory fields
3.	Click submit button
4.	Validate successful submission message


Test case 3:

1.	From the home page go to shop page
2.	Click buy button 2 times on “Funny Cow”
3.	Click buy button 1 time on “Fluffy Bunny”
4.	Click the cart menu
5.	Verify the items are in the cart


Test case 4: Advanced


1.	Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
2.	Go to the cart page
3.	Verify the price for each product
4.	Verify that each product’s sub total = product price * quantity
5.	Verify that total = sum(sub totals)



Framework highlights:

The framework that I have presented here is clean, easily maintainable, scalable & promotes reusability.
•	Object repository is independent of test cases. If there’s any change in object identifier, there’s no need to alter anything in the testcase classes. Maintenance effort comes down significantly.
•	Code is less and optimized because of the reusable page methods in the page object model classes.
•	Tests data is not hardcoded & furnished from a separate xml. If the test data expires for some reason, there isn’t any need to change the object or testcase classes. We can easily configure the tests to run in a different test environment.
•	TestNG makes the tests more structured, readable, maintainable, and user-friendly. It provides powerful features and reporting. Provides easy integration with Build servers. Using ANT in selenium & TestNG framework, we can run the tests from a build script. 
•	The advantages TestNG include it can run tests in parallel, supports advance annotations like BeforeTest/AfterTest & grouping of tests are allowed.

