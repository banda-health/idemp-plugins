package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Order_Node_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Order_Node_ProductInput;
import org.eevolution.model.X_PP_Order_Node_Product;

import java.util.List;

/**
 * Generated Query Resolver for PP_Order_Node_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_Node_ProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_Node_ProductInput.Table_Name;
	}

	public X_PP_Order_Node_Product PP_Order_Node_ProductSave(I_PP_Order_Node_ProductInput input, DataFetchingEnvironment environment) {
		return (X_PP_Order_Node_Product) super.save((X_PP_Order_Node_ProductInput) input, environment);
	}

	public boolean PP_Order_Node_ProductDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
