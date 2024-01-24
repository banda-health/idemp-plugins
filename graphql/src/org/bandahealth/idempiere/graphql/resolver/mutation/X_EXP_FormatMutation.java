package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_EXP_FormatInput;
import org.bandahealth.idempiere.graphql.model.input.X_EXP_FormatInput;
import org.compiere.model.MEXPFormat;

import java.util.List;

/**
 * Generated Query Resolver for EXP_Format - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_EXP_FormatMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_EXP_FormatInput.Table_Name;
	}

	public MEXPFormat EXP_FormatSave(I_EXP_FormatInput input, DataFetchingEnvironment environment) {
		return (MEXPFormat) super.save((X_EXP_FormatInput) input, environment);
	}

	public boolean EXP_FormatDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
