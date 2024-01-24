package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MJournalGenerator;
import org.compiere.model.MJournalGeneratorLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for GL_JournalGeneratorLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_JournalGeneratorLineInput extends MJournalGeneratorLine implements I_GL_JournalGeneratorLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_ElementValueCR;
	private ForeignEntityInput mC_ElementValueDR;
	private ForeignEntityInput mGL_JournalGenerator;
	private I_AD_Ref_ListInput mBPDimensionType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_GL_JournalGeneratorLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MJournalGeneratorLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Type of BP Dimension.
	 *
	 * @param BPDimensionType Type of BP Dimension
	 */
	@JsonProperty("BPDimensionType")
	public void setBPDimensionTypeInput(I_AD_Ref_ListInput BPDimensionType) {
		this.mBPDimensionType = BPDimensionType;
		MRefList_BH foreignEntity;
		if (BPDimensionType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BPDimensionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBPDimensionType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput BPDimensionType() {
		return mBPDimensionType;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
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
		MElementValue foreignEntity;
		if (C_ElementValueCR != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(C_ElementValueCR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ElementValueCR_ID(foreignEntity.get_ID());
		} else {
			super.setC_ElementValueCR_ID(0);
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
		MElementValue foreignEntity;
		if (C_ElementValueDR != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(C_ElementValueDR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ElementValueDR_ID(foreignEntity.get_ID());
		} else {
			super.setC_ElementValueDR_ID(0);
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
		MJournalGenerator foreignEntity;
		if (get_ID() == 0 && GL_JournalGenerator != null &&
				(foreignEntity = new Query(getCtx(), "GL_JournalGenerator", "GL_JournalGenerator_UU=?", get_TrxName())
						.setParameters(GL_JournalGenerator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_JournalGenerator_ID(foreignEntity.get_ID());
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

	public void setGL_JournalGeneratorLine_ID(int GL_JournalGeneratorLine_ID) {
		if (get_ID() == 0) {
			super.setGL_JournalGeneratorLine_ID(GL_JournalGeneratorLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setGL_JournalGeneratorLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getGL_JournalGeneratorLine_UU();
	}
}
