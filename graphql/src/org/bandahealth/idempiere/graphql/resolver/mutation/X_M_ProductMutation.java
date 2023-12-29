package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductInput;

import java.util.List;

/**
 * Generated Query Resolver for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductInput.Table_Name;
	}

	public MProduct_BH M_ProductSave(I_M_ProductInput input, DataFetchingEnvironment environment) {
		return (MProduct_BH) super.save((X_M_ProductInput) input, environment);
	}

	public boolean M_ProductDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
