package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_ChargeType_DocType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_ChargeType_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ChargeType_DocTypeInput extends X_C_ChargeType_DocType implements I_C_ChargeType_DocTypeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ChargeType;
	private ForeignEntityInput mC_DocType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_ChargeType_DocType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_ChargeType_DocTypeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_ChargeType_DocType(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_ChargeType_DocType_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (C_ChargeType != null) {
			// Since an entity was passed, make sure it's in the DB
			MChargeType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ChargeType", "C_ChargeType_UU=?", get_TrxName())
							.setParameters(C_ChargeType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ChargeType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ChargeType with UUID " + C_ChargeType.getUUID());
			}
		} else {
			this.setC_ChargeType_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_DocType != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocType.getUUID());
			}
		} else {
			this.setC_DocType_ID(0);
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
