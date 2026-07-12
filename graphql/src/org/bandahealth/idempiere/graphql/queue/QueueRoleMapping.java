package org.bandahealth.idempiere.graphql.queue;

import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Maps a logged-in role to the visit-queue channel(s) it's allowed to receive real-time
 * queue-arrival events for. The channel is derived server-side from the role (never trusted from
 * the client) since the event payload includes patient name.
 * <p>
 * Mirrors greenlight-client's src/hooks/useMyQueuedVisitValues.ts
 * (processStageFilterUUByRoleUU / canViewMyQueue) - keep both in sync when process stages or role
 * mappings change.
 * WARNING: risk of running out of sync with iDempiere role/ad_ref_list migrations - same caveat
 * already accepted client-side.
 */
public class QueueRoleMapping {
	private static final Map<String, String> PROCESS_STAGE_VALUE_BY_ROLE_UU = new HashMap<>() {
		{
			put("3665260a-9448-4816-8af7-5e3f93a16ab7", "tocashier"); // Cashier Lite
			put("ee008abc-2c16-4230-b48c-b1f5577ea270", "tocashier"); // Cashier/Registration Advanced
			put("09eb7fc8-9cc5-44b0-9d14-15258a066038", "tocashier"); // Cashier/Registration Basic
			put("c0e72e44-9cc9-4a0a-b5cd-6cc923678c1a", "tocashier"); // Cashier/Registration Basic Plus
			put("c54253cf-c86b-4aaa-b472-ed8880635c62", "toclinician"); // Clinician/Nurse Advanced
			put("98617c31-55ff-48f9-bd44-253ef323d960", "toclinician"); // Clinician/Nurse Basic
			put("ec17fee0-a53a-4dbb-b946-423ce14880eb", "topharmacy"); // Inventory/Pharmacy Advanced
			put("a1618fd6-e1ab-4e41-a08d-854229cd5971", "topharmacy"); // Inventory/Pharmacy Basic
			put("097feff0-3aa6-41fe-bf76-936b03859846", "tolab"); // Lab/Radiology Advanced
			put("17ccea57-1131-4d51-83ca-1824182e4493", "tolab"); // Lab/Radiology Basic
			put("ae618e24-a47a-40cc-bb5c-8dca64d86daf", "totriage"); // Triage
		}
	};

	// Only Clinician/Nurse Basic gets visits targeted directly at them (mirrors the
	// `isClinician`/`clinicianFilterUU` split in useMyQueuedVisitValues.ts - Advanced clinicians
	// see the general pool for every clinician-stage visit instead)
	private static final String CLINICIAN_SPECIFIC_ROLE_UU = "98617c31-55ff-48f9-bd44-253ef323d960";

	public static final String CLINICIAN_PROCESS_STAGE_VALUE = "toclinician";

	private QueueRoleMapping() {
	}

	/**
	 * Resolve the process-stage value (e.g. "totriage") a role should receive queue-arrival events
	 * for. A role only qualifies if exactly one of its included roles maps to a process stage - same
	 * "exactly one" rule as canViewMyQueue client-side, to avoid ambiguous queue membership.
	 *
	 * @return the process-stage value, or null if this isn't a single, unambiguous queue-visible role
	 */
	public static String getProcessStageValueForRole(Properties ctx, int AD_Role_ID, String trxName) {
		String matchedProcessStageValue = null;
		for (MRoleIncluded includedRole : getIncludedRoles(ctx, AD_Role_ID, trxName)) {
			MRole role = MRole.get(ctx, includedRole.getIncluded_Role_ID());
			String processStageValue = PROCESS_STAGE_VALUE_BY_ROLE_UU.get(role.getAD_Role_UU());
			if (processStageValue != null) {
				if (matchedProcessStageValue != null) {
					return null;
				}
				matchedProcessStageValue = processStageValue;
			}
		}
		return matchedProcessStageValue;
	}

	/**
	 * @return true if this role is the specific "assigned clinician" role (Clinician/Nurse Basic)
	 * rather than the general clinician pool
	 */
	public static boolean isClinicianSpecificRole(Properties ctx, int AD_Role_ID, String trxName) {
		for (MRoleIncluded includedRole : getIncludedRoles(ctx, AD_Role_ID, trxName)) {
			MRole role = MRole.get(ctx, includedRole.getIncluded_Role_ID());
			if (CLINICIAN_SPECIFIC_ROLE_UU.equals(role.getAD_Role_UU())) {
				return true;
			}
		}
		return false;
	}

	private static List<MRoleIncluded> getIncludedRoles(Properties ctx, int AD_Role_ID, String trxName) {
		return new Query(ctx, MRoleIncluded.Table_Name, "AD_Role_ID=?", trxName).setParameters(AD_Role_ID).list();
	}
}
