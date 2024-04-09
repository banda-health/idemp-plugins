package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_IssueSystemInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_IssueSystemInput;
import org.compiere.model.X_R_IssueSystem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_IssueSystemMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_IssueSystemInput.Table_Name;
	}

	public X_R_IssueSystem R_IssueSystemSave(I_R_IssueSystemInput Entity, DataFetchingEnvironment environment) {
		return (X_R_IssueSystem) super.save((X_R_IssueSystemInput) Entity, environment);
	}

	public List<X_R_IssueSystem> R_IssueSystemSaveMany(List<I_R_IssueSystemInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_IssueSystemInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_R_IssueSystem) entity).collect(Collectors.toList());
	}

	public boolean R_IssueSystemDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
