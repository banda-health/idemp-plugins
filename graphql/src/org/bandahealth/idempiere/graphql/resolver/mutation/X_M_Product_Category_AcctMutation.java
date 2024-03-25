package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_Product_Category_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_Product_Category_AcctInput;
import org.compiere.model.MProductCategoryAcct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Product_Category_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_Category_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_Product_Category_AcctInput.Table_Name;
	}

	public MProductCategoryAcct M_Product_Category_AcctSave(I_M_Product_Category_AcctInput entity, DataFetchingEnvironment environment) {
		return (MProductCategoryAcct) super.save((X_M_Product_Category_AcctInput) entity, environment);
	}

	public List<MProductCategoryAcct> M_Product_Category_AcctSaveMany(List<I_M_Product_Category_AcctInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_Product_Category_AcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProductCategoryAcct) entity).collect(Collectors.toList());
	}

	public boolean M_Product_Category_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
