package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueProjectInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueProjectInput;
import org.compiere.model.X_R_IssueProject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_IssueProject - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_IssueProjectMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueProjectInput.Table_Name;
	}

	public X_R_IssueProject R_IssueProjectSave(I_R_IssueProjectInput Entity, DataFetchingEnvironment environment) {
		return (X_R_IssueProject) super.save((X_R_IssueProjectInput) Entity, environment);
	}

	public List<X_R_IssueProject> R_IssueProjectSaveMany(List<I_R_IssueProjectInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_IssueProjectInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_R_IssueProject) entity).collect(Collectors.toList());
	}

	public boolean R_IssueProjectDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
