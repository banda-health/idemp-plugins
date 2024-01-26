package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRfQLine;
import org.compiere.model.MRfQResponse;
import org.compiere.model.MRfQResponseLine;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_RfQResponseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQResponseLineInput extends MRfQResponseLine implements I_C_RfQResponseLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RfQLine;
	private ForeignEntityInput mC_RfQResponse;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_RfQResponseLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RfQResponseLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_RfQLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MRfQLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RfQLine", "C_RfQLine_UU=?", get_TrxName())
							.setParameters(C_RfQLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_RfQLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RfQLine with UUID " + C_RfQLine.getUUID());
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
	 * Set RfQ Response.
	 *
	 * @param C_RfQResponse Request for Quotation Response from a potential Vendor
	 */
	@JsonProperty("C_RfQResponse")
	public void setC_RfQResponseInput(ForeignEntityInput C_RfQResponse) {
		this.mC_RfQResponse = C_RfQResponse;
		if (get_ID() != 0) {
			return;
		}
		if (C_RfQResponse != null) {
			// Since an entity was passed, make sure it's in the DB
			MRfQResponse foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RfQResponse", "C_RfQResponse_UU=?", get_TrxName())
							.setParameters(C_RfQResponse.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_RfQResponse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RfQResponse with UUID " + C_RfQResponse.getUUID());
			}
		} else {
			this.setC_RfQResponse_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_RfQResponseLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_RfQResponseLine_UU();
	}
}
