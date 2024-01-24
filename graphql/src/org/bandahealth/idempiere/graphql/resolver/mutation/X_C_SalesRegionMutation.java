package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_SalesRegionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_SalesRegionInput;
import org.compiere.model.MSalesRegion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_SalesRegion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_SalesRegionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_SalesRegionInput.Table_Name;
	}

	public MSalesRegion C_SalesRegionSave(I_C_SalesRegionInput entity, DataFetchingEnvironment environment) {
		return (MSalesRegion) super.save((X_C_SalesRegionInput) entity, environment);
	}

	public List<MSalesRegion> C_SalesRegionSaveMany(List<I_C_SalesRegionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_SalesRegionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSalesRegion) entity).collect(Collectors.toList());
	}

	public boolean C_SalesRegionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
