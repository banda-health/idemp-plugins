package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Package_Imp_InstInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Package_Imp_InstInput;
import org.compiere.model.X_AD_Package_Imp_Inst;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Package_Imp_Inst - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Package_Imp_InstMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_InstInput.Table_Name;
	}

	public X_AD_Package_Imp_Inst AD_Package_Imp_InstSave(I_AD_Package_Imp_InstInput entity, DataFetchingEnvironment environment) {
		return (X_AD_Package_Imp_Inst) super.save((X_AD_Package_Imp_InstInput) entity, environment);
	}

	public List<X_AD_Package_Imp_Inst> AD_Package_Imp_InstSaveMany(List<I_AD_Package_Imp_InstInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Package_Imp_InstInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Package_Imp_Inst) entity).collect(Collectors.toList());
	}

	public boolean AD_Package_Imp_InstDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
