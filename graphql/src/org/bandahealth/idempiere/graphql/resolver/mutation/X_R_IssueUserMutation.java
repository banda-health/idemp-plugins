package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueUserInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueUserInput;
import org.compiere.model.MIssueUser;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_IssueUser - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_IssueUserMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueUserInput.Table_Name;
	}

	public MIssueUser R_IssueUserSave(I_R_IssueUserInput Entity, DataFetchingEnvironment environment) {
		return (MIssueUser) super.save((X_R_IssueUserInput) Entity, environment);
	}

	public List<MIssueUser> R_IssueUserSaveMany(List<I_R_IssueUserInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_IssueUserInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MIssueUser) entity).collect(Collectors.toList());
	}

	public boolean R_IssueUserDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
