package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_ProductInput;
import org.compiere.model.MAssetProduct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_ProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_ProductInput.Table_Name;
	}

	public MAssetProduct A_Asset_ProductSave(I_A_Asset_ProductInput Entity, DataFetchingEnvironment environment) {
		return (MAssetProduct) super.save((X_A_Asset_ProductInput) Entity, environment);
	}

	public List<MAssetProduct> A_Asset_ProductSaveMany(List<I_A_Asset_ProductInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Asset_ProductInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetProduct) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_ProductDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
