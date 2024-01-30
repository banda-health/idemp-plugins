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
 * @version Release 8.2 - $Id$
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
	 * @param UUID The GL_JournalGeneratorSource_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_GL_JournalGeneratorSourceInput(@JsonProperty("UUID") String UUID) {
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
							.setParameters(C_ElementValue.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_ElementValue_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + C_ElementValue.getUUID());
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
							.setParameters(GL_Category.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGL_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Category with UUID " + GL_Category.getUUID());
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
		if (get_ID() != 0) {
			return;
		}
		if (GL_JournalGeneratorLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MJournalGeneratorLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_JournalGeneratorLine", "GL_JournalGeneratorLine_UU=?", get_TrxName())
							.setParameters(GL_JournalGeneratorLine.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGL_JournalGeneratorLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_JournalGeneratorLine with UUID " + GL_JournalGeneratorLine.getUUID());
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

	public void setGL_JournalGeneratorSource_ID(int GL_JournalGeneratorSource_ID) {
		if (get_ID() == 0) {
			super.setGL_JournalGeneratorSource_ID(GL_JournalGeneratorSource_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setGL_JournalGeneratorSource_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getGL_JournalGeneratorSource_UU();
	}
}
