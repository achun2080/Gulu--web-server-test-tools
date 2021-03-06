package Base;


import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class BaseCase {
	private static Logger logger = Logger.getLogger(BaseCase.class);
	
	protected String caseIdentifier = "";
	
	@Rule
	public TestWatcher watchman = new TestWatcher() {

		protected void starting(Description d) {
			caseIdentifier = d.getClassName() + "." + d.getMethodName();
			logger.warn("********** start test: " + caseIdentifier + " **********");
		}

		protected void succeeded(Description d) {
			caseIdentifier = d.getClassName() + " " + d.getMethodName();
			logger.warn("^^^^^^^^^^ succeeded: " + caseIdentifier + " ^^^^^^^^^^");
		}

		protected void failed(Throwable e, Description d) {
			caseIdentifier = d.getClassName() + " " + d.getMethodName();
			logger.warn("~~~~~~~~~~ failed: " + caseIdentifier + " ~~~~~~~~~~");
			logger.warn("~~~~~~~~~~ exception is : " + e + " ~~~~~~~~~~");
		}

		protected void finished(Description d) {
			caseIdentifier = d.getClassName() + " " + d.getMethodName();
			logger.warn("oooooooooo finish test: " + caseIdentifier + " oooooooooo");
		}

	};
}
