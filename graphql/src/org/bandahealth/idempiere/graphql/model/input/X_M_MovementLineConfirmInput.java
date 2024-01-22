package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MMovementConfirm;
import org.compiere.model.MMovementLineConfirm;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_MovementLineConfirmInput extends MMovementLineConfirm implements I_M_MovementLineConfirmInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_InventoryLine;
	private ForeignEntityInput mM_MovementConfirm;
	private ForeignEntityInput mM_MovementLine;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_MovementLineConfirmInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MMovementLineConfirm(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Phys.Inventory Line.
	 *
	 * @param M_InventoryLine Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine")
	public void setM_InventoryLineInput(ForeignEntityInput M_InventoryLine) {
		this.mM_InventoryLine = M_InventoryLine;
		MInventoryLine_BH foreignEntity;
		if (M_InventoryLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
						.setParameters(M_InventoryLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InventoryLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_InventoryLine_ID(0);
		}
	}

	/**
	 * Get Phys.Inventory Line.
	 *
	 * @return Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine")
	public ForeignEntityInput M_InventoryLine() {
		return mM_InventoryLine;
	}

	/**
	 * Set Move Confirm.
	 *
	 * @param M_MovementConfirm Inventory Move Confirmation
	 */
	@JsonProperty("M_MovementConfirm")
	public void setM_MovementConfirmInput(ForeignEntityInput M_MovementConfirm) {
		this.mM_MovementConfirm = M_MovementConfirm;
		MMovementConfirm foreignEntity;
		if (get_ID() == 0 && M_MovementConfirm != null &&
				(foreignEntity = new Query(getCtx(), "M_MovementConfirm", "M_MovementConfirm_UU=?", get_TrxName())
						.setParameters(M_MovementConfirm.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_MovementConfirm_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Move Confirm.
	 *
	 * @return Inventory Move Confirmation
	 */
	@JsonProperty("M_MovementConfirm")
	public ForeignEntityInput M_MovementConfirm() {
		return mM_MovementConfirm;
	}

	/**
	 * Set Move Line.
	 *
	 * @param M_MovementLine Inventory Move document Line
	 */
	@JsonProperty("M_MovementLine")
	public void setM_MovementLineInput(ForeignEntityInput M_MovementLine) {
		this.mM_MovementLine = M_MovementLine;
		MMovementLine_BH foreignEntity;
		if (M_MovementLine != null &&
				(foreignEntity = new Query(getCtx(), "M_MovementLine", "M_MovementLine_UU=?", get_TrxName())
						.setParameters(M_MovementLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_MovementLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_MovementLine_ID(0);
		}
	}

	/**
	 * Get Move Line.
	 *
	 * @return Inventory Move document Line
	 */
	@JsonProperty("M_MovementLine")
	public ForeignEntityInput M_MovementLine() {
		return mM_MovementLine;
	}
	/**
	 * Set Move Line Confirm.
	 *
	 * @param M_MovementLineConfirm_ID Inventory Move Line Confirmation
	 */

	public void setM_MovementLineConfirm_ID(int M_MovementLineConfirm_ID) {
		if (get_ID() == 0) {
			super.setM_MovementLineConfirm_ID(M_MovementLineConfirm_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_MovementLineConfirm_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_MovementLineConfirm_UU();
	}
}
