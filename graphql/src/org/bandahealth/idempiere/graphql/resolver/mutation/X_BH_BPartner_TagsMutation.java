package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPartnerTags;
import org.bandahealth.idempiere.graphql.model.input.I_BH_BPartner_TagsInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_BPartner_TagsInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_BPartner_Tags - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_BPartner_TagsMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_BPartner_TagsInput.Table_Name;
	}

	public MBHBPartnerTags BH_BPartner_TagsSave(I_BH_BPartner_TagsInput Entity, DataFetchingEnvironment environment) {
		return (MBHBPartnerTags) super.save((X_BH_BPartner_TagsInput) Entity, environment);
	}

	public List<MBHBPartnerTags> BH_BPartner_TagsSaveMany(List<I_BH_BPartner_TagsInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_BPartner_TagsInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHBPartnerTags) entity).collect(Collectors.toList());
	}

	public boolean BH_BPartner_TagsDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
