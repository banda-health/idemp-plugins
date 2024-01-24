package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_EDIInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_EDIInput;
import org.compiere.model.X_C_BP_EDI;

import java.util.List;

/**
 * Generated Query Resolver for C_BP_EDI - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_EDIMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_EDIInput.Table_Name;
	}

	public X_C_BP_EDI C_BP_EDISave(I_C_BP_EDIInput input, DataFetchingEnvironment environment) {
		return (X_C_BP_EDI) super.save((X_C_BP_EDIInput) input, environment);
	}

	public boolean C_BP_EDIDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
