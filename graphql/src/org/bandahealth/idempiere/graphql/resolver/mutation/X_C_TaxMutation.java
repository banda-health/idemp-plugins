package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxInput;
import org.compiere.model.MTax;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxInput.Table_Name;
	}

	public MTax C_TaxSave(I_C_TaxInput entity, DataFetchingEnvironment environment) {
		return (MTax) super.save((X_C_TaxInput) entity, environment);
	}

	public List<MTax> C_TaxSaveMany(List<I_C_TaxInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_TaxInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTax) entity).collect(Collectors.toList());
	}

	public boolean C_TaxDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
