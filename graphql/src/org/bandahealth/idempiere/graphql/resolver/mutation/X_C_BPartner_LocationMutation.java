package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BPartner_LocationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BPartner_LocationInput;
import org.compiere.model.MBPartnerLocation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BPartner_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BPartner_LocationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BPartner_LocationInput.Table_Name;
	}

	public MBPartnerLocation C_BPartner_LocationSave(I_C_BPartner_LocationInput Entity, DataFetchingEnvironment environment) {
		return (MBPartnerLocation) super.save((X_C_BPartner_LocationInput) Entity, environment);
	}

	public List<MBPartnerLocation> C_BPartner_LocationSaveMany(List<I_C_BPartner_LocationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BPartner_LocationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBPartnerLocation) entity).collect(Collectors.toList());
	}

	public boolean C_BPartner_LocationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
