package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.compiere.model.MAccount;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Concept_Category;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Concept_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_Concept_CategoryResolver extends POResolver<X_HR_Concept_Category> implements GraphQLResolver<X_HR_Concept_Category> {



	/**
	 * Get Payroll Concept Account.
	 *
	 * @return Payroll Concept Account
	 */
	public CompletableFuture<MAccount> HR_Concept_A(X_HR_Concept_Category entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Concept_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getHR_Concept_Acct());
	}

	public Boolean IsDefault(X_HR_Concept_Category entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

}
