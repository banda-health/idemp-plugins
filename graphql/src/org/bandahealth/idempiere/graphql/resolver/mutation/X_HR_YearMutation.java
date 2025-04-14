package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_YearInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_YearInput;
import org.eevolution.model.X_HR_Year;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_YearMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_YearInput.Table_Name;
	}

	public X_HR_Year HR_YearSave(I_HR_YearInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_Year) super.save((X_HR_YearInput) Entity, environment);
	}

	public List<X_HR_Year> HR_YearSaveMany(List<I_HR_YearInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_YearInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Year) entity).collect(Collectors.toList());
	}

	public boolean HR_YearDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
