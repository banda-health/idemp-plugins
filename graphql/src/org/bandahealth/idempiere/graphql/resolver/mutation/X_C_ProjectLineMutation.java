package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectLineInput;
import org.compiere.model.MProjectLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ProjectLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ProjectLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectLineInput.Table_Name;
	}

	public MProjectLine C_ProjectLineSave(I_C_ProjectLineInput Entity, DataFetchingEnvironment environment) {
		return (MProjectLine) super.save((X_C_ProjectLineInput) Entity, environment);
	}

	public List<MProjectLine> C_ProjectLineSaveMany(List<I_C_ProjectLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ProjectLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProjectLine) entity).collect(Collectors.toList());
	}

	public boolean C_ProjectLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
