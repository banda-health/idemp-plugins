package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TreeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TreeInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeInput.Table_Name;
	}

	public MTree_BH AD_TreeSave(I_AD_TreeInput entity, DataFetchingEnvironment environment) {
		return (MTree_BH) super.save((X_AD_TreeInput) entity, environment);
	}

	public List<MTree_BH> AD_TreeSaveMany(List<I_AD_TreeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_TreeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTree_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_TreeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
