package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueSystemInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueSystemInput;
import org.compiere.model.MIssueSystem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_IssueSystemMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueSystemInput.Table_Name;
	}

	public MIssueSystem R_IssueSystemSave(I_R_IssueSystemInput entity, DataFetchingEnvironment environment) {
		return (MIssueSystem) super.save((X_R_IssueSystemInput) entity, environment);
	}

	public List<MIssueSystem> R_IssueSystemSaveMany(List<I_R_IssueSystemInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_R_IssueSystemInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MIssueSystem) entity).collect(Collectors.toList());
	}

	public boolean R_IssueSystemDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
