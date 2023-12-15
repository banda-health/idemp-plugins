package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.M_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Boolean methods needs to be generated to get the capitalized letters
 */
public class X_BH_VisitResolver extends BaseResolver<MBHVisit> implements GraphQLResolver<MBHVisit> {
	static Map<String, String> BH_PATIENTTYPE_UUIDS_BY_VALUE = Map.ofEntries(
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_OutpatientOPD, "0a48b24a-8c67-4067-beb5-4eb3bc7daeb1"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_InpatientIPD, "46d397b3-103d-4663-86b2-27e395dd158d"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_AntenatalANC, "3ce6d10d-8c9c-4e4d-b7ff-67abe9da58a1"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_ImmunizationsWellChild,
					"3cbeb14f-10db-4e32-9b85-e3463eb620b8"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_Maternity, "4fa370d8-d02f-4506-91b9-9f06c2e00baf"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_Dental, "1841d957-db04-4640-af15-811a12deb7e4"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_EyeClinic, "1e8a9ec6-0f1e-4fac-8085-593ebeec9d44"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_Surgery, "74d58aed-2017-47bc-94f0-9a20c7b208a2"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_OverTheCounterOTC, "6ba8938f-3337-4224-be0b-0cbcd3c606ad"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_HomeVisit, "6403b016-5628-4612-a7a1-00e68e3dd0ae"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_PTOT, "1cbfa54e-47ba-4d7b-ada0-119ac3404767"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_Follow_Up, "65ef5222-ed10-4764-b516-a9874ef56519"),
			new AbstractMap.SimpleEntry<>(MBHVisit.BH_PATIENTTYPE_FamilyPlanning, "fd6db151-fb69-40ed-a784-5d8b99b92004")
	);

	public CompletableFuture<MRefList> BH_PatientType_RL(MBHVisit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_PatientType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(M_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BH_PATIENTTYPE_UUIDS_BY_VALUE.get(entity.getBH_PatientType()));
	}

	public MRefList BH_Process_Stage_RL(MBHVisit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Process_Stage())) {
			return null;
		}
		return new MRefList(BandaGraphQLContext.getCtx(environment), 0, entity.get_TrxName());
	}

	public MRefList bh_referral_RL(MBHVisit entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getbh_referral())) {
			return null;
		}
		return new MRefList(BandaGraphQLContext.getCtx(environment), 0, entity.get_TrxName());
	}

	public MBHVoidedReason BH_Voided_Reason(MBHVisit entity, DataFetchingEnvironment environment) {
		return null;
	}

	public MBPartner_BH Patient(MBHVisit entity, DataFetchingEnvironment environment) {
		return new MBPartner_BH(BandaGraphQLContext.getCtx(environment), 1000118, entity.get_TrxName());
	}
}
