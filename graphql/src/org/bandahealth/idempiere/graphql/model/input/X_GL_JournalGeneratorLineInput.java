package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_GL_JournalGeneratorLineResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MJournalGenerator;
import org.compiere.model.MJournalGeneratorLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for GL_JournalGeneratorLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_JournalGeneratorLineInput extends MJournalGeneratorLine implements I_GL_JournalGeneratorLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBPDimensionType;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_ElementValueCR;
	private ForeignEntityInput mC_ElementValueDR;
	private ForeignEntityInput mGL_JournalGenerator;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The GL_JournalGeneratorLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_GL_JournalGeneratorLineInput(@JsonProperty("UU") String UU) {
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
	 * Set Type of BP Dimension.
	 *
	 * @param BPDimensionType Type of BP Dimension
	 */
	@JsonProperty("BPDimensionType")
	public void setBPDimensionTypeInput(ForeignEntityInput BPDimensionType) {
		this.mBPDimensionType = BPDimensionType;
		if (BPDimensionType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_GL_JournalGeneratorLineResolver.BPDIMENSIONTYPE_UUIDS_BY_VALUE.containsValue(BPDimensionType.getUU())) {
				throw new AdempiereException("The reference list UU of " + BPDimensionType.getUU() +
						" is not in the list defined for the BPDimensionType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BPDimensionType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBPDimensionType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BPDimensionType.getUU());
			}
		} else {
			this.setBPDimensionType(null);
		}
	}

	/**
	 * Get Type of BP Dimension.
	 *
	 * @return Type of BP Dimension
	 */
	@JsonProperty("BPDimensionType")
	public ForeignEntityInput BPDimensionType() {
		return mBPDimensionType;
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Account CR.
	 *
	 * @param C_ElementValueCR Account CR
	 */
	@JsonProperty("C_ElementValueCR")
	public void setC_ElementValueCRInput(ForeignEntityInput C_ElementValueCR) {
		this.mC_ElementValueCR = C_ElementValueCR;
		if (C_ElementValueCR != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(C_ElementValueCR.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ElementValueCR_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + C_ElementValueCR.getUU());
			}
		} else {
			this.setC_ElementValueCR_ID(0);
		}
	}

	/**
	 * Get Account CR.
	 *
	 * @return Account CR
	 */
	@JsonProperty("C_ElementValueCR")
	public ForeignEntityInput C_ElementValueCR() {
		return mC_ElementValueCR;
	}

	/**
	 * Set Account DR.
	 *
	 * @param C_ElementValueDR Account DR
	 */
	@JsonProperty("C_ElementValueDR")
	public void setC_ElementValueDRInput(ForeignEntityInput C_ElementValueDR) {
		this.mC_ElementValueDR = C_ElementValueDR;
		if (C_ElementValueDR != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(C_ElementValueDR.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ElementValueDR_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + C_ElementValueDR.getUU());
			}
		} else {
			this.setC_ElementValueDR_ID(0);
		}
	}

	/**
	 * Get Account DR.
	 *
	 * @return Account DR
	 */
	@JsonProperty("C_ElementValueDR")
	public ForeignEntityInput C_ElementValueDR() {
		return mC_ElementValueDR;
	}

	/**
	 * Set GL Journal Generator.
	 *
	 * @param GL_JournalGenerator GL Journal Generator
	 */
	@JsonProperty("GL_JournalGenerator")
	public void setGL_JournalGeneratorInput(ForeignEntityInput GL_JournalGenerator) {
		this.mGL_JournalGenerator = GL_JournalGenerator;
		if (get_ID() != 0) {
			return;
		}
		if (GL_JournalGenerator != null) {
			// Since an entity was passed, make sure it's in the DB
			MJournalGenerator foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_JournalGenerator", "GL_JournalGenerator_UU=?", get_TrxName())
							.setParameters(GL_JournalGenerator.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGL_JournalGenerator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_JournalGenerator with UU " + GL_JournalGenerator.getUU());
			}
		} else {
			this.setGL_JournalGenerator_ID(0);
		}
	}

	/**
	 * Get GL Journal Generator.
	 *
	 * @return GL Journal Generator
	 */
	@JsonProperty("GL_JournalGenerator")
	public ForeignEntityInput GL_JournalGenerator() {
		return mGL_JournalGenerator;
	}
	/**
	 * Set Generator Line.
	 *
	 * @param GL_JournalGeneratorLine_ID Generator Line
	 */
	@JsonProperty("GL_JournalGeneratorLine_ID")
	public void setGL_JournalGeneratorLine_IDFromJson(int GL_JournalGeneratorLine_ID) {
		if (get_ID() == 0) {
			super.setGL_JournalGeneratorLine_ID(GL_JournalGeneratorLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setGL_JournalGeneratorLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getGL_JournalGeneratorLine_UU();
	}
}
