This is a base framework for UI Automation using Selenium Cucumber with Java, contains all the necessary common functions, log4j2 implementation,config properties to store project related data and browser selection for different environments and browsers at one go. All these are added under src/main package.

A simple test case to validate Maersk core values added under src/test package.

After execution, the reports would be generated under target/reports/ 
If there are any failures, the failed scenarios will be captures in "rerun/failed_scenarios.txt" file (Please look for the rerun directory for Failed scenarios execution reports in the reports directory)

Separate Cucke Runner files added for running tests and Failed scenarios.

Steps to be followed, after cloning the project:
1. Download selenium drivers for the browsers in which you want to execute the test to the directory src/main/drivers
2. Cross check the files names with the path mentioned in "src/main/java/common/utilities/WebDriverRoot.java" for each browser
3.  Run the sample test added by executing "src/test/java/cucumberRunner/RunCukesUIT.java" file - check for the successful execution of the script

Once the test is running without any issues, start adding your test under src/test directory.

For any issues or any doubts, please contact avinash.m@maersk.com or vishalmohan.gada@maersk.com