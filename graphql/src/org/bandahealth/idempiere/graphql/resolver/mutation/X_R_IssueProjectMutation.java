package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueProjectInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueProjectInput;
import org.compiere.model.MIssueProject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_IssueProject - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_IssueProjectMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueProjectInput.Table_Name;
	}

	public MIssueProject R_IssueProjectSave(I_R_IssueProjectInput Entity, DataFetchingEnvironment environment) {
		return (MIssueProject) super.save((X_R_IssueProjectInput) Entity, environment);
	}

	public List<MIssueProject> R_IssueProjectSaveMany(List<I_R_IssueProjectInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_IssueProjectInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MIssueProject) entity).collect(Collectors.toList());
	}

	public boolean R_IssueProjectDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
