package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_Process_ParaInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_Process_ParaInput;
import org.compiere.model.X_ASP_Process_Para;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_Process_ParaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Process_ParaInput.Table_Name;
	}

	public X_ASP_Process_Para ASP_Process_ParaSave(I_ASP_Process_ParaInput entity, DataFetchingEnvironment environment) {
		return (X_ASP_Process_Para) super.save((X_ASP_Process_ParaInput) entity, environment);
	}

	public List<X_ASP_Process_Para> ASP_Process_ParaSaveMany(List<I_ASP_Process_ParaInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_ASP_Process_ParaInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Process_Para) entity).collect(Collectors.toList());
	}

	public boolean ASP_Process_ParaDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
