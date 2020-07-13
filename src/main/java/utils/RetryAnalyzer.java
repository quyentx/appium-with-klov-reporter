package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int counter = 0;
    int max = 1;
    /*
     * (non-Javadoc)
     * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
     *
     * This method decides how many times a test needs to be rerun.
     * TestNg will call this method every time a test fails. So we
     * can put some code in here to decide when to rerun the test.
     *
     * Note: This method will return true if a tests needs to be retried
     * and false it not.
     *
     */

    @Override
    public boolean retry(ITestResult testResult) {
        if (!testResult.isSuccess()) {                      //Check if test not succeed
            if (counter < max) {                            //Check if maxtry count is reached
                counter++;                                     //Increase the maxTry count by 1
                testResult.setStatus(ITestResult.SKIP);  //Mark test as failed
                return true;                                 //Tells TestNG to re-run the test
            } else {
                testResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
            testResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
}