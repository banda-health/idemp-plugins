package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_ElementValueInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_ElementValueInput;
import org.compiere.model.X_I_ElementValue;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_ElementValueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_ElementValueInput.Table_Name;
	}

	public X_I_ElementValue I_ElementValueSave(I_I_ElementValueInput entity, DataFetchingEnvironment environment) {
		return (X_I_ElementValue) super.save((X_I_ElementValueInput) entity, environment);
	}

	public List<X_I_ElementValue> I_ElementValueSaveMany(List<I_I_ElementValueInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_ElementValueInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_ElementValue) entity).collect(Collectors.toList());
	}

	public boolean I_ElementValueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
