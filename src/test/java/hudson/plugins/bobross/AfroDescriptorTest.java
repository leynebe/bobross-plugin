package hudson.plugins.bobross;

import static org.mockito.Mockito.mock;
import hudson.model.AbstractProject;
import junit.framework.TestCase;

public class AfroDescriptorTest extends TestCase {

	private AfroDescriptor descriptor;

	public void setUp() {
		descriptor = new AfroDescriptor();
	}

	public void testGetDisplayName() {
		assertEquals("Imagining happy little trees", descriptor.getDisplayName());
	}

	public void testIsApplicableGivesTrue() {
		assertTrue(descriptor.isApplicable(mock(AbstractProject.class)
				.getClass()));
	}
}
