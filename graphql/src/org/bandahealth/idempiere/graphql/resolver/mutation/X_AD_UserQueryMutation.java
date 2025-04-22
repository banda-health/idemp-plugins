package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserQueryInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserQueryInput;
import org.compiere.model.MUserQuery;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_UserQuery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_UserQueryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserQueryInput.Table_Name;
	}

	public MUserQuery AD_UserQuerySave(I_AD_UserQueryInput Entity, DataFetchingEnvironment environment) {
		return (MUserQuery) super.save((X_AD_UserQueryInput) Entity, environment);
	}

	public List<MUserQuery> AD_UserQuerySaveMany(List<I_AD_UserQueryInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_UserQueryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserQuery) entity).collect(Collectors.toList());
	}

	public boolean AD_UserQueryDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
