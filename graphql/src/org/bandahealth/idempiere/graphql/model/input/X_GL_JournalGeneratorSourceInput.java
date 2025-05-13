package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MGLCategory;
import org.compiere.model.MJournalGeneratorLine;
import org.compiere.model.MJournalGeneratorSource;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for GL_JournalGeneratorSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_JournalGeneratorSourceInput extends MJournalGeneratorSource implements I_GL_JournalGeneratorSourceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ElementValue;
	private ForeignEntityInput mGL_Category;
	private ForeignEntityInput mGL_JournalGeneratorLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The GL_JournalGeneratorSource_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_GL_JournalGeneratorSourceInput(@JsonProperty("UU") String UU) {
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
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	@JsonProperty("C_ElementValue")
	public void setC_ElementValueInput(ForeignEntityInput C_ElementValue) {
		this.mC_ElementValue = C_ElementValue;
		if (C_ElementValue != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(C_ElementValue.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_ElementValue_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + C_ElementValue.getUU());
			}
		} else {
			this.setC_ElementValue_ID(0);
		}
	}

	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	@JsonProperty("C_ElementValue")
	public ForeignEntityInput C_ElementValue() {
		return mC_ElementValue;
	}

	/**
	 * Set GL Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	@JsonProperty("GL_Category")
	public void setGL_CategoryInput(ForeignEntityInput GL_Category) {
		this.mGL_Category = GL_Category;
		if (GL_Category != null) {
			// Since an entity was passed, make sure it's in the DB
			MGLCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_Category", "GL_Category_UU=?", get_TrxName())
							.setParameters(GL_Category.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setGL_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Category with UU " + GL_Category.getUU());
			}
		} else {
			this.setGL_Category_ID(0);
		}
	}

	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	@JsonProperty("GL_Category")
	public ForeignEntityInput GL_Category() {
		return mGL_Category;
	}

	/**
	 * Set Generator Line.
	 *
	 * @param GL_JournalGeneratorLine Generator Line
	 */
	@JsonProperty("GL_JournalGeneratorLine")
	public void setGL_JournalGeneratorLineInput(ForeignEntityInput GL_JournalGeneratorLine) {
		this.mGL_JournalGeneratorLine = GL_JournalGeneratorLine;
		if (!is_new()) {
			return;
		}
		if (GL_JournalGeneratorLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MJournalGeneratorLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_JournalGeneratorLine", "GL_JournalGeneratorLine_UU=?", get_TrxName())
							.setParameters(GL_JournalGeneratorLine.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setGL_JournalGeneratorLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_JournalGeneratorLine with UU " + GL_JournalGeneratorLine.getUU());
			}
		} else {
			this.setGL_JournalGeneratorLine_ID(0);
		}
	}

	/**
	 * Get Generator Line.
	 *
	 * @return Generator Line
	 */
	@JsonProperty("GL_JournalGeneratorLine")
	public ForeignEntityInput GL_JournalGeneratorLine() {
		return mGL_JournalGeneratorLine;
	}
	/**
	 * Set Generator Source.
	 *
	 * @param GL_JournalGeneratorSource_ID Generator Source
	 */
	@JsonProperty("GL_JournalGeneratorSource_ID")
	public void setGL_JournalGeneratorSource_IDFromJson(int GL_JournalGeneratorSource_ID) {
		if (get_ID() == 0) {
			super.setGL_JournalGeneratorSource_ID(GL_JournalGeneratorSource_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setGL_JournalGeneratorSource_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getGL_JournalGeneratorSource_UU();
	}
}
