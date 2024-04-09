package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_BPartnerInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BPartnerInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BPartnerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BPartnerInput.Table_Name;
	}

	public MBPartner_BH C_BPartnerSave(I_C_BPartnerInput Entity, DataFetchingEnvironment environment) {
		return (MBPartner_BH) super.save((X_C_BPartnerInput) Entity, environment);
	}

	public List<MBPartner_BH> C_BPartnerSaveMany(List<I_C_BPartnerInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BPartnerInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBPartner_BH) entity).collect(Collectors.toList());
	}

	public boolean C_BPartnerDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
