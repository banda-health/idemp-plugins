package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_VisitDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Visit_Family_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_PlanningResolver extends POResolver<MBHVisitFamilyPlanning> implements GraphQLResolver<MBHVisitFamilyPlanning> {


	public static Map<String, String> BH_CERVICAL_CANCER_SCREENING_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("yes", "5b43d8bf-efe6-4588-bb8c-00a746889036"); // Yes
			put("no", "6f78e402-6989-4f3e-90df-8fa553b9ab7a"); // No
		}
	};
	public CompletableFuture<MRefList_BH> BH_Cervical_Cancer_Screening(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Cervical_Cancer_Screening())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_CERVICAL_CANCER_SCREENING_UUIDS_BY_VALUE.get(entity.getBH_Cervical_Cancer_Screening()));
	}

	public static Map<String, String> BH_CERVICAL_PAP_METHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("via", "256d2fe0-16dd-4933-b63a-372f0518533a"); // VIA
			put("vili", "d8549b4b-070b-4d2c-b11e-a1b1e00a46a6"); // VILI
			put("hpv", "bc7248c5-6e40-419c-8c1d-24c80ebd6755"); // HPV
			put("nd", "12edcaf9-a254-4815-ace5-2cbdf083ced4"); // ND
			put("normal", "fec49b69-5eac-466c-aa8f-c1fbf6dfd254"); // Normal
		}
	};
	public CompletableFuture<MRefList_BH> BH_Cervical_Pap_Method(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Cervical_Pap_Method())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_CERVICAL_PAP_METHOD_UUIDS_BY_VALUE.get(entity.getBH_Cervical_Pap_Method()));
	}

	public static Map<String, String> BH_CERVICAL_RESULTS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("suspected", "ff7988b4-eaee-464f-aca7-571471e2264d"); // Suspected
			put("confirmed", "0d332fe4-8330-446d-a9d2-dae82d3b1289"); // Confirmed
			put("notDone", "1b12ca35-fa79-4906-88f4-2d1121bb4cae"); // Not done
		}
	};
	public CompletableFuture<MRefList_BH> BH_Cervical_Results(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Cervical_Results())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_CERVICAL_RESULTS_UUIDS_BY_VALUE.get(entity.getBH_Cervical_Results()));
	}

	public Boolean BH_Contraceptive_Condoms(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Contraceptive_Condoms();
	}

	public Boolean BH_Contraceptive_Emergency(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Contraceptive_Emergency();
	}

	public Boolean BH_Contraceptive_Implants(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Contraceptive_Implants();
	}

	public Boolean BH_Contraceptive_Injectable(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Contraceptive_Injectable();
	}

	public Boolean BH_Contraceptive_Iucd(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Contraceptive_Iucd();
	}

	public Boolean BH_Contraceptive_Natural_Fp(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Contraceptive_Natural_Fp();
	}

	public Boolean BH_Contraceptive_Oral(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Contraceptive_Oral();
	}

	public Boolean BH_Contraceptive_Vsc(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Contraceptive_Vsc();
	}

	public static Map<String, String> BH_CYCLE_BEADS_GIVEN_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("yes", "5b43d8bf-efe6-4588-bb8c-00a746889036"); // Yes
			put("no", "6f78e402-6989-4f3e-90df-8fa553b9ab7a"); // No
		}
	};
	public CompletableFuture<MRefList_BH> BH_Cycle_Beads_Given(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Cycle_Beads_Given())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_CYCLE_BEADS_GIVEN_UUIDS_BY_VALUE.get(entity.getBH_Cycle_Beads_Given()));
	}

	public static Map<String, String> BH_EMERGENCY_CONTRACEPTION_GIVEN_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("yes", "5b43d8bf-efe6-4588-bb8c-00a746889036"); // Yes
			put("no", "6f78e402-6989-4f3e-90df-8fa553b9ab7a"); // No
		}
	};
	public CompletableFuture<MRefList_BH> BH_Emergency_Contraception_Given(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Emergency_Contraception_Given())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_EMERGENCY_CONTRACEPTION_GIVEN_UUIDS_BY_VALUE.get(entity.getBH_Emergency_Contraception_Given()));
	}

	public static Map<String, String> BH_FIRST_EVER_CONTRACEPTIVE_USER_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("yes", "5b43d8bf-efe6-4588-bb8c-00a746889036"); // Yes
			put("no", "6f78e402-6989-4f3e-90df-8fa553b9ab7a"); // No
		}
	};
	public CompletableFuture<MRefList_BH> BH_First_Ever_Contraceptive_User(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_First_Ever_Contraceptive_User())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_FIRST_EVER_CONTRACEPTIVE_USER_UUIDS_BY_VALUE.get(entity.getBH_First_Ever_Contraceptive_User()));
	}

	public static Map<String, String> BH_FIRST_VISIT_FP_AT_CLINIC_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("newToFacility", "7e3a6ad8-a221-499f-8e2e-6606843c13c7"); // New to facility
			put("revisit", "a5502a67-5e2d-45ae-94de-5301d3e46e7a"); // Revisit
		}
	};
	public CompletableFuture<MRefList_BH> BH_First_Visit_Fp_At_Clinic(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_First_Visit_Fp_At_Clinic())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_FIRST_VISIT_FP_AT_CLINIC_UUIDS_BY_VALUE.get(entity.getBH_First_Visit_Fp_At_Clinic()));
	}

	public static Map<String, String> BH_HIV_COUNSELED_TESTED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("yes", "d37a46db-b433-4439-8718-753dd7f64852"); // Yes
			put("refused", "e1a08e5b-707f-4f06-8c19-eba3ddb26ff8"); // Refused
			put("notOffered", "8534bebb-0e38-4031-b9c3-4abbfb84c6f9"); // Not offered
		}
	};
	public CompletableFuture<MRefList_BH> BH_Hiv_Counseled_Tested(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Hiv_Counseled_Tested())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_HIV_COUNSELED_TESTED_UUIDS_BY_VALUE.get(entity.getBH_Hiv_Counseled_Tested()));
	}

	public static Map<String, String> BH_HIV_RESULTS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("knownPositive", "57dd268e-0cda-41ed-920e-31a702a1b146"); // Known positive
			put("positiveToday", "1df2b2a8-2769-475f-9e50-85b8214bf471"); // Positive today
			put("negativeToday", "256d8be3-c574-4319-a3cd-10a2dcca51db"); // Negative today
			put("unknown", "a843bc3a-774a-4fbe-8a8e-bc08997a9c5a"); // Unknown
		}
	};
	public CompletableFuture<MRefList_BH> BH_Hiv_Results(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Hiv_Results())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_HIV_RESULTS_UUIDS_BY_VALUE.get(entity.getBH_Hiv_Results()));
	}

	public static Map<String, String> BH_IMPLANTS_TYPE_OF_VISIT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("firstInsertion", "26c5700e-48c0-418b-98bf-592b013e5e10"); // First insertion
			put("removal", "1dc9ea5d-11fe-4de5-8b4d-a5ffd147d7b7"); // Removal
			put("reinsertion", "38d57153-b561-462c-bec6-4b0b1a1c82fb"); // Reinsertion
			put("checkUp", "af3cc36b-6bd6-4071-9090-1a239c8f40bb"); // Check up
		}
	};
	public CompletableFuture<MRefList_BH> BH_Implants_Type_Of_Visit(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Implants_Type_Of_Visit())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_IMPLANTS_TYPE_OF_VISIT_UUIDS_BY_VALUE.get(entity.getBH_Implants_Type_Of_Visit()));
	}

	public static Map<String, String> BH_INJECTABLE_ROUTE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("im", "ca83935b-50a1-4c1a-8b2d-8131337059f5"); // IM
			put("sc", "5705fdeb-25a6-459b-a0a7-b4e221019fad"); // SC
		}
	};
	public CompletableFuture<MRefList_BH> BH_Injectable_Route(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Injectable_Route())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_INJECTABLE_ROUTE_UUIDS_BY_VALUE.get(entity.getBH_Injectable_Route()));
	}

	public static Map<String, String> BH_INJECTABLE_TYPE_OF_VISIT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("new", "c725d23d-55af-47d5-8332-de8fe239ba74"); // New
			put("revisit", "cb1128cc-5f04-4eb8-978f-db17b5ae7925"); // Revisit
		}
	};
	public CompletableFuture<MRefList_BH> BH_Injectable_Type_Of_Visit(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Injectable_Type_Of_Visit())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_INJECTABLE_TYPE_OF_VISIT_UUIDS_BY_VALUE.get(entity.getBH_Injectable_Type_Of_Visit()));
	}

	public static Map<String, String> BH_IPV_REPRODUCTIVE_COERCION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("ipv", "32eb81ae-ba4a-4b9a-b83d-4286a3f42490"); // Experience of intimate partner violence
			put("reproductiveCoercion", "654369a5-8872-4a7b-9ae8-ef7c206f84f9"); // Reproductive coercion
			put("noGbv", "b66f3aa3-cbd1-4fc3-9918-8be4cec66afc"); // No gender-based violence
			put("notAsked", "7458582a-2e2a-4128-be33-0caab7ce1551"); // Not asked
		}
	};
	public CompletableFuture<MRefList_BH> BH_Ipv_Reproductive_Coercion(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Ipv_Reproductive_Coercion())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_IPV_REPRODUCTIVE_COERCION_UUIDS_BY_VALUE.get(entity.getBH_Ipv_Reproductive_Coercion()));
	}

	public static Map<String, String> BH_IUCD_TYPE_OF_VISIT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("firstInsertion", "26c5700e-48c0-418b-98bf-592b013e5e10"); // First insertion
			put("removal", "1dc9ea5d-11fe-4de5-8b4d-a5ffd147d7b7"); // Removal
			put("reinsertion", "38d57153-b561-462c-bec6-4b0b1a1c82fb"); // Reinsertion
			put("checkUp", "af3cc36b-6bd6-4071-9090-1a239c8f40bb"); // Check up
		}
	};
	public CompletableFuture<MRefList_BH> BH_Iucd_Type_Of_Visit(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Iucd_Type_Of_Visit())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_IUCD_TYPE_OF_VISIT_UUIDS_BY_VALUE.get(entity.getBH_Iucd_Type_Of_Visit()));
	}

	public static Map<String, String> BH_NATURAL_FP_COUNSELED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("yes", "5b43d8bf-efe6-4588-bb8c-00a746889036"); // Yes
			put("no", "6f78e402-6989-4f3e-90df-8fa553b9ab7a"); // No
		}
	};
	public CompletableFuture<MRefList_BH> BH_Natural_Fp_Counseled(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Natural_Fp_Counseled())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_NATURAL_FP_COUNSELED_UUIDS_BY_VALUE.get(entity.getBH_Natural_Fp_Counseled()));
	}

	public static Map<String, String> BH_ORAL_TYPE_OF_VISIT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("new", "c725d23d-55af-47d5-8332-de8fe239ba74"); // New
			put("revisit", "cb1128cc-5f04-4eb8-978f-db17b5ae7925"); // Revisit
		}
	};
	public CompletableFuture<MRefList_BH> BH_Oral_Type_Of_Visit(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Oral_Type_Of_Visit())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_ORAL_TYPE_OF_VISIT_UUIDS_BY_VALUE.get(entity.getBH_Oral_Type_Of_Visit()));
	}

	public static Map<String, String> BH_POSTPARTUM_FP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("within48h", "59bcbe08-2634-49e0-b4cc-b5499c978066"); // Within 48h
			put("fourToSixWeeks", "4c306355-9038-4808-902a-9342004fc9c4"); // 4-6 weeks
			put("postAbortion", "75f31037-98a2-4d0f-a504-13d4642ae0ab"); // Post abortion
			put("none", "87a69344-38d8-4984-acf4-2680d5faeff1"); // None
		}
	};
	public CompletableFuture<MRefList_BH> BH_Postpartum_Fp(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Postpartum_Fp())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_POSTPARTUM_FP_UUIDS_BY_VALUE.get(entity.getBH_Postpartum_Fp()));
	}

	public static Map<String, String> BH_REFERRAL_COMMUNITY_FROM_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("anotherFacility", "7b31f4e8-d1ef-4a9d-b921-3ea31c51db2f"); // Another facility
			put("notApplicable", "40acbf6d-cf05-4a48-b560-7a17db2b7d08"); // Not applicable
		}
	};
	public CompletableFuture<MRefList_BH> BH_Referral_Community_From(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Referral_Community_From())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_REFERRAL_COMMUNITY_FROM_UUIDS_BY_VALUE.get(entity.getBH_Referral_Community_From()));
	}

	public static Map<String, String> BH_REFERRAL_COMMUNITY_TO_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("anotherFacility", "7b31f4e8-d1ef-4a9d-b921-3ea31c51db2f"); // Another facility
			put("notApplicable", "40acbf6d-cf05-4a48-b560-7a17db2b7d08"); // Not applicable
		}
	};
	public CompletableFuture<MRefList_BH> BH_Referral_Community_To(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Referral_Community_To())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_REFERRAL_COMMUNITY_TO_UUIDS_BY_VALUE.get(entity.getBH_Referral_Community_To()));
	}

	public static Map<String, String> BH_REFERRALS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("yes", "5b43d8bf-efe6-4588-bb8c-00a746889036"); // Yes
			put("no", "6f78e402-6989-4f3e-90df-8fa553b9ab7a"); // No
		}
	};
	public CompletableFuture<MRefList_BH> BH_Referrals(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Referrals())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_REFERRALS_UUIDS_BY_VALUE.get(entity.getBH_Referrals()));
	}

	public Boolean BH_Screening_Cervical(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Screening_Cervical();
	}

	public Boolean BH_Screening_Hiv(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Screening_Hiv();
	}

	public Boolean BH_Screening_Ipv(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Screening_Ipv();
	}

	public Boolean BH_Screening_Tb(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Screening_Tb();
	}

	public static Map<String, String> BH_TB_SCREENING_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("presumedTb", "6420665a-3985-45e3-9c18-faf3ebc1e050"); // Presumed TB
			put("noSigns", "e8578f26-c557-45b6-aac0-869cb43df941"); // No signs
			put("onTreatment", "1cd5a7a0-cc38-4f68-a32c-6bd4ed06f2a3"); // On treatment
			put("notDone", "83a3b6a1-dbbd-42b9-bcf5-b2060bed4aae"); // Not done
		}
	};
	public CompletableFuture<MRefList_BH> BH_Tb_Screening(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Tb_Screening())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_TB_SCREENING_UUIDS_BY_VALUE.get(entity.getBH_Tb_Screening()));
	}


	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public CompletableFuture<MBHVisit> BH_Visit(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Visit_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHVisit> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_VisitDataLoader.DATALOADER_BH_Visit_BY_ID);
		return dataLoader.load(entity.getBH_Visit_ID());
	}

	public Boolean BH_Vsc_Btl(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Vsc_Btl();
	}

	public static Map<String, String> BH_VSC_GIVEN_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("yes", "5b43d8bf-efe6-4588-bb8c-00a746889036"); // Yes
			put("no", "6f78e402-6989-4f3e-90df-8fa553b9ab7a"); // No
		}
	};
	public CompletableFuture<MRefList_BH> BH_Vsc_Given(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Vsc_Given())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_VSC_GIVEN_UUIDS_BY_VALUE.get(entity.getBH_Vsc_Given()));
	}

	public Boolean BH_Vsc_Vasectomy(MBHVisitFamilyPlanning entity, DataFetchingEnvironment environment) {
		return entity.isBH_Vsc_Vasectomy();
	}

}
