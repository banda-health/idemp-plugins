package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.MResourceAssignment;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ResourceAssignmentInput extends MResourceAssignment implements I_S_ResourceAssignmentInput {

	 private I_AD_OrgInput AD_Org;
	 private I_S_ResourceInput S_Resource;

	/**
	 * Standard constructor
	 */
	public X_S_ResourceAssignmentInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}
	/**
	 * Set Assign From.
	 *
	 * @param AssignDateFrom Assign resource from
	 */
	public void setAssignDateFrom(Timestamp AssignDateFrom) {
		if (get_ID() == 0) {
			super.setAssignDateFrom(AssignDateFrom);
		}
	}
	/**
	 * Set Assign To.
	 *
	 * @param AssignDateTo Assign resource until
	 */
	public void setAssignDateTo(Timestamp AssignDateTo) {
		if (get_ID() == 0) {
			super.setAssignDateTo(AssignDateTo);
		}
	}
	/**
	 * Set Active.
	 *
	 * @param IsActive The record is active in the system
	 */
	public void setIsActive(boolean IsActive) {
		if (get_ID() == 0) {
			super.setIsActive(IsActive);
		}
	}
	/**
	 * Set Confirmed.
	 *
	 * @param IsConfirmed Assignment is confirmed
	 */
	public void setIsConfirmed(boolean IsConfirmed) {
		if (get_ID() == 0) {
			super.setIsConfirmed(IsConfirmed);
		}
	}
	/**
	 * Set Quantity.
	 *
	 * @param Qty Quantity
	 */
	public void setQty(BigDecimal Qty) {
		if (get_ID() == 0) {
			super.setQty(Qty);
		}
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	public void setS_Resource(I_S_ResourceInput S_Resource) {
		this.S_Resource = S_Resource;
		MResource foreignEntity;
		if (get_ID() == 0 &&S_Resource != null &&
				(foreignEntity = new Query(getCtx(), MResource.Table_Name, MResource.COLUMNNAME_S_Resource_UU + "=?", get_TrxName())
						.setParameters(S_Resource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setS_Resource_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public I_S_ResourceInput getS_Resource() {
		return S_Resource;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setS_ResourceAssignment_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getS_ResourceAssignment_UU();
	}
}
