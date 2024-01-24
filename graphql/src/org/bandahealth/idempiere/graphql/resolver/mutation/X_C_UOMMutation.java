package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_UOMInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_UOMInput;
import org.compiere.model.MUOM;

import java.util.List;

/**
 * Generated Query Resolver for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_UOMMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_UOMInput.Table_Name;
	}

	public MUOM C_UOMSave(I_C_UOMInput input, DataFetchingEnvironment environment) {
		return (MUOM) super.save((X_C_UOMInput) input, environment);
	}

	public boolean C_UOMDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
