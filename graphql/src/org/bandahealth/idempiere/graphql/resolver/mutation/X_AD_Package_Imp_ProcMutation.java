package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Package_Imp_ProcInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Package_Imp_ProcInput;
import org.compiere.model.X_AD_Package_Imp_Proc;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Package_Imp_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Package_Imp_ProcMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_ProcInput.Table_Name;
	}

	public X_AD_Package_Imp_Proc AD_Package_Imp_ProcSave(I_AD_Package_Imp_ProcInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_Package_Imp_Proc) super.save((X_AD_Package_Imp_ProcInput) Entity, environment);
	}

	public List<X_AD_Package_Imp_Proc> AD_Package_Imp_ProcSaveMany(List<I_AD_Package_Imp_ProcInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Package_Imp_ProcInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Package_Imp_Proc) entity).collect(Collectors.toList());
	}

	public boolean AD_Package_Imp_ProcDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
