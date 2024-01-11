package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankDataLoader;
import org.compiere.model.MBank;
import org.compiere.model.MPInstance;
import org.compiere.model.X_T_BankRegister;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_BankRegister - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_BankRegisterResolver extends POResolver<X_T_BankRegister> implements GraphQLResolver<X_T_BankRegister> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_T_BankRegister entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.AD_PInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}


	/**
	 * Get Bank.
	 *
	 * @return Bank
	 */
	public CompletableFuture<MBank> C_Bank(X_T_BankRegister entity, DataFetchingEnvironment environment) {
		if (entity.getC_Bank_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBank> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankDataLoader.C_Bank_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Bank_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_T_BankRegister entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}

}
