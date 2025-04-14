package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_Product_CategoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_Product_CategoryInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_Product_CategoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_Product_CategoryInput.Table_Name;
	}

	public MProductCategory_BH M_Product_CategorySave(I_M_Product_CategoryInput Entity, DataFetchingEnvironment environment) {
		return (MProductCategory_BH) super.save((X_M_Product_CategoryInput) Entity, environment);
	}

	public List<MProductCategory_BH> M_Product_CategorySaveMany(List<I_M_Product_CategoryInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_Product_CategoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProductCategory_BH) entity).collect(Collectors.toList());
	}

	public boolean M_Product_CategoryDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
