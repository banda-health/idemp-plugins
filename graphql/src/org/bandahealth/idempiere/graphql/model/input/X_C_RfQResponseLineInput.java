package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRfQLine;
import org.compiere.model.MRfQResponse;
import org.compiere.model.MRfQResponseLine;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_RfQResponseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQResponseLineInput extends MRfQResponseLine implements I_C_RfQResponseLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RfQLine;
	private ForeignEntityInput mC_RfQResponse;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_RfQResponseLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRfQResponseLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set RfQ Line.
	 *
	 * @param C_RfQLine Request for Quotation Line
	 */
	@JsonProperty("C_RfQLine")
	public void setC_RfQLineInput(ForeignEntityInput C_RfQLine) {
		this.mC_RfQLine = C_RfQLine;
		MRfQLine foreignEntity;
		if (get_ID() == 0 && C_RfQLine != null &&
				(foreignEntity = new Query(getCtx(), "C_RfQLine", "C_RfQLine_UU=?", get_TrxName())
						.setParameters(C_RfQLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_RfQLine_ID(foreignEntity.get_ID());
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
	 * Set RfQ Response.
	 *
	 * @param C_RfQResponse Request for Quotation Response from a potential Vendor
	 */
	@JsonProperty("C_RfQResponse")
	public void setC_RfQResponseInput(ForeignEntityInput C_RfQResponse) {
		this.mC_RfQResponse = C_RfQResponse;
		MRfQResponse foreignEntity;
		if (get_ID() == 0 && C_RfQResponse != null &&
				(foreignEntity = new Query(getCtx(), "C_RfQResponse", "C_RfQResponse_UU=?", get_TrxName())
						.setParameters(C_RfQResponse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_RfQResponse_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get RfQ Response.
	 *
	 * @return Request for Quotation Response from a potential Vendor
	 */
	@JsonProperty("C_RfQResponse")
	public ForeignEntityInput C_RfQResponse() {
		return mC_RfQResponse;
	}
	/**
	 * Set RfQ Response Line.
	 *
	 * @param C_RfQResponseLine_ID Request for Quotation Response Line
	 */

	public void setC_RfQResponseLine_ID(int C_RfQResponseLine_ID) {
		if (get_ID() == 0) {
			super.setC_RfQResponseLine_ID(C_RfQResponseLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_RfQResponseLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_RfQResponseLine_UU();
	}
}
