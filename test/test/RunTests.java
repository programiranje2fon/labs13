package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class RunTests {

	public static void main(String[] args) {
		runTestsForClass(problem1.business_logic.TextDemoTest.class);	

	}

	@SuppressWarnings("rawtypes")
	private static void runTestsForClass(Class c) {

		Result r = JUnitCore.runClasses(c);

		if (r.wasSuccessful()) {

			System.out.println("TEST CLASS: " + c.getName());
			System.out.println("	Tests run: " + r.getRunCount() + "	Successful tests: "
					+ (r.getRunCount() - r.getFailureCount()) + "	Unsuccessful tests: " + r.getFailureCount());
			System.out.println();

			System.out.println("	All tests have passed.");
			System.out.println();
			System.out.flush();
		} else {
			System.out.println("TEST CLASS: " + c.getName());
			System.out.println("	Tests run: " + r.getRunCount() + "	Successful tests: "
					+ (r.getRunCount() - r.getFailureCount()) + "	Unsuccessful tests: " + r.getFailureCount());
			System.out.println();

			int i = 1;

			System.err.println("	List of UNSUCCESSFUL tests:");
			for (Failure failure : r.getFailures()) {
				if (failure.getException() instanceof NoClassDefFoundError)
					System.err.println("	" + i++ + ". Project does not contain class " + failure.getException().getMessage().substring(1) + "\n		(check class name and package name)\n");
					else
						if (failure.getException() instanceof NoSuchFieldError)
							System.err.println("	" + i++ + ". Project does not contain field " + failure.getException().getMessage() + "\n		(check field type and name)\n");
						else
							if (failure.getException() instanceof NoSuchMethodError)
								System.err.println("	" + i++ + ". Project does not contain method " + failure.getException().getMessage() + "\n		 (check method name, return type, types and order of parameters)\n");			
							else
								System.err.println("	" + i++ + ". " + failure.getTestHeader() + ": \n		" + failure.getMessage() + "\n");
			}

			System.err.println();
			System.err.flush();
		}

	}

}
