package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_YearInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_YearInput;
import org.compiere.model.MYear;

import java.util.List;

/**
 * Generated Query Resolver for C_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_YearMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_YearInput.Table_Name;
	}

	public MYear C_YearSave(I_C_YearInput input, DataFetchingEnvironment environment) {
		return (MYear) super.save((X_C_YearInput) input, environment);
	}

	public boolean C_YearDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
