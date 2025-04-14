package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Product_BOMLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Product_BOMLineInput;
import org.eevolution.model.MPPProductBOMLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PP_Product_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Product_BOMLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Product_BOMLineInput.Table_Name;
	}

	public MPPProductBOMLine PP_Product_BOMLineSave(I_PP_Product_BOMLineInput Entity, DataFetchingEnvironment environment) {
		return (MPPProductBOMLine) super.save((X_PP_Product_BOMLineInput) Entity, environment);
	}

	public List<MPPProductBOMLine> PP_Product_BOMLineSaveMany(List<I_PP_Product_BOMLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PP_Product_BOMLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPPProductBOMLine) entity).collect(Collectors.toList());
	}

	public boolean PP_Product_BOMLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
