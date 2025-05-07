package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MMovementConfirm;
import org.compiere.model.MMovementLine;
import org.compiere.model.MMovementLineConfirm;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_MovementLineConfirmInput extends MMovementLineConfirm implements I_M_MovementLineConfirmInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_InventoryLine;
	private ForeignEntityInput mM_MovementConfirm;
	private ForeignEntityInput mM_MovementLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_MovementLineConfirm_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_MovementLineConfirmInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Phys.Inventory Line.
	 *
	 * @param M_InventoryLine Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine")
	public void setM_InventoryLineInput(ForeignEntityInput M_InventoryLine) {
		this.mM_InventoryLine = M_InventoryLine;
		if (M_InventoryLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInventoryLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
							.setParameters(M_InventoryLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_InventoryLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InventoryLine with UU " + M_InventoryLine.getUU());
			}
		} else {
			this.setM_InventoryLine_ID(0);
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
		if (!is_new()) {
			return;
		}
		if (M_MovementConfirm != null) {
			// Since an entity was passed, make sure it's in the DB
			MMovementConfirm foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_MovementConfirm", "M_MovementConfirm_UU=?", get_TrxName())
							.setParameters(M_MovementConfirm.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_MovementConfirm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_MovementConfirm with UU " + M_MovementConfirm.getUU());
			}
		} else {
			this.setM_MovementConfirm_ID(0);
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
		if (M_MovementLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MMovementLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_MovementLine", "M_MovementLine_UU=?", get_TrxName())
							.setParameters(M_MovementLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_MovementLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_MovementLine with UU " + M_MovementLine.getUU());
			}
		} else {
			this.setM_MovementLine_ID(0);
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
	@JsonProperty("M_MovementLineConfirm_ID")
	public void setM_MovementLineConfirm_IDFromJson(int M_MovementLineConfirm_ID) {
		if (get_ID() == 0) {
			super.setM_MovementLineConfirm_ID(M_MovementLineConfirm_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_MovementLineConfirm_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_MovementLineConfirm_UU();
	}
}
