package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.X_BH_Stocktake_v;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Stocktake_vInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Stocktake_vInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_Stocktake_v - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Stocktake_vMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Stocktake_vInput.Table_Name;
	}

	public X_BH_Stocktake_v BH_Stocktake_vSave(I_BH_Stocktake_vInput input, DataFetchingEnvironment environment) {
		return (X_BH_Stocktake_v) super.save((X_BH_Stocktake_vInput) input, environment);
	}

	public boolean BH_Stocktake_vDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
