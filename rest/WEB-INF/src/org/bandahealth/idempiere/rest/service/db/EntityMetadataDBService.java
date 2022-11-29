package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.rest.model.BaseEntity;
import org.bandahealth.idempiere.rest.model.EntityMetadata;
import org.bandahealth.idempiere.rest.model.NHIFRelationship;
import org.bandahealth.idempiere.rest.model.NHIFType;
import org.bandahealth.idempiere.rest.model.PatientType;
import org.bandahealth.idempiere.rest.model.PaymentType;
import org.bandahealth.idempiere.rest.model.ProcessStage;
import org.bandahealth.idempiere.rest.model.ReferenceList;
import org.bandahealth.idempiere.rest.model.Referral;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MRefList;
import org.compiere.model.MReference;
import org.compiere.model.MValRule;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.springframework.stereotype.Component;

/**
 * Retrieve All Metadata data i.e entity types (e.g nhif,patient,payment types)
 *
 * @author andrew
 */
@Component
public class EntityMetadataDBService {

	public final static String PATIENT_TYPE = "BH_PatientType";
	public final static String ORDER_PAYMENT_TYPE = "C_Payment Tender Type";
	public final static String NHIF_TYPE = "BH_NHIFTypeRef";
	public final static String NHIF_RELATIONSHIP = "BH_NHIF_Relationship_Choices";
	public final static String REFERRAL_DROPDOWN = "BH_Referral_Dropdown";
	public final static String PAYMENT_TYPE_LIMIT = "C_Payment Tender Type Limit";
	public final static String DOCUMENT_STATUS = "_Document Status";
	public final static String PRODUCT_CATEGORY_TYPE = "BH Product Category Type";
	public final static String PROCESS_STAGE = "BH_Process_Stage";
	private final CLogger logger = CLogger.getCLogger(EntityMetadataDBService.class);

	public EntityMetadata getAll() {
		EntityMetadata metadata = new EntityMetadata();

		// retrieve patient types
		for (MRefList instance : getTypes(PATIENT_TYPE)) {
			metadata.addPatientType(new PatientType(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve nhif types
		for (MRefList instance : getTypes(NHIF_TYPE)) {
			metadata.addNHIFType(new NHIFType(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve nhif relationships
		for (MRefList instance : getTypes(NHIF_RELATIONSHIP)) {
			metadata.addNHIFRelationship(new NHIFRelationship(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve referrals
		for (MRefList instance : getTypes(REFERRAL_DROPDOWN)) {
			metadata.addReferral(new Referral(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getValue()));
		}

		// retrieve product category types
		for (MRefList instance : getTypes(PRODUCT_CATEGORY_TYPE)) {
			metadata.addProductCategoryType(new BaseEntity(instance.getAD_Client_ID(), instance.getAD_Org_ID(),
					instance.getAD_Ref_List_UU(), instance.isActive(), DateUtil.parse(instance.getCreated()),
					instance.getCreatedBy(), instance.getName(), instance.getDescription(), instance.getValue()));
		}

		// retrieve process stage
		for (MRefList instance : getTypes(PROCESS_STAGE)) {
			metadata.addProcessStageList(new ProcessStage(instance));
		}

		// retrieve document statuses
		metadata.getDocumentStatuses()
				.addAll(getTypes(DOCUMENT_STATUS).stream().map(ReferenceList::new).collect(Collectors.toList()));

		return metadata;
	}

	/**
	 * Get Reference List from MRefList.Table_Name
	 *
	 * @param referenceName
	 * @param referenceValue
	 * @return
	 */
	private List<MRefList> getTypes(String referenceName, String referenceValue) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(referenceName);

		String whereClause = MReference.Table_Name + "." + MReference.COLUMNNAME_Name + "=? ";

		if (referenceValue != null) {
			whereClause += " AND " + MRefList.COLUMNNAME_Value + "=?";
			parameters.add(referenceValue);
		}

		if (referenceName.equalsIgnoreCase(ORDER_PAYMENT_TYPE)) {
			// get payment type limits..
			MValRule valRule = new Query(Env.getCtx(), MValRule.Table_Name, MValRule.COLUMNNAME_Name + "=?", null)
					.setParameters(PAYMENT_TYPE_LIMIT).setOnlyActiveRecords(true).first();
			if (valRule != null) {
				whereClause += " AND " + valRule.getCode();
			}
		}

		List<MRefList> referenceLists = new Query(Env.getCtx(), MRefList.Table_Name, whereClause, null)
				.addJoinClause("JOIN " + MReference.Table_Name + " ON " + MReference.Table_Name + "."
						+ MReference.COLUMNNAME_AD_Reference_ID + "=" + MRefList.Table_Name + "."
						+ MRefList.COLUMNNAME_AD_Reference_ID)
				.setParameters(parameters).setOnlyActiveRecords(true).list();
		if (!Language.isBaseLanguage(Env.getAD_Language(Env.getCtx()))) {
			Map<Integer, MRefList> refListMap = referenceLists.stream().collect(
					Collectors.toMap(MRefList::getAD_Ref_List_ID, v -> v));

			// Setup translation fetching SQL
			List<Object> translationParameters = new ArrayList<>();
			String translationWhereClause = QueryUtil.getWhereClauseAndSetParametersForSet(
					referenceLists.stream().map(MRefList::getAD_Ref_List_ID).collect(Collectors.toSet()), translationParameters);
			String sql = "SELECT " + MRefList.COLUMNNAME_AD_Ref_List_ID + "," + MRefList.COLUMNNAME_Name + "," +
					MRefList.COLUMNNAME_Description + " FROM " + MRefList.Table_Name + "_Trl WHERE " +
					MRefList.COLUMNNAME_AD_Ref_List_ID + " IN(" + translationWhereClause + ")" + " AND " +
					MLanguage.COLUMNNAME_AD_Language + "=?";
			translationParameters.add(Env.getLanguage(Env.getCtx()).getAD_Language());

			// Fetch translations
			SqlUtil.executeQuery(sql, translationParameters, null, resultSet -> {
				try {
					MRefList referenceListToTranslate = refListMap.get(resultSet.getInt(1));
					ModelUtil.setPropertyIfPresent(resultSet.getString(2), referenceListToTranslate::setName);
					ModelUtil.setPropertyIfPresent(resultSet.getString(3), referenceListToTranslate::setDescription);
				} catch (Exception ex) {
					logger.warning("Error processing reference list translations: " + ex.getMessage());
				}
			});
			referenceLists = new ArrayList<>(refListMap.values());
		}
		return referenceLists;
	}

	private List<MRefList> getTypes(String referenceName) {
		return getTypes(referenceName, null);
	}

	public String getReferenceNameByValue(String referenceName, String referenceValue) {
		List<MRefList> refList = getTypes(referenceName, referenceValue);

		if (refList != null && refList.size() > 0) {
			return refList.get(0).getName();
		}

		return null;
	}
}
