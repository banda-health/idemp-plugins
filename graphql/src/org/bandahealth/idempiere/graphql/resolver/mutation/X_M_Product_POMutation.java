package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductPO_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_Product_POInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_Product_POInput;

import java.util.List;
import java.util.stream.Collectors;

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

	public MProductPO_BH M_Product_POSave(I_M_Product_POInput entity, DataFetchingEnvironment environment) {
		return (MProductPO_BH) super.save((X_M_Product_POInput) entity, environment);
	}

	public List<MProductPO_BH> M_Product_POSaveMany(List<I_M_Product_POInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_Product_POInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProductPO_BH) entity).collect(Collectors.toList());
	}

	public boolean M_Product_PODelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
