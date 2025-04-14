package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_YearInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_YearInput;
import org.compiere.model.MYear;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_YearMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_YearInput.Table_Name;
	}

	public MYear C_YearSave(I_C_YearInput Entity, DataFetchingEnvironment environment) {
		return (MYear) super.save((X_C_YearInput) Entity, environment);
	}

	public List<MYear> C_YearSaveMany(List<I_C_YearInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_YearInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MYear) entity).collect(Collectors.toList());
	}

	public boolean C_YearDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
