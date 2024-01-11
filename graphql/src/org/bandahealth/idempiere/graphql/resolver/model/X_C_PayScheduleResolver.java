package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTermDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPaySchedule;
import org.compiere.model.MPaymentTerm;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PayScheduleResolver extends POResolver<MPaySchedule> implements GraphQLResolver<MPaySchedule> {



	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public CompletableFuture<MPaymentTerm> C_PaymentTerm(MPaySchedule entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentTerm_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.C_PaymentTerm_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_PaymentTerm_ID());
	}

	public Boolean IsValid(MPaySchedule entity, DataFetchingEnvironment environment) {
		return entity.isValid();
	}

	static Map<String, String> NETDAY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("7", "ad54c61a-75e4-4257-9c70-4e6b1b772686");
			put("1", "a225bd22-7f57-493e-aee5-d0cf71891cd0");
			put("2", "6c7920e4-dc0e-436f-b220-0729aad44bf2");
			put("3", "f0e5917d-cfa7-460c-a0b1-b9610e9506f1");
			put("4", "7862d4ca-778b-4425-974e-6002d925e8d5");
			put("5", "e2bdb391-5b9a-41f9-a3b0-8309e47b299a");
			put("6", "13efb0f3-7cc6-4339-85e5-bcaadf0ca31c");
		}
	};
	public CompletableFuture<MRefList_BH> NetDay(MPaySchedule entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getNetDay())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(NETDAY_UUIDS_BY_VALUE.get(entity.getNetDay()));
	}

}
