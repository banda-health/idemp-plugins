package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ServiceLevelLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ServiceLevelLineInput;
import org.compiere.model.X_C_ServiceLevelLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ServiceLevelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ServiceLevelLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ServiceLevelLineInput.Table_Name;
	}

	public X_C_ServiceLevelLine C_ServiceLevelLineSave(I_C_ServiceLevelLineInput Entity, DataFetchingEnvironment environment) {
		return (X_C_ServiceLevelLine) super.save((X_C_ServiceLevelLineInput) Entity, environment);
	}

	public List<X_C_ServiceLevelLine> C_ServiceLevelLineSaveMany(List<I_C_ServiceLevelLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ServiceLevelLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_ServiceLevelLine) entity).collect(Collectors.toList());
	}

	public boolean C_ServiceLevelLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
