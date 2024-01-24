package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_NonBusinessDayInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_NonBusinessDayInput;
import org.compiere.model.X_C_NonBusinessDay;

import java.util.List;

/**
 * Generated Query Resolver for C_NonBusinessDay - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_NonBusinessDayMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_NonBusinessDayInput.Table_Name;
	}

	public X_C_NonBusinessDay C_NonBusinessDaySave(I_C_NonBusinessDayInput input, DataFetchingEnvironment environment) {
		return (X_C_NonBusinessDay) super.save((X_C_NonBusinessDayInput) input, environment);
	}

	public boolean C_NonBusinessDayDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
