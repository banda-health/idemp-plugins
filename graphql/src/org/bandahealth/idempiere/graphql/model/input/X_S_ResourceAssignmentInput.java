package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.sql.Timestamp;
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

	 private I_AD_OrgInput mAD_Org;
	 private I_S_ResourceInput mS_Resource;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_S_ResourceAssignmentInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
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
	@JsonProperty("S_Resource")
	public void setS_ResourceInput(I_S_ResourceInput S_Resource) {
		this.mS_Resource = S_Resource;
		MResource foreignEntity;
		if (get_ID() == 0 &&S_Resource != null &&
				(foreignEntity = new Query(getCtx(), MResource.Table_Name, MResource.COLUMNNAME_S_Resource_UU + "=?", get_TrxName())
						.setParameters(S_Resource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setS_Resource_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	@JsonProperty("S_Resource")
	public I_S_ResourceInput S_Resource() {
		return mS_Resource;
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
