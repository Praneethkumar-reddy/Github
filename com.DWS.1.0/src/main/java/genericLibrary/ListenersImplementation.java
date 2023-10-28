package genericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener{
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed");
	}
	
	public void onStart(ITestContext context) {
		System.out.println("started");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("ended");
	}
}