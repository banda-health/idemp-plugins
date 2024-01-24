package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxGroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxGroupInput;
import org.eevolution.model.X_C_TaxGroup;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_TaxGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxGroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxGroupInput.Table_Name;
	}

	public X_C_TaxGroup C_TaxGroupSave(I_C_TaxGroupInput entity, DataFetchingEnvironment environment) {
		return (X_C_TaxGroup) super.save((X_C_TaxGroupInput) entity, environment);
	}

	public List<X_C_TaxGroup> C_TaxGroupSaveMany(List<I_C_TaxGroupInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_TaxGroupInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_TaxGroup) entity).collect(Collectors.toList());
	}

	public boolean C_TaxGroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
