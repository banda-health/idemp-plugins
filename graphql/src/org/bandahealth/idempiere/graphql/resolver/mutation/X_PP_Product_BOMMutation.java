package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Product_BOMInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Product_BOMInput;
import org.eevolution.model.MPPProductBOM;

import java.util.List;
import java.util.stream.Collectors;

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

	public MPPProductBOM PP_Product_BOMSave(I_PP_Product_BOMInput entity, DataFetchingEnvironment environment) {
		return (MPPProductBOM) super.save((X_PP_Product_BOMInput) entity, environment);
	}

	public List<MPPProductBOM> PP_Product_BOMSaveMany(List<I_PP_Product_BOMInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PP_Product_BOMInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPPProductBOM) entity).collect(Collectors.toList());
	}

	public boolean PP_Product_BOMDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
