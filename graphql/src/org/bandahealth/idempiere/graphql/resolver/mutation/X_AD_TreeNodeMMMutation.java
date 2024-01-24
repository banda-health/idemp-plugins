package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeNodeMMInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeNodeMMInput;
import org.compiere.model.MTree_NodeMM;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_TreeNodeMM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeNodeMMMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeMMInput.Table_Name;
	}

	public MTree_NodeMM AD_TreeNodeMMSave(I_AD_TreeNodeMMInput entity, DataFetchingEnvironment environment) {
		return (MTree_NodeMM) super.save((X_AD_TreeNodeMMInput) entity, environment);
	}

	public List<MTree_NodeMM> AD_TreeNodeMMSaveMany(List<I_AD_TreeNodeMMInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_TreeNodeMMInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTree_NodeMM) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeNodeMMDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
