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
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeBPMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeBPInput.Table_Name;
	}

	public MTree_NodeBP AD_TreeNodeBPSave(I_AD_TreeNodeBPInput entity, DataFetchingEnvironment environment) {
		return (MTree_NodeBP) super.save((X_AD_TreeNodeBPInput) entity, environment);
	}

	public List<MTree_NodeBP> AD_TreeNodeBPSaveMany(List<I_AD_TreeNodeBPInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_TreeNodeBPInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTree_NodeBP) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeNodeBPDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
