package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_DocTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DocTypeInput;

import java.util.List;

/**
 * Generated Query Resolver for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DocTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DocTypeInput.Table_Name;
	}

	public MDocType_BH C_DocTypeSave(I_C_DocTypeInput input, DataFetchingEnvironment environment) {
		return (MDocType_BH) super.save((X_C_DocTypeInput) input, environment);
	}

	public boolean C_DocTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
