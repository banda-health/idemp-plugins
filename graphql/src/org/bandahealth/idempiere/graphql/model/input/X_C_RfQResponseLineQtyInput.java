package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRfQLineQty;
import org.compiere.model.MRfQResponseLine;
import org.compiere.model.MRfQResponseLineQty;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_RfQResponseLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQResponseLineQtyInput extends MRfQResponseLineQty implements I_C_RfQResponseLineQtyInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RfQLineQty;
	private ForeignEntityInput mC_RfQResponseLine;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_RfQResponseLineQtyInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRfQResponseLineQty(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set RfQ Line Quantity.
	 *
	 * @param C_RfQLineQty Request for Quotation Line Quantity
	 */
	@JsonProperty("C_RfQLineQty")
	public void setC_RfQLineQtyInput(ForeignEntityInput C_RfQLineQty) {
		this.mC_RfQLineQty = C_RfQLineQty;
		MRfQLineQty foreignEntity;
		if (get_ID() == 0 && C_RfQLineQty != null &&
				(foreignEntity = new Query(getCtx(), "C_RfQLineQty", "C_RfQLineQty_UU=?", get_TrxName())
						.setParameters(C_RfQLineQty.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_RfQLineQty_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get RfQ Line Quantity.
	 *
	 * @return Request for Quotation Line Quantity
	 */
	@JsonProperty("C_RfQLineQty")
	public ForeignEntityInput C_RfQLineQty() {
		return mC_RfQLineQty;
	}

	/**
	 * Set RfQ Response Line.
	 *
	 * @param C_RfQResponseLine Request for Quotation Response Line
	 */
	@JsonProperty("C_RfQResponseLine")
	public void setC_RfQResponseLineInput(ForeignEntityInput C_RfQResponseLine) {
		this.mC_RfQResponseLine = C_RfQResponseLine;
		MRfQResponseLine foreignEntity;
		if (get_ID() == 0 && C_RfQResponseLine != null &&
				(foreignEntity = new Query(getCtx(), "C_RfQResponseLine", "C_RfQResponseLine_UU=?", get_TrxName())
						.setParameters(C_RfQResponseLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_RfQResponseLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get RfQ Response Line.
	 *
	 * @return Request for Quotation Response Line
	 */
	@JsonProperty("C_RfQResponseLine")
	public ForeignEntityInput C_RfQResponseLine() {
		return mC_RfQResponseLine;
	}
	/**
	 * Set RfQ Response Line Qty.
	 *
	 * @param C_RfQResponseLineQty_ID Request for Quotation Response Line Quantity
	 */

	public void setC_RfQResponseLineQty_ID(int C_RfQResponseLineQty_ID) {
		if (get_ID() == 0) {
			super.setC_RfQResponseLineQty_ID(C_RfQResponseLineQty_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_RfQResponseLineQty_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_RfQResponseLineQty_UU();
	}
}
