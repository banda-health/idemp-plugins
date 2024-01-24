package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHProductCategoryDefault;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Product_CategoryDefaultInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Product_CategoryDefaultInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Product_CategoryDefault - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Product_CategoryDefaultMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Product_CategoryDefaultInput.Table_Name;
	}

	public MBHProductCategoryDefault BH_Product_CategoryDefaultSave(I_BH_Product_CategoryDefaultInput entity, DataFetchingEnvironment environment) {
		return (MBHProductCategoryDefault) super.save((X_BH_Product_CategoryDefaultInput) entity, environment);
	}

	public List<MBHProductCategoryDefault> BH_Product_CategoryDefaultSaveMany(List<I_BH_Product_CategoryDefaultInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_Product_CategoryDefaultInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHProductCategoryDefault) entity).collect(Collectors.toList());
	}

	public boolean BH_Product_CategoryDefaultDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
