package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.MResourceAssignment;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_ResourceAssignmentInput extends MResourceAssignment implements I_S_ResourceAssignmentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mS_Resource;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The S_ResourceAssignment_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_S_ResourceAssignmentInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
	@JsonProperty("AssignDateFrom")
	public void setAssignDateFromFromJson(Timestamp AssignDateFrom) {
		if (get_ID() == 0) {
			super.setAssignDateFrom(AssignDateFrom);
		}
	}
	/**
	 * Set Assign To.
	 *
	 * @param AssignDateTo Assign resource until
	 */
	@JsonProperty("AssignDateTo")
	public void setAssignDateToFromJson(Timestamp AssignDateTo) {
		if (get_ID() == 0) {
			super.setAssignDateTo(AssignDateTo);
		}
	}
	/**
	 * Set Confirmed.
	 *
	 * @param IsConfirmed Assignment is confirmed
	 */
	@JsonProperty("IsConfirmed")
	public void setIsConfirmedFromJson(boolean IsConfirmed) {
		if (get_ID() == 0) {
			super.setIsConfirmed(IsConfirmed);
		}
	}
	/**
	 * Set Quantity.
	 *
	 * @param Qty Quantity
	 */
	@JsonProperty("Qty")
	public void setQtyFromJson(BigDecimal Qty) {
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
		if (get_ID() != 0) {
			return;
		}
		if (S_Resource != null) {
			// Since an entity was passed, make sure it's in the DB
			MResource foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "S_Resource", "S_Resource_UU=?", get_TrxName())
							.setParameters(S_Resource.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setS_Resource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_Resource with UU " + S_Resource.getUU());
			}
		} else {
			this.setS_Resource_ID(0);
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
	@JsonProperty("S_ResourceAssignment_ID")
	public void setS_ResourceAssignment_IDFromJson(int S_ResourceAssignment_ID) {
		if (get_ID() == 0) {
			super.setS_ResourceAssignment_ID(S_ResourceAssignment_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setS_ResourceAssignment_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getS_ResourceAssignment_UU();
	}
}
