package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_RecentItemInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_RecentItemInput;
import org.compiere.model.MRecentItem;

import java.util.List;

/**
 * Generated Query Resolver for AD_RecentItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RecentItemMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_RecentItemInput.Table_Name;
	}

	public MRecentItem AD_RecentItemSave(I_AD_RecentItemInput input, DataFetchingEnvironment environment) {
		return (MRecentItem) super.save((X_AD_RecentItemInput) input, environment);
	}

	public boolean AD_RecentItemDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
