package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Product_BOMInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Product_BOMInput;
import org.eevolution.model.MPPProductBOM;

import java.util.List;

/**
 * Generated Query Resolver for PP_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Product_BOMMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Product_BOMInput.Table_Name;
	}

	public MPPProductBOM PP_Product_BOMSave(I_PP_Product_BOMInput input, DataFetchingEnvironment environment) {
		return (MPPProductBOM) super.save((X_PP_Product_BOMInput) input, environment);
	}

	public boolean PP_Product_BOMDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
