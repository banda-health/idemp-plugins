package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectIssueMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectIssueMAInput;
import org.compiere.model.X_C_ProjectIssueMA;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ProjectIssueMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ProjectIssueMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectIssueMAInput.Table_Name;
	}

	public X_C_ProjectIssueMA C_ProjectIssueMASave(I_C_ProjectIssueMAInput Entity, DataFetchingEnvironment environment) {
		return (X_C_ProjectIssueMA) super.save((X_C_ProjectIssueMAInput) Entity, environment);
	}

	public List<X_C_ProjectIssueMA> C_ProjectIssueMASaveMany(List<I_C_ProjectIssueMAInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ProjectIssueMAInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_ProjectIssueMA) entity).collect(Collectors.toList());
	}

	public boolean C_ProjectIssueMADelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
