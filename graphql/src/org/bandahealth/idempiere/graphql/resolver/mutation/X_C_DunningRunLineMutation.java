package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DunningRunLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DunningRunLineInput;
import org.compiere.model.MDunningRunLine;

import java.util.List;

/**
 * Generated Query Resolver for C_DunningRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningRunLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DunningRunLineInput.Table_Name;
	}

	public MDunningRunLine C_DunningRunLineSave(I_C_DunningRunLineInput input, DataFetchingEnvironment environment) {
		return (MDunningRunLine) super.save((X_C_DunningRunLineInput) input, environment);
	}

	public boolean C_DunningRunLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
