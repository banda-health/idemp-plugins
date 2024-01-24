package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MGLCategory;
import org.compiere.model.MJournalGeneratorLine;
import org.compiere.model.MJournalGeneratorSource;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_GL_JournalGeneratorSourceInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MJournalGeneratorSource(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	@JsonProperty("C_ElementValue")
	public void setC_ElementValueInput(ForeignEntityInput C_ElementValue) {
		this.mC_ElementValue = C_ElementValue;
		MElementValue foreignEntity;
		if (C_ElementValue != null &&
				(foreignEntity = new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
						.setParameters(C_ElementValue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ElementValue_ID(foreignEntity.get_ID());
		} else {
			super.setC_ElementValue_ID(0);
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
		MGLCategory foreignEntity;
		if (GL_Category != null &&
				(foreignEntity = new Query(getCtx(), "GL_Category", "GL_Category_UU=?", get_TrxName())
						.setParameters(GL_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_Category_ID(foreignEntity.get_ID());
		} else {
			super.setGL_Category_ID(0);
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
		MJournalGeneratorLine foreignEntity;
		if (get_ID() == 0 && GL_JournalGeneratorLine != null &&
				(foreignEntity = new Query(getCtx(), "GL_JournalGeneratorLine", "GL_JournalGeneratorLine_UU=?", get_TrxName())
						.setParameters(GL_JournalGeneratorLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_JournalGeneratorLine_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setGL_JournalGeneratorSource_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getGL_JournalGeneratorSource_UU();
	}
}
