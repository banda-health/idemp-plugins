package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_BOMProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_BOMProductInput;
import org.compiere.model.MBOMProduct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_BOMProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_BOMProductInput.Table_Name;
	}

	public MBOMProduct M_BOMProductSave(I_M_BOMProductInput Entity, DataFetchingEnvironment environment) {
		return (MBOMProduct) super.save((X_M_BOMProductInput) Entity, environment);
	}

	public List<MBOMProduct> M_BOMProductSaveMany(List<I_M_BOMProductInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_BOMProductInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBOMProduct) entity).collect(Collectors.toList());
	}

	public boolean M_BOMProductDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
