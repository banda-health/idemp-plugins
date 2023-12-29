package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ElementInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ElementInput;
import org.compiere.model.MElement;

import java.util.List;

/**
 * Generated Query Resolver for C_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ElementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ElementInput.Table_Name;
	}

	public MElement C_ElementSave(I_C_ElementInput input, DataFetchingEnvironment environment) {
		return (MElement) super.save((X_C_ElementInput) input, environment);
	}

	public boolean C_ElementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
