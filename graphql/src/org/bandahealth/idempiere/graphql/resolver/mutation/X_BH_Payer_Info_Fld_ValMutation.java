package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Payer_Info_Fld_ValInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Payer_Info_Fld_ValInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payer_Info_Fld_ValMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Payer_Info_Fld_ValInput.Table_Name;
	}

	public MBHPayerInfoFldVal BH_Payer_Info_Fld_ValSave(I_BH_Payer_Info_Fld_ValInput Entity, DataFetchingEnvironment environment) {
		return (MBHPayerInfoFldVal) super.save((X_BH_Payer_Info_Fld_ValInput) Entity, environment);
	}

	public List<MBHPayerInfoFldVal> BH_Payer_Info_Fld_ValSaveMany(List<I_BH_Payer_Info_Fld_ValInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Payer_Info_Fld_ValInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPayerInfoFldVal) entity).collect(Collectors.toList());
	}

	public boolean BH_Payer_Info_Fld_ValDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
