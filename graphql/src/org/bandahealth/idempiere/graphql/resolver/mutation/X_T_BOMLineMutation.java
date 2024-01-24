package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_BOMLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_BOMLineInput;
import org.eevolution.model.X_T_BOMLine;

import java.util.List;

/**
 * Generated Query Resolver for T_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_BOMLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_BOMLineInput.Table_Name;
	}

	public X_T_BOMLine T_BOMLineSave(I_T_BOMLineInput input, DataFetchingEnvironment environment) {
		return (X_T_BOMLine) super.save((X_T_BOMLineInput) input, environment);
	}

	public boolean T_BOMLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
