package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_NodeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_NodeInput;
import org.compiere.model.X_AD_WF_Node;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_NodeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_NodeInput.Table_Name;
	}

	public X_AD_WF_Node AD_WF_NodeSave(I_AD_WF_NodeInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_Node) super.save((X_AD_WF_NodeInput) Entity, environment);
	}

	public List<X_AD_WF_Node> AD_WF_NodeSaveMany(List<I_AD_WF_NodeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_WF_NodeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_Node) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_NodeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
