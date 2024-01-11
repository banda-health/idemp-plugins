package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_YearInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_YearInput;
import org.eevolution.model.X_HR_Year;

import java.util.List;

/**
 * Generated Query Resolver for HR_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_YearMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_YearInput.Table_Name;
	}

	public X_HR_Year HR_YearSave(I_HR_YearInput input, DataFetchingEnvironment environment) {
		return (X_HR_Year) super.save((X_HR_YearInput) input, environment);
	}

	public boolean HR_YearDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
