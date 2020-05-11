package hudson.plugins.bobross.pipeline;

import org.jenkinsci.plugins.workflow.steps.AbstractSynchronousNonBlockingStepExecution;
import org.jenkinsci.plugins.workflow.steps.StepContextParameter;

import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.plugins.bobross.ChipmunkRecorder;

public class BobRossStepExecution extends AbstractSynchronousNonBlockingStepExecution<Void> {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@StepContextParameter
	private transient TaskListener listener;

    @StepContextParameter
    private transient Run<?, ?> run;

	@Override
	protected Void run() throws Exception {
		listener.getLogger().println("Signing this work of art...");
		
		ChipmunkRecorder recorder = new ChipmunkRecorder();
		recorder.perform(run);
		
		return null;
	}

}
