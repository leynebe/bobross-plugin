package hudson.plugins.bobross;

import static org.mockito.Matchers.same;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Build;
import hudson.model.BuildListener;
import hudson.model.Result;

import junit.framework.TestCase;
import org.mockito.ArgumentCaptor;

public class ChipmunkRecorderTest extends TestCase {

	private FactGenerator mockGenerator;
	private ChipmunkRecorder recorder;

	@Override
	public void setUp() {
		mockGenerator = mock(FactGenerator.class);
		recorder = new ChipmunkRecorder(mockGenerator);
	}

	public void testGetProjectActionWithNoLastBuildGivesNullAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		when(mockProject.getLastBuild()).thenReturn(null);
		assertNull(recorder.getProjectAction(mockProject));
	}

	public void testGetProjectActionHavingLastBuildGivesBeatBrushAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		Build mockBuild = mock(Build.class);

		when(mockProject.getLastBuild()).thenReturn(mockBuild);
		when(mockBuild.getResult()).thenReturn(Result.SUCCESS);
		when(mockGenerator.random()).thenReturn(
				"Bob Ross gently burst the dot com bubble.");

		Action action = recorder.getProjectAction(mockProject);

		assertTrue(action instanceof BeatBrushAction);
		assertEquals(Style.PAINTING, ((BeatBrushAction) action).getStyle());
		assertNotNull(((BeatBrushAction) action).getFact());
	}

	public void testPerformWithFailureResultAddsBeatBrushActionWithBadAssStyleAndExpectedFact()
			throws Exception {
		AbstractBuild mockBuild = mock(AbstractBuild.class);
		when(mockBuild.getResult()).thenReturn(Result.FAILURE);

		ArgumentCaptor<BeatBrushAction> actionCaptor = ArgumentCaptor.forClass(BeatBrushAction.class);
		doNothing().when(mockBuild).addAction(actionCaptor.capture());

		when(mockGenerator.random()).thenReturn(
				"Bob Ross gently burst the dot com bubble.");

		recorder.perform(mockBuild, mock(Launcher.class),
				mock(BuildListener.class));

		BeatBrushAction action = actionCaptor.getValue();

		verify(mockBuild, times(1)).addAction(same(action));
		assertEquals(Style.PORTRAIT, (action).getStyle());
		assertEquals("Bob Ross gently burst the dot com bubble.", action.getFact());
	}
}
