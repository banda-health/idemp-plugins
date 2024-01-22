package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ElementValueInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ElementValueInput;
import org.compiere.model.MElementValue;

import java.util.List;

/**
 * Generated Query Resolver for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ElementValueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ElementValueInput.Table_Name;
	}

	public MElementValue C_ElementValueSave(I_C_ElementValueInput input, DataFetchingEnvironment environment) {
		return (MElementValue) super.save((X_C_ElementValueInput) input, environment);
	}

	public boolean C_ElementValueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
