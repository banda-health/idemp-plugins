package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_ProductInput;
import org.compiere.model.MAssetProduct;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_ProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_ProductInput.Table_Name;
	}

	public MAssetProduct A_Asset_ProductSave(I_A_Asset_ProductInput input, DataFetchingEnvironment environment) {
		return (MAssetProduct) super.save((X_A_Asset_ProductInput) input, environment);
	}

	public boolean A_Asset_ProductDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
