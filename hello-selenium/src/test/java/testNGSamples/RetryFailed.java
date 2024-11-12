package testNGSamples;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailed implements IRetryAnalyzer {
	int retrycount = 0;
	int retrymax = 2;
	
	@Override
	public boolean retry(ITestResult arg0) {
	
	if(retrycount< retrymax){
		retrycount++;
		return true;
	}
	return false;
	}

}
