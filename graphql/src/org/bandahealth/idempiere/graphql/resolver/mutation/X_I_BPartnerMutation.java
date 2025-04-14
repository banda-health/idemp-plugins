package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_BPartnerInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_BPartnerInput;
import org.compiere.model.X_I_BPartner;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_I_BPartnerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_BPartnerInput.Table_Name;
	}

	public X_I_BPartner I_BPartnerSave(I_I_BPartnerInput Entity, DataFetchingEnvironment environment) {
		return (X_I_BPartner) super.save((X_I_BPartnerInput) Entity, environment);
	}

	public List<X_I_BPartner> I_BPartnerSaveMany(List<I_I_BPartnerInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_I_BPartnerInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_BPartner) entity).collect(Collectors.toList());
	}

	public boolean I_BPartnerDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
