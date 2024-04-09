package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_BOMLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_BOMLineInput;
import org.eevolution.model.X_T_BOMLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_BOMLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_BOMLineInput.Table_Name;
	}

	public X_T_BOMLine T_BOMLineSave(I_T_BOMLineInput Entity, DataFetchingEnvironment environment) {
		return (X_T_BOMLine) super.save((X_T_BOMLineInput) Entity, environment);
	}

	public List<X_T_BOMLine> T_BOMLineSaveMany(List<I_T_BOMLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_T_BOMLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_BOMLine) entity).collect(Collectors.toList());
	}

	public boolean T_BOMLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
