package hudson.plugins.bobross.pipeline;

import javax.annotation.Nonnull;

import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl;
import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;

public class BobRossStep extends AbstractStepImpl {

	@DataBoundConstructor
	public BobRossStep() {
	}

	@Extension
	public static class DescriptorImpl extends AbstractStepDescriptorImpl {
		public DescriptorImpl() {
			super(BobRossStepExecution.class);
		}

		@Override
		public String getFunctionName() {
			return "bobRoss";
		}

		@Nonnull
		@Override
		public String getDisplayName() {
			return "Improve your developer's mindset using Bob Ross' infinite wisdom.";
		}
	}
}