package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Voided_ReasonDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_VisitResolver extends POResolver<MBHVisit> implements GraphQLResolver<MBHVisit> {


	static Map<String, String> BH_PATIENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBHVisit.BH_PATIENTTYPE_OutpatientOPD, "0a48b24a-8c67-4067-beb5-4eb3bc7daeb1");
			put(MBHVisit.BH_PATIENTTYPE_InpatientIPD, "46d397b3-103d-4663-86b2-27e395dd158d");
			put(MBHVisit.BH_PATIENTTYPE_AntenatalANC, "3ce6d10d-8c9c-4e4d-b7ff-67abe9da58a1");
			put(MBHVisit.BH_PATIENTTYPE_ImmunizationsWellChild, "3cbeb14f-10db-4e32-9b85-e3463eb620b8");
			put(MBHVisit.BH_PATIENTTYPE_Maternity, "4fa370d8-d02f-4506-91b9-9f06c2e00baf");
			put(MBHVisit.BH_PATIENTTYPE_Dental, "1841d957-db04-4640-af15-811a12deb7e4");
			put(MBHVisit.BH_PATIENTTYPE_EyeClinic, "1e8a9ec6-0f1e-4fac-8085-593ebeec9d44");
			put(MBHVisit.BH_PATIENTTYPE_Surgery, "74d58aed-2017-47bc-94f0-9a20c7b208a2");
			put(MBHVisit.BH_PATIENTTYPE_OverTheCounterOTC, "6ba8938f-3337-4224-be0b-0cbcd3c606ad");
			put(MBHVisit.BH_PATIENTTYPE_HomeVisit, "6403b016-5628-4612-a7a1-00e68e3dd0ae");
			put(MBHVisit.BH_PATIENTTYPE_PTOT, "1cbfa54e-47ba-4d7b-ada0-119ac3404767");
			put(MBHVisit.BH_PATIENTTYPE_Follow_Up, "65ef5222-ed10-4764-b516-a9874ef56519");
			put(MBHVisit.BH_PATIENTTYPE_FamilyPlanning, "fd6db151-fb69-40ed-a784-5d8b99b92004");
		}
	};
	public CompletableFuture<MRefList> BH_PatientType_RL(MBHVisit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_PatientType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BH_PATIENTTYPE_UUIDS_BY_VALUE.get(entity.getBH_PatientType()));
	}

	static Map<String, String> BH_PROCESS_STAGE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBHVisit.BH_PROCESS_STAGE_Clinician, "e74d5f99-fd01-4d54-ab35-7a630c43f064");
			put(MBHVisit.BH_PROCESS_STAGE_Cashier, "fed0d4f4-4eb2-478c-beb4-9570a8da06bf");
			put(MBHVisit.BH_PROCESS_STAGE_Lab, "e3eace1e-ee22-409b-a7ae-09cee5350b91");
			put(MBHVisit.BH_PROCESS_STAGE_Pharmacy, "24c32cc4-3fdb-4448-85a5-879eea7866ea");
		}
	};
	public CompletableFuture<MRefList> BH_Process_Stage_RL(MBHVisit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Process_Stage())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BH_PROCESS_STAGE_UUIDS_BY_VALUE.get(entity.getBH_Process_Stage()));
	}

	static Map<String, String> BH_REFERRAL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MBHVisit.BH_REFERRAL_ReferralFromHealthFacilities, "d8a8e37e-18ff-4445-9469-775eea1408e4");
			put(MBHVisit.BH_REFERRAL_ReferralToOtherHealthFacility, "bffef4a3-34ef-4af3-9cf5-8471bfda5cd7");
			put(MBHVisit.BH_REFERRAL_ReferralFromCommunityUnit, "4274fce2-29b8-4e4f-a58e-dd77ec039f53");
			put(MBHVisit.BH_REFERRAL_ReferralToCommunityUnit, "e1d9d266-cefd-4749-94de-20ad020c7d91");
		}
	};
	public CompletableFuture<MRefList> bh_referral_RL(MBHVisit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getbh_referral())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BH_REFERRAL_UUIDS_BY_VALUE.get(entity.getbh_referral()));
	}


	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	public CompletableFuture<MBHVoidedReason> BH_Voided_Reason(MBHVisit entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Voided_Reason_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBHVoidedReason> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Voided_ReasonDataLoader.BH_Voided_Reason_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getBH_Voided_Reason_ID());
	}


	/**
	 * Get Patient.
	 *
	 * @return The Patient must be a valid business partner.
	 */
	public CompletableFuture<MBPartner_BH> Patient(MBHVisit entity, DataFetchingEnvironment environment) {
		if (entity.getPatient_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPatient_ID());
	}

}
