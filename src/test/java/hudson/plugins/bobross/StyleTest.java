package hudson.plugins.bobross;

import hudson.model.Result;
import junit.framework.TestCase;

public class StyleTest extends TestCase {

  // Failures
	public void testGetWithFailureResultGivesBadAssStyle() {
		assertNotNull(Style.get(Result.FAILURE));
	}

  // Successes
	public void testGetWithSuccessResultGivesSuitupStyle() {
		assertNotNull(Style.get(Result.SUCCESS));
	}

  // Alerts
	public void testGetWithAbortedResultGivesAlertStyle() {
		assertNotNull(Style.get(Result.ABORTED));

	}

	public void testGetWithNotBuiltResultGivesAlertStyle() {
		assertNotNull(Style.get(Result.NOT_BUILT));
	}

	public void testGetWithUnstableResultGivesAlertStyle() {
		assertNotNull(Style.get(Result.UNSTABLE));
	}
}
