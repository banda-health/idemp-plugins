package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRfQLine;
import org.compiere.model.MRfQLineQty;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_RfQLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RfQLineQtyInput extends MRfQLineQty implements I_C_RfQLineQtyInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RfQLine;
	private ForeignEntityInput mC_UOM;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_RfQLineQty_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RfQLineQtyInput(@JsonProperty("UU") String UU) {
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
	 * Set RfQ Line.
	 *
	 * @param C_RfQLine Request for Quotation Line
	 */
	@JsonProperty("C_RfQLine")
	public void setC_RfQLineInput(ForeignEntityInput C_RfQLine) {
		this.mC_RfQLine = C_RfQLine;
		if (get_ID() != 0) {
			return;
		}
		if (C_RfQLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MRfQLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RfQLine", "C_RfQLine_UU=?", get_TrxName())
							.setParameters(C_RfQLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_RfQLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RfQLine with UU " + C_RfQLine.getUU());
			}
		} else {
			this.setC_RfQLine_ID(0);
		}
	}

	/**
	 * Get RfQ Line.
	 *
	 * @return Request for Quotation Line
	 */
	@JsonProperty("C_RfQLine")
	public ForeignEntityInput C_RfQLine() {
		return mC_RfQLine;
	}
	/**
	 * Set RfQ Line Quantity.
	 *
	 * @param C_RfQLineQty_ID Request for Quotation Line Quantity
	 */
	@JsonProperty("C_RfQLineQty_ID")
	public void setC_RfQLineQty_IDFromJson(int C_RfQLineQty_ID) {
		if (get_ID() == 0) {
			super.setC_RfQLineQty_ID(C_RfQLineQty_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_RfQLineQty_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_RfQLineQty_UU();
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(ForeignEntityInput C_UOM) {
		this.mC_UOM = C_UOM;
		if (C_UOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_UOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UU " + C_UOM.getUU());
			}
		} else {
			this.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public ForeignEntityInput C_UOM() {
		return mC_UOM;
	}
}
