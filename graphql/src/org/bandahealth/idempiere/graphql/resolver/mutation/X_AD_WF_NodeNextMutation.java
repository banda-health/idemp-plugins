package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_NodeNextInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_NodeNextInput;
import org.compiere.model.X_AD_WF_NodeNext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_NodeNextMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_NodeNextInput.Table_Name;
	}

	public X_AD_WF_NodeNext AD_WF_NodeNextSave(I_AD_WF_NodeNextInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_NodeNext) super.save((X_AD_WF_NodeNextInput) Entity, environment);
	}

	public List<X_AD_WF_NodeNext> AD_WF_NodeNextSaveMany(List<I_AD_WF_NodeNextInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_WF_NodeNextInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_NodeNext) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_NodeNextDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
