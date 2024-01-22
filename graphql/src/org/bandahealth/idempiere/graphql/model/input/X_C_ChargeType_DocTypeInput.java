package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_ChargeType_DocType;

import java.sql.ResultSet;

/**
 * Generated Model for C_ChargeType_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ChargeType_DocTypeInput extends X_C_ChargeType_DocType implements I_C_ChargeType_DocTypeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ChargeType;
	private ForeignEntityInput mC_DocType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ChargeType_DocTypeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_ChargeType_DocType(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ChargeType_DocType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ChargeType_DocType_UU();
	}

	/**
	 * Set Charge Type.
	 *
	 * @param C_ChargeType Charge Type
	 */
	@JsonProperty("C_ChargeType")
	public void setC_ChargeTypeInput(ForeignEntityInput C_ChargeType) {
		this.mC_ChargeType = C_ChargeType;
		MChargeType_BH foreignEntity;
		if (get_ID() == 0 && C_ChargeType != null &&
				(foreignEntity = new Query(getCtx(), "C_ChargeType", "C_ChargeType_UU=?", get_TrxName())
						.setParameters(C_ChargeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ChargeType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Charge Type.
	 *
	 * @return Charge Type
	 */
	@JsonProperty("C_ChargeType")
	public ForeignEntityInput C_ChargeType() {
		return mC_ChargeType;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (get_ID() == 0 && C_DocType != null &&
				(foreignEntity = new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}
}
