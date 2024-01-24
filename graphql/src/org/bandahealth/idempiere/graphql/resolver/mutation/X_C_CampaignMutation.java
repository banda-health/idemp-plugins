package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CampaignInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CampaignInput;
import org.compiere.model.MCampaign;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CampaignMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CampaignInput.Table_Name;
	}

	public MCampaign C_CampaignSave(I_C_CampaignInput entity, DataFetchingEnvironment environment) {
		return (MCampaign) super.save((X_C_CampaignInput) entity, environment);
	}

	public List<MCampaign> C_CampaignSaveMany(List<I_C_CampaignInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CampaignInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCampaign) entity).collect(Collectors.toList());
	}

	public boolean C_CampaignDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
