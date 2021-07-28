package org.bandahealth.idempiere.rest.repository;

import org.compiere.model.MRefList;
import org.compiere.model.MReference;
import org.compiere.model.MValRule;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ReferenceListRepository extends BaseRepository<MRefList> {

	public final static String PATIENT_TYPE = "BH_PatientType";
	public final static String ORDER_PAYMENT_TYPE = "C_Payment Tender Type";
	public final static String INVOICE_PAYMENT_TYPE = "_Payment Rule";
	public final static String NHIF_TYPE = "BH_NHIFTypeRef";
	public final static String NHIF_RELATIONSHIP = "BH_NHIF_Relationship_Choices";
	public final static String REFERRAL_DROPDOWN = "BH_Referral_Dropdown";
	public final static String PAYMENT_TYPE_LIMIT = "C_Payment Tender Type Limit";
	public final static String DOCUMENT_STATUS = "_Document Status";
	public final static String PRODUCT_CATEGORY_TYPE = "BH Product Category Type";

	public Map<String, MRefList> getOrderPaymentType(Set<String> referenceValues) {
		return getMappedTypes(ORDER_PAYMENT_TYPE, referenceValues);
	}

	public Map<String, MRefList> getPatientType(Set<String> referenceValues) {
		return getMappedTypes(PATIENT_TYPE, referenceValues);
	}

	public Map<String, MRefList> getReferral(Set<String> referenceValues) {
		return getMappedTypes(REFERRAL_DROPDOWN, referenceValues);
	}

	public Map<String, MRefList> getInvoicePaymentType(Set<String> referenceValues) {
		return getMappedTypes(INVOICE_PAYMENT_TYPE, referenceValues);
	}

	public Map<String, MRefList> getNhifType(Set<String> referenceValues) {
		return getMappedTypes(NHIF_TYPE, referenceValues);
	}

	public Map<String, MRefList> getNhifRelationship(Set<String> referenceValues) {
		return getMappedTypes(NHIF_RELATIONSHIP, referenceValues);
	}

	public Map<String, MRefList> getDocumentStatus(Set<String> referenceValues) {
		return getMappedTypes(DOCUMENT_STATUS, referenceValues);
	}

	public Map<String, MRefList> getProductCategoryType(Set<String> referenceValues) {
		return getMappedTypes(PRODUCT_CATEGORY_TYPE, referenceValues);
	}

	private Map<String, MRefList> getMappedTypes(String referenceName, Set<String> referenceValues) {
		Map<String, MRefList> groupedTypes =
				getTypes(referenceName, referenceValues).stream().collect(Collectors.toMap(MRefList::getValue, ref -> ref));
		return referenceValues.stream().collect(HashMap::new, (m, v) -> m.put(v, groupedTypes.get(v)), HashMap::putAll);
	}

	public List<MRefList> getTypes(String referenceName) {
		return getTypes(referenceName, null);
	}

	/**
	 * Get Reference List from MRefList.Table_Name
	 *
	 * @param referenceName   A reference name, defined as a static on this class
	 * @param referenceValues A list of values to fetch data for
	 * @return The reference list data
	 */
	private List<MRefList> getTypes(String referenceName, Set<String> referenceValues) {
		List<Object> parameters = new ArrayList<>();

		String whereClause = MReference.Table_Name + "." + MReference.COLUMNNAME_Name + "=? ";
		parameters.add(referenceName);

		if (referenceName.equalsIgnoreCase(ORDER_PAYMENT_TYPE)) {
			// get payment type limits..
			MValRule valRule = new Query(Env.getCtx(), MValRule.Table_Name, MValRule.COLUMNNAME_Name + "=?", null)
					.setParameters(PAYMENT_TYPE_LIMIT).setOnlyActiveRecords(true).setNoVirtualColumn(true).first();
			if (valRule != null) {
				whereClause += " AND " + valRule.getCode();
			}
		}

		List<MRefList> referenceList = new Query(Env.getCtx(), MRefList.Table_Name, whereClause, null)
				.addJoinClause("JOIN " + MReference.Table_Name + " ON " + MReference.Table_Name + "."
						+ MReference.COLUMNNAME_AD_Reference_ID + "=" + MRefList.Table_Name + "."
						+ MRefList.COLUMNNAME_AD_Reference_ID)
				.setParameters(parameters).setOnlyActiveRecords(true).setNoVirtualColumn(true)
				.list();
		if (referenceValues == null) {
			return referenceList;
		}
		return referenceList.stream().filter(referenceListItem -> referenceValues.contains(referenceListItem.getValue()))
				.collect(Collectors.toList());
	}

	@Override
	protected MRefList createModelInstance() {
		return new MRefList(Env.getCtx(), 0, null);
	}

	@Override
	public MRefList mapInputModelToModel(MRefList entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected boolean shouldUseContextClientId() {
		return false;
	}
}
