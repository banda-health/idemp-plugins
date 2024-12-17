package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.GraphQLEndpoint;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHEncounterDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MInvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MPaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRefListDataLoader;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChangeLog;
import org.compiere.model.MColumn;
import org.compiere.model.Query;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class MBHVisitResolver extends X_BH_VisitResolver {
	private static final String COLUMNUU_BH_Process_Stage = "b334317c-e0f4-40f0-a738-bc14fa7b922b";

	/**
	 * This method goes through and sees if there is anything in the change log and pulls the most-recent value, if so
	 *
	 * @param entity      The visit entity
	 * @param environment The GraphQL data-fetching environment
	 * @return A reference list, if any
	 */
	public CompletableFuture<MRefList_BH> BH_Coming_From(MBHVisit entity, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		// Get the column we care about
		var cache = GraphQLEndpoint.getCache(MColumn.Table_Name);
		MColumn processStageColumn;
		if (cache.containsKey(COLUMNUU_BH_Process_Stage)) {
			processStageColumn = (MColumn) cache.get(COLUMNUU_BH_Process_Stage);
		} else {
			processStageColumn = Repository.getByUuid(idempiereContext, MColumn.Table_Name, null, COLUMNUU_BH_Process_Stage);
			cache.set(COLUMNUU_BH_Process_Stage, processStageColumn);
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MRefListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		MChangeLog previousProcessStageValue =
				new Query(BandaGraphQLContext.getCtx(environment), MChangeLog.Table_Name, "AD_Column_ID=? AND Record_ID = ?",
						null).setParameters(processStageColumn.get_ID(), entity.get_ID()).setOrderBy("Created DESC").first();
		if (previousProcessStageValue == null || previousProcessStageValue.isOldNull()) {
			return null;
		}
		return dataLoader.load(BH_PROCESS_STAGE_UUIDS_BY_VALUE.get(previousProcessStageValue.getOldValue()));
	}

	public CompletableFuture<List<MBHEncounter>> BH_Encounters(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MBHEncounter>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHEncounterDataLoader.DATALOADER_BH_Encounter_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}

	public CompletableFuture<List<MInvoice_BH>> C_Invoices(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MInvoice_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MInvoiceDataLoader.DATALOADER_C_Invoice_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}

	public CompletableFuture<List<MOrder_BH>> C_Orders(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MOrder_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MOrderDataLoader.DATALOADER_C_Order_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}

	public CompletableFuture<List<MPayment_BH>> C_Payments(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MPayment_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MPaymentDataLoader.DATALOADER_C_Payment_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}

	public CompletableFuture<List<MInOut_BH>> M_InOuts(MBHVisit entity, DataFetchingEnvironment environment) {
		final DataLoader<String, List<MInOut_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MInOutDataLoader.DATALOADER_M_InOut_BY_BH_Visit_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getBH_Visit_ID()));
	}
}
