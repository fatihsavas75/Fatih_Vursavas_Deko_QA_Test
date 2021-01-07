Fatih Vursavas QA-TEST-DEKO

Test steps were taken as following:

1. Dependencies were installed into the pom.xml file
2. URL was added to Base Url = "https://release.dekopay.org/backoffice/v2/#/" in the BackofficeRobot class
3. username and password were created as a string.
4.navigateLoginPage method was created in the BackofficeTest class and
object of the robot was created in the same method to be able to use
 fillLoginUsername, fillLoginPassword, submitLoginForm methods.
5-verifyLogin method was created to be able to verify succesfully login.
6- WebElementContains method in BaseRobot was called in verifySuccessfulLogin method in 
the BackofficeRobot class and then login was verified with username.
7. Git was added, committed and pushed to the personal repository. 


  


