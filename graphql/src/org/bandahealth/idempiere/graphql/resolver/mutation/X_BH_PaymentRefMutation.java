package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.graphql.model.input.I_BH_PaymentRefInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_PaymentRefInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_PaymentRef - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_PaymentRefMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_PaymentRefInput.Table_Name;
	}

	public MBHPaymentRef BH_PaymentRefSave(I_BH_PaymentRefInput entity, DataFetchingEnvironment environment) {
		return (MBHPaymentRef) super.save((X_BH_PaymentRefInput) entity, environment);
	}

	public List<MBHPaymentRef> BH_PaymentRefSaveMany(List<I_BH_PaymentRefInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_PaymentRefInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPaymentRef) entity).collect(Collectors.toList());
	}

	public boolean BH_PaymentRefDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
