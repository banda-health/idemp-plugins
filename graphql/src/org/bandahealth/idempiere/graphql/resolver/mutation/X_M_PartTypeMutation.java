package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PartTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PartTypeInput;
import org.compiere.model.X_M_PartType;

import java.util.List;

/**
 * Generated Query Resolver for M_PartType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PartTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PartTypeInput.Table_Name;
	}

	public X_M_PartType M_PartTypeSave(I_M_PartTypeInput input, DataFetchingEnvironment environment) {
		return (X_M_PartType) super.save((X_M_PartTypeInput) input, environment);
	}

	public boolean M_PartTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
