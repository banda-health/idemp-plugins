package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Order_BOMInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Order_BOMInput;
import org.eevolution.model.X_PP_Order_BOM;

import java.util.List;

/**
 * Generated Query Resolver for PP_Order_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_BOMMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_BOMInput.Table_Name;
	}

	public X_PP_Order_BOM PP_Order_BOMSave(I_PP_Order_BOMInput input, DataFetchingEnvironment environment) {
		return (X_PP_Order_BOM) super.save((X_PP_Order_BOMInput) input, environment);
	}

	public boolean PP_Order_BOMDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
