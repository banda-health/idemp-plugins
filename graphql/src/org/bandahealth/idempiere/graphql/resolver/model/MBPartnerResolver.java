package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHPayerInfoFldDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHVisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBPartnerLocationDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.dataloader.DataLoader;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBPartnerResolver extends X_C_BPartnerResolver {
	public CompletableFuture<List<MBHPayerInfoFld>> BH_Payer_Info_FldList(MBPartner_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHPayerInfoFld>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MBHPayerInfoFldDataLoader.BH_Payer_Info_Fld_BY_PAYER_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}

	public CompletableFuture<List<MBPartnerLocation>> C_BPartner_Locations(MBPartner_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBPartnerLocation>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MBPartnerLocationDataLoader.C_BPartner_Location_BY_BPARTNER_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}

	public CompletableFuture<Timestamp> LastVisitDate(MBPartner_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, Timestamp> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHVisitDataLoader.BH_Visit_LAST_VISIT_DATE_BY_Patient_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}

	public CompletableFuture<Integer> TotalVisits(MBPartner_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, Integer> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MBHVisitDataLoader.BH_Visit_COUNT_BY_Patient_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}
}
