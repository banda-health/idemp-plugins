package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_RV_BPartnerInput;
import org.bandahealth.idempiere.graphql.model.input.X_RV_BPartnerInput;
import org.compiere.model.MBPartnerInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for RV_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_RV_BPartnerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_RV_BPartnerInput.Table_Name;
	}

	public MBPartnerInfo RV_BPartnerSave(I_RV_BPartnerInput Entity, DataFetchingEnvironment environment) {
		return (MBPartnerInfo) super.save((X_RV_BPartnerInput) Entity, environment);
	}

	public List<MBPartnerInfo> RV_BPartnerSaveMany(List<I_RV_BPartnerInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_RV_BPartnerInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBPartnerInfo) entity).collect(Collectors.toList());
	}

	public boolean RV_BPartnerDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
