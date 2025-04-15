package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_Fact_AcctDataLoader;
import org.compiere.model.MElementValue;
import org.compiere.model.MFactAcct;
import org.compiere.model.MFactReconciliation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_Fact_ReconciliationResolver extends POResolver<MFactReconciliation> implements GraphQLResolver<MFactReconciliation> {



	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	public CompletableFuture<MElementValue> Account(MFactReconciliation entity, DataFetchingEnvironment environment) {
		if (entity.getAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getAccount_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MFactReconciliation entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Accounting Fact.
	 *
	 * @return Accounting Fact
	 */
	public CompletableFuture<MFactAcct> Fact_Acct(MFactReconciliation entity, DataFetchingEnvironment environment) {
		if (entity.getFact_Acct_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MFactAcct> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_Fact_AcctDataLoader.DATALOADER_Fact_Acct_BY_ID);
		return dataLoader.load(entity.getFact_Acct_ID());
	}

}
