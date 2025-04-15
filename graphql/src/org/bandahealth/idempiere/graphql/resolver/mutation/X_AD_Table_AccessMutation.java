package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Table_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Table_AccessInput;
import org.compiere.model.MTableAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Table_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Table_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Table_AccessInput.Table_Name;
	}

	public MTableAccess AD_Table_AccessSave(I_AD_Table_AccessInput Entity, DataFetchingEnvironment environment) {
		return (MTableAccess) super.save((X_AD_Table_AccessInput) Entity, environment);
	}

	public List<MTableAccess> AD_Table_AccessSaveMany(List<I_AD_Table_AccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Table_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTableAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_Table_AccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
