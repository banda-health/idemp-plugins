package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payer_Info_Fld_Val_SugInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payer_Info_Fld_Val_SugInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld_Val_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Payer_Info_Fld_Val_SugMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payer_Info_Fld_Val_SugInput.Table_Name;
	}

	public MBHPayerInfoFldValSug BH_Payer_Info_Fld_Val_SugSave(I_BH_Payer_Info_Fld_Val_SugInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayerInfoFldValSug) super.save((X_BH_Payer_Info_Fld_Val_SugInput) Entity, environment);
	}

	public List<MBHPayerInfoFldValSug> BH_Payer_Info_Fld_Val_SugSaveMany(List<I_BH_Payer_Info_Fld_Val_SugInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payer_Info_Fld_Val_SugInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayerInfoFldValSug) entity).collect(Collectors.toList());
	}

	public boolean BH_Payer_Info_Fld_Val_SugDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
