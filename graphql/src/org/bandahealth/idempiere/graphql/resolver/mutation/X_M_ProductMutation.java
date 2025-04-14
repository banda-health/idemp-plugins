package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductInput.Table_Name;
	}

	public MProduct_BH M_ProductSave(I_M_ProductInput Entity, DataFetchingEnvironment environment) {
		return (MProduct_BH) super.save((X_M_ProductInput) Entity, environment);
	}

	public List<MProduct_BH> M_ProductSaveMany(List<I_M_ProductInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ProductInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProduct_BH) entity).collect(Collectors.toList());
	}

	public boolean M_ProductDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
