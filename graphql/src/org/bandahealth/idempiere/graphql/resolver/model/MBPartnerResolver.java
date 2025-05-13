package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHAllergy;
import org.bandahealth.idempiere.base.model.MBHAllergyReaction;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.base.model.MBHBPartnerTags;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHAllergyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHAllergyReactionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHBPGeneralPayerInfoDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHBPPayerInfoDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHBPartnerTagsDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHPayerInfoFldDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBHVisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBPBankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MBPartnerLocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MUserDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MBPartnerLocation;
import org.dataloader.DataLoader;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MBPartnerResolver extends X_C_BPartnerResolver {

	public CompletableFuture<List<MBHAllergy>> BH_Allergies(MBPartner_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHAllergy>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHAllergyDataLoader.DATALOADER_BH_Allergy_BY_C_BPartner_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}

	public CompletableFuture<List<MBHBPPayerInfo>> BH_BP_Payer_Info_BPList(MBPartner_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHBPPayerInfo>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MBHBPPayerInfoDataLoader.BH_BP_Payer_Info_BY_C_BPartner_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}

	public CompletableFuture<List<MBHBPPayerInfo>> BH_BP_Payer_Info_PayerList(MBPartner_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHBPPayerInfo>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MBHBPPayerInfoDataLoader.BH_BP_Payer_Info_BY_BH_Payer_ID_DATA_LOADER);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}

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
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()))
				.thenApply(totalVisits -> totalVisits == null ? 0 : totalVisits);
	}

	public CompletableFuture<List<MUser_BH>> Contacts(MBPartner_BH entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MUser_BH>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MUserDataLoader.DATALOADER_AD_User_BY_C_BPartner_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}

	public CompletableFuture<List<MBPBankAccount>> C_BP_BankAccounts(MBPartner_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBPBankAccount>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBPBankAccountDataLoader.DATALOADER_C_BP_BankAccount_BY_C_BPartner_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}
	
	public CompletableFuture<List<MBHBPartnerTags>> BH_BPartner_Tags(MBPartner_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MBHBPartnerTags>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MBHBPartnerTagsDataLoader.DATALOADER_BH_BPartner_Tags_BY_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_BPartner_ID()));
	}
}
