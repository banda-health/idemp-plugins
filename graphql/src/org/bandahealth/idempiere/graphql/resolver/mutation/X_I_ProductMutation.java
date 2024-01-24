package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_ProductInput;
import org.compiere.model.X_I_Product;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_ProductInput.Table_Name;
	}

	public X_I_Product I_ProductSave(I_I_ProductInput entity, DataFetchingEnvironment environment) {
		return (X_I_Product) super.save((X_I_ProductInput) entity, environment);
	}

	public List<X_I_Product> I_ProductSaveMany(List<I_I_ProductInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_ProductInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_Product) entity).collect(Collectors.toList());
	}

	public boolean I_ProductDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
