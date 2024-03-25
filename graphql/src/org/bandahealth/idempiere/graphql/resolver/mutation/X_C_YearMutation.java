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
 * @version Release 11 - $Id$
 */
public class X_C_YearMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_YearInput.Table_Name;
	}

	public MYear C_YearSave(I_C_YearInput entity, DataFetchingEnvironment environment) {
		return (MYear) super.save((X_C_YearInput) entity, environment);
	}

	public List<MYear> C_YearSaveMany(List<I_C_YearInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_YearInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MYear) entity).collect(Collectors.toList());
	}

	public boolean C_YearDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
