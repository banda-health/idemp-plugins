package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.MResourceAssignment;
import org.compiere.model.Query;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_ResourceAssignmentInput extends MResourceAssignment implements I_S_ResourceAssignmentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mS_Resource;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_S_ResourceAssignmentInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MResourceAssignment(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_Org() {
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
	public void setS_ResourceInput(ForeignEntityInput S_Resource) {
		this.mS_Resource = S_Resource;
		MResource foreignEntity;
		if (get_ID() == 0 && S_Resource != null &&
				(foreignEntity = new Query(getCtx(), "S_Resource", "S_Resource_UU=?", get_TrxName())
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
	public ForeignEntityInput S_Resource() {
		return mS_Resource;
	}
	/**
	 * Set Resource Assignment.
	 *
	 * @param S_ResourceAssignment_ID Resource Assignment
	 */

	public void setS_ResourceAssignment_ID(int S_ResourceAssignment_ID) {
		if (get_ID() == 0) {
			super.setS_ResourceAssignment_ID(S_ResourceAssignment_ID);
		}
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
