package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RecurringGroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalBatchDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MProject;
import org.compiere.model.MRecurring;
import org.compiere.model.X_C_RecurringGroup;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RecurringResolver extends POResolver<MRecurring> implements GraphQLResolver<MRecurring> {



	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MRecurring entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.C_Invoice_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MRecurring entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.C_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MRecurring entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.C_Payment_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Payment_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MRecurring entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.C_Project_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Recurring Group.
	 *
	 * @return Recurring Group
	 */
	public CompletableFuture<X_C_RecurringGroup> C_RecurringGroup(MRecurring entity, DataFetchingEnvironment environment) {
		if (entity.getC_RecurringGroup_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_RecurringGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RecurringGroupDataLoader.C_RecurringGroup_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_RecurringGroup_ID());
	}

	static Map<String, String> FREQUENCYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "a0dc2171-cf3e-43b1-8cce-e1438e53484e");
			put("W", "e85224da-cc1c-454d-9cd2-fd2b7348bf3c");
			put("M", "5ed60b0f-03cd-4ad3-923f-c0bdd3640db3");
			put("Q", "e30f5e5c-0cb7-4a76-bd07-01c4719125aa");
		}
	};
	public CompletableFuture<MRefList_BH> FrequencyType(MRecurring entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFrequencyType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(FREQUENCYTYPE_UUIDS_BY_VALUE.get(entity.getFrequencyType()));
	}


	/**
	 * Get Journal Batch.
	 *
	 * @return General Ledger Journal Batch
	 */
	public CompletableFuture<MJournalBatch> GL_JournalBatch(MRecurring entity, DataFetchingEnvironment environment) {
		if (entity.getGL_JournalBatch_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MJournalBatch> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_JournalBatchDataLoader.GL_JournalBatch_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getGL_JournalBatch_ID());
	}

	public Boolean Processing(MRecurring entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	static Map<String, String> RECURRINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "77294857-4ee4-46fe-a6e5-08bbb5f671b5");
			put("O", "658f69b4-7ec1-424c-972e-9dc7103f914e");
			put("G", "dc9c720c-8192-4fee-bda0-e6b393217377");
			put("J", "fbb66437-dc01-450e-80bd-5498a86fc4b1");
			put("P", "b3e77f8d-0d0d-4bf5-bb42-d998fb0c728c");
		}
	};
	public CompletableFuture<MRefList_BH> RecurringType(MRecurring entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRecurringType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(RECURRINGTYPE_UUIDS_BY_VALUE.get(entity.getRecurringType()));
	}

}
