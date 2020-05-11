package hudson.plugins.bobross;

import hudson.model.Result;
import junit.framework.TestCase;

public class StyleTest extends TestCase {

  // Failures
	public void testGetWithFailureResultGivesBadAssStyle() {
		assertEquals(Style.PORTRAIT, Style.get(Result.FAILURE));
	}

  // Successes
	public void testGetWithSuccessResultGivesSuitupStyle() {
		assertEquals(Style.PAINTING, Style.get(Result.SUCCESS));
	}

  // Alerts
	public void testGetWithAbortedResultGivesAlertStyle() {
		assertEquals(Style.CHIPMUNK, Style.get(Result.ABORTED));
	}

	public void testGetWithNotBuiltResultGivesAlertStyle() {
		assertEquals(Style.CHIPMUNK, Style.get(Result.NOT_BUILT));
	}

	public void testGetWithUnstableResultGivesAlertStyle() {
		assertEquals(Style.CHIPMUNK, Style.get(Result.UNSTABLE));
	}
}
