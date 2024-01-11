package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_Product_POInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_Product_POInput;
import org.compiere.model.MProductPO;

import java.util.List;

/**
 * Generated Query Resolver for M_Product_PO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_POMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_Product_POInput.Table_Name;
	}

	public MProductPO M_Product_POSave(I_M_Product_POInput input, DataFetchingEnvironment environment) {
		return (MProductPO) super.save((X_M_Product_POInput) input, environment);
	}

	public boolean M_Product_PODelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
