package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ListLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ListLineInput;
import org.eevolution.model.X_HR_ListLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_ListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ListLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListLineInput.Table_Name;
	}

	public X_HR_ListLine HR_ListLineSave(I_HR_ListLineInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_ListLine) super.save((X_HR_ListLineInput) Entity, environment);
	}

	public List<X_HR_ListLine> HR_ListLineSaveMany(List<I_HR_ListLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_ListLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_ListLine) entity).collect(Collectors.toList());
	}

	public boolean HR_ListLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
