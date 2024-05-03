package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RegionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RegionInput;
import org.compiere.model.MRegion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Region - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RegionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RegionInput.Table_Name;
	}

	public MRegion C_RegionSave(I_C_RegionInput Entity, DataFetchingEnvironment environment) {
		return (MRegion) super.save((X_C_RegionInput) Entity, environment);
	}

	public List<MRegion> C_RegionSaveMany(List<I_C_RegionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_RegionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRegion) entity).collect(Collectors.toList());
	}

	public boolean C_RegionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
