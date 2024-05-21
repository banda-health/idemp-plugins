package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeBPInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeBPInput;
import org.compiere.model.MTree_NodeBP;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_TreeNodeBP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeBPMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeBPInput.Table_Name;
	}

	public MTree_NodeBP AD_TreeNodeBPSave(I_AD_TreeNodeBPInput Entity, DataFetchingEnvironment environment) {
		return (MTree_NodeBP) super.save((X_AD_TreeNodeBPInput) Entity, environment);
	}

	public List<MTree_NodeBP> AD_TreeNodeBPSaveMany(List<I_AD_TreeNodeBPInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TreeNodeBPInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTree_NodeBP) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeNodeBPDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
