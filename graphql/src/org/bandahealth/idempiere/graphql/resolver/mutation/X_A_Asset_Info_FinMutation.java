package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Info_FinInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Info_FinInput;
import org.compiere.model.X_A_Asset_Info_Fin;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Info_Fin - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_Info_FinMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_FinInput.Table_Name;
	}

	public X_A_Asset_Info_Fin A_Asset_Info_FinSave(I_A_Asset_Info_FinInput entity, DataFetchingEnvironment environment) {
		return (X_A_Asset_Info_Fin) super.save((X_A_Asset_Info_FinInput) entity, environment);
	}

	public List<X_A_Asset_Info_Fin> A_Asset_Info_FinSaveMany(List<I_A_Asset_Info_FinInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Asset_Info_FinInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Asset_Info_Fin) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_Info_FinDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
