package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_Product_BOMInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_Product_BOMInput;
import org.compiere.model.MProductBOM;

import java.util.List;

/**
 * Generated Query Resolver for M_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_BOMMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_Product_BOMInput.Table_Name;
	}

	public MProductBOM M_Product_BOMSave(I_M_Product_BOMInput input, DataFetchingEnvironment environment) {
		return (MProductBOM) super.save((X_M_Product_BOMInput) input, environment);
	}

	public boolean M_Product_BOMDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
