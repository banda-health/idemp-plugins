package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_BOMProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_BOMProductInput;
import org.compiere.model.MBOMProduct;

import java.util.List;

/**
 * Generated Query Resolver for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_BOMProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_BOMProductInput.Table_Name;
	}

	public MBOMProduct M_BOMProductSave(I_M_BOMProductInput input, DataFetchingEnvironment environment) {
		return (MBOMProduct) super.save((X_M_BOMProductInput) input, environment);
	}

	public boolean M_BOMProductDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
