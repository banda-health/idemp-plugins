package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_HouseKeepingInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_HouseKeepingInput;
import org.compiere.model.MHouseKeeping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_HouseKeeping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_HouseKeepingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_HouseKeepingInput.Table_Name;
	}

	public MHouseKeeping AD_HouseKeepingSave(I_AD_HouseKeepingInput Entity, DataFetchingEnvironment environment) {
		return (MHouseKeeping) super.save((X_AD_HouseKeepingInput) Entity, environment);
	}

	public List<MHouseKeeping> AD_HouseKeepingSaveMany(List<I_AD_HouseKeepingInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_HouseKeepingInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MHouseKeeping) entity).collect(Collectors.toList());
	}

	public boolean AD_HouseKeepingDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
