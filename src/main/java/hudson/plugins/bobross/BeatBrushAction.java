/**
 * Copyright (c) 2009 Cliffano Subagio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.bobross;

import java.util.Collection;
import java.util.Collections;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import hudson.model.Action;
import hudson.model.Run;
import jenkins.model.RunAction2;
import jenkins.tasks.SimpleBuildStep.LastBuildAction;

/**
 * {@link BeatBrushAction} keeps the style and fact associated with the action.
 * For more info, please watch <a
 * href="https://www.youtube.com/watch?v=KM971KEFVco"
 * >this youtube video</a>
 * @author cliffano
 */
public final class BeatBrushAction implements RunAction2, LastBuildAction {

    /**
     * The style - for backward compatibility to version 0.2.
     */
    private String style;

    /**
     * The style.
     */
    private String mStyle;

    /**
     * The fact - for backward compatibility to version 0.2.
     */
    private String fact;

    /**
     * The fact.
     */
    private String mFact;

    /**
     * The run
     */
    private transient Run<?, ?> mRun;

    /**
     * Constructs a BeatBrushAction with specified style and fact.
     * @param style
     *            the style
     * @param fact
     *            the fact
     */
    public BeatBrushAction(final String style, final String fact) {
        super();
        this.mStyle = style;
        this.mFact = fact;
    }

    /**
     * Gets the action display name.
     * @return the display name
     */
    public String getDisplayName() {
        return "Bob Ross";
    }

    /**
     * This action doesn't provide any icon file.
     * @return null
     */
    public String getIconFileName() {
        return null;
    }

    /**
     * Gets the URL name for this action.
     * @return the URL name
     */
    public String getUrlName() {
        return "bobross";
    }

    /**
     * Gets the Bob Ross style.
     * @return the style
     */
    // TODO : check infra statistics to see if someone still has bobross in 0.2...
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "that field could have been deserialized from old <= 0.2")
    public String getStyle() {
        String theStyle;
        if (mRun != null) {
        	theStyle = Style.get(mRun.getResult());
        } else if (mStyle != null) {
            theStyle = mStyle;
        } else {
            theStyle = style;
        }
        return theStyle;
    }

    /**
     * Gets the Bob Ross fact.
     * @return the fact
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "that field could have been deserialized from old <= 0.2")
    public String getFact() {
        String theFact;
        if (mFact != null) {
            theFact = mFact;
        } else {
            theFact = fact;
        }
        return theFact;
    }

    /**
     * Returns this action as a collection of all project actions.
     *
     * Default jenkins behavior is to get the action on the last successful build (Stable or Unstable)
     * while we want the last completed build (Stable, Unstable or Failure).
     *
     * @return the project actions
     */
    @Override
    public Collection<? extends Action> getProjectActions() {
    	if (mRun != null) {
    		return mRun.getParent().getLastCompletedBuild().getActions(BeatBrushAction.class);
    	} else {
    		return Collections.singletonList(this);
    	}
    }

	@Override
	public void onAttached(Run<?, ?> r) {
		this.mRun = r;
	}

	@Override
	public void onLoad(Run<?, ?> r) {
		this.mRun = r;
	}

}
