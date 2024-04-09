package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_Node_ParaInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_Node_ParaInput;
import org.compiere.model.X_AD_WF_Node_Para;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_Node_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_Node_ParaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_Node_ParaInput.Table_Name;
	}

	public X_AD_WF_Node_Para AD_WF_Node_ParaSave(I_AD_WF_Node_ParaInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_Node_Para) super.save((X_AD_WF_Node_ParaInput) Entity, environment);
	}

	public List<X_AD_WF_Node_Para> AD_WF_Node_ParaSaveMany(List<I_AD_WF_Node_ParaInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_WF_Node_ParaInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_Node_Para) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_Node_ParaDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
