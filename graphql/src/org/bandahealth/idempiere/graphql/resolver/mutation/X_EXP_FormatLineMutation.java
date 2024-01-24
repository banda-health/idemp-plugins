package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_EXP_FormatLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_EXP_FormatLineInput;
import org.compiere.model.MEXPFormatLine;

import java.util.List;

/**
 * Generated Query Resolver for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_FormatLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_EXP_FormatLineInput.Table_Name;
	}

	public MEXPFormatLine EXP_FormatLineSave(I_EXP_FormatLineInput input, DataFetchingEnvironment environment) {
		return (MEXPFormatLine) super.save((X_EXP_FormatLineInput) input, environment);
	}

	public boolean EXP_FormatLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
