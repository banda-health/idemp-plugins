package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_IssueInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_IssueInput;
import org.compiere.model.MIssue;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Issue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_IssueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_IssueInput.Table_Name;
	}

	public MIssue AD_IssueSave(I_AD_IssueInput entity, DataFetchingEnvironment environment) {
		return (MIssue) super.save((X_AD_IssueInput) entity, environment);
	}

	public List<MIssue> AD_IssueSaveMany(List<I_AD_IssueInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_IssueInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MIssue) entity).collect(Collectors.toList());
	}

	public boolean AD_IssueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
