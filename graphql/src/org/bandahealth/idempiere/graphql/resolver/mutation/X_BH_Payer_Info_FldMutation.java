package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payer_Info_FldInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payer_Info_FldInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Payer_Info_FldMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payer_Info_FldInput.Table_Name;
	}

	public MBHPayerInfoFld BH_Payer_Info_FldSave(I_BH_Payer_Info_FldInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayerInfoFld) super.save((X_BH_Payer_Info_FldInput) Entity, environment);
	}

	public List<MBHPayerInfoFld> BH_Payer_Info_FldSaveMany(List<I_BH_Payer_Info_FldInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payer_Info_FldInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayerInfoFld) entity).collect(Collectors.toList());
	}

	public boolean BH_Payer_Info_FldDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
