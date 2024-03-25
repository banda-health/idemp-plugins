package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_OrgInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_OrgInput;
import org.compiere.model.MOrg;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_OrgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_OrgInput.Table_Name;
	}

	public MOrg AD_OrgSave(I_AD_OrgInput entity, DataFetchingEnvironment environment) {
		return (MOrg) super.save((X_AD_OrgInput) entity, environment);
	}

	public List<MOrg> AD_OrgSaveMany(List<I_AD_OrgInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_OrgInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOrg) entity).collect(Collectors.toList());
	}

	public boolean AD_OrgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
