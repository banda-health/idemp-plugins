package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_AdditionInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_AdditionInput;
import org.compiere.model.MAssetAddition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Addition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_AdditionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_AdditionInput.Table_Name;
	}

	public MAssetAddition A_Asset_AdditionSave(I_A_Asset_AdditionInput entity, DataFetchingEnvironment environment) {
		return (MAssetAddition) super.save((X_A_Asset_AdditionInput) entity, environment);
	}

	public List<MAssetAddition> A_Asset_AdditionSaveMany(List<I_A_Asset_AdditionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Asset_AdditionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetAddition) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_AdditionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
