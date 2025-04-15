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
 * @version Release 12 - $Id$
 */
public class X_AD_OrgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_OrgInput.Table_Name;
	}

	public MOrg AD_OrgSave(I_AD_OrgInput Entity, DataFetchingEnvironment environment) {
		return (MOrg) super.save((X_AD_OrgInput) Entity, environment);
	}

	public List<MOrg> AD_OrgSaveMany(List<I_AD_OrgInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_OrgInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOrg) entity).collect(Collectors.toList());
	}

	public boolean AD_OrgDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
