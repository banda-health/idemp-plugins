package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_WS_WebService_ParaInput;
import org.bandahealth.idempiere.graphql.model.input.X_WS_WebService_ParaInput;
import org.compiere.model.X_WS_WebService_Para;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for WS_WebService_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebService_ParaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_WS_WebService_ParaInput.Table_Name;
	}

	public X_WS_WebService_Para WS_WebService_ParaSave(I_WS_WebService_ParaInput entity, DataFetchingEnvironment environment) {
		return (X_WS_WebService_Para) super.save((X_WS_WebService_ParaInput) entity, environment);
	}

	public List<X_WS_WebService_Para> WS_WebService_ParaSaveMany(List<I_WS_WebService_ParaInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_WS_WebService_ParaInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_WS_WebService_Para) entity).collect(Collectors.toList());
	}

	public boolean WS_WebService_ParaDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
