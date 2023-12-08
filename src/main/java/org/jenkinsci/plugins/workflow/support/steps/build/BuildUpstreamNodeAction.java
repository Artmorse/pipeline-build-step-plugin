package org.jenkinsci.plugins.workflow.support.steps.build;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import hudson.model.InvisibleAction;
import hudson.model.Run;
import org.jenkinsci.plugins.workflow.graph.FlowNode;

import java.util.Objects;

/**
 * Attached to newly-created builds in order to point back to the triggering FlowNode.
 *
 * @see DownstreamBuildAction
 */
public class BuildUpstreamNodeAction extends InvisibleAction {

    private final String upstreamNodeId;
    private final String upstreamRunId;

    public BuildUpstreamNodeAction(FlowNode node, Run<?, ?> invokingRun) {
        this.upstreamNodeId = node.getId();
        this.upstreamRunId = invokingRun.getExternalizableId();
    }

    public String getUpstreamNodeId() {
        return upstreamNodeId;
    }

    public String getUpstreamRunId() {
        return upstreamRunId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BuildUpstreamNodeAction that = (BuildUpstreamNodeAction) o;
        return Objects.equals(upstreamNodeId, that.upstreamNodeId) &&
                Objects.equals(upstreamRunId, that.upstreamRunId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upstreamNodeId, upstreamRunId);
    }
}
