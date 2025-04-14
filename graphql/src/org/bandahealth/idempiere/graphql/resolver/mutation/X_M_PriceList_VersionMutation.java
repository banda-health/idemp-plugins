package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PriceList_VersionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PriceList_VersionInput;
import org.compiere.model.MPriceListVersion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PriceList_Version - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_PriceList_VersionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PriceList_VersionInput.Table_Name;
	}

	public MPriceListVersion M_PriceList_VersionSave(I_M_PriceList_VersionInput Entity, DataFetchingEnvironment environment) {
		return (MPriceListVersion) super.save((X_M_PriceList_VersionInput) Entity, environment);
	}

	public List<MPriceListVersion> M_PriceList_VersionSaveMany(List<I_M_PriceList_VersionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_PriceList_VersionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPriceListVersion) entity).collect(Collectors.toList());
	}

	public boolean M_PriceList_VersionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
