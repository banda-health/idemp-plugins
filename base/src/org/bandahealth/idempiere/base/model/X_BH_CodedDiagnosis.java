/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.I_Persistent;
import org.compiere.model.PO;
import org.compiere.model.POInfo;
import org.compiere.util.KeyNamePair;

/**
 * Generated Model for BH_CodedDiagnosis
 * 
 * @author iDempiere (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_CodedDiagnosis extends PO implements I_BH_CodedDiagnosis, I_Persistent {

	/**
	 *
	 */
	private static final long serialVersionUID = 20200526L;

	/** Standard Constructor */
	public X_BH_CodedDiagnosis(Properties ctx, int BH_CodedDiagnosis_ID, String trxName) {
		super(ctx, BH_CodedDiagnosis_ID, trxName);
	}

	/** Load Constructor */
	public X_BH_CodedDiagnosis(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * AccessLevel
	 * 
	 * @return 4 - System
	 */
	protected int get_AccessLevel() {
		return accessLevel.intValue();
	}

	/**
	 * Load Meta Data
	 * 
	 * @return
	 */
	protected POInfo initPO(Properties ctx) {
		POInfo poi = POInfo.getPOInfo(ctx, Table_ID, get_TrxName());
		return poi;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("X_BH_CodedDiagnosis[").append(get_ID()).append(",CielName=")
				.append(getBH_CielName()).append("]");
		return sb.toString();
	}

	/**
	 * Set BH_CodedDiagnosis_ID.
	 * 
	 * @param BH_CodedDiagnosis_ID BH_CodedDiagnosis
	 */
	public void setBH_CodedDiagnosis_ID(int BH_CodedDiagnosis_ID) {
		if (BH_CodedDiagnosis_ID < 1)
			set_ValueNoCheck(COLUMNNAME_BH_Coded_Diagnosis_ID, null);
		else
			set_ValueNoCheck(COLUMNNAME_BH_Coded_Diagnosis_ID, Integer.valueOf(BH_CodedDiagnosis_ID));
	}

	/**
	 * Get BH_CodedDiagnosis.
	 * 
	 * @return BH_CodedDiagnosis
	 */
	public int getBH_CodedDiagnosis_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Coded_Diagnosis_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set BH_CodedDiagnosis_UU.
	 * 
	 * @param BH_CodedDiagnosis_UU BH_CodedDiagnosis_UU
	 */
	public void setBH_CodedDiagnosis_UU(String BH_CodedDiagnosis_UU) {
		set_Value(COLUMNNAME_BH_Coded_Diagnosis_UU, BH_CodedDiagnosis_UU);
	}

	/**
	 * Get BH_CodedDiagnosis_UU.
	 * 
	 * @return BH_CodedDiagnosis_UU
	 */
	public String getBH_CodedDiagnosis_UU() {
		return (String) get_Value(COLUMNNAME_BH_Coded_Diagnosis_UU);
	}

	/**
	 * Set Description.
	 * 
	 * @param Description Optional short description of the record
	 */
	public void setDescription(String Description) {
		set_Value(COLUMNNAME_Description, Description);
	}

	/**
	 * Get Description.
	 * 
	 * @return Optional short description of the record
	 */
	public String getDescription() {
		return (String) get_Value(COLUMNNAME_Description);
	}

	/**
	 * Get Record ID/ColumnName
	 * 
	 * @return ID/ColumnName pair
	 */
	public KeyNamePair getKeyNamePair() {
		return new KeyNamePair(get_ID(), getBH_CielName());
	}

	@Override
	public void setBH_CielName(String bh_cielname) {
		set_Value(COLUMNNAME_BH_CielName, bh_cielname);
	}

	@Override
	public String getBH_CielName() {
		return (String) get_Value(COLUMNNAME_BH_CielName);
	}

	@Override
	public void setBH_CielId(int bh_cielId) {
		if (bh_cielId < 1)
			set_ValueNoCheck(COLUMNNAME_BH_CielId, null);
		else
			set_ValueNoCheck(COLUMNNAME_BH_CielId, Integer.valueOf(bh_cielId));
	}

	@Override
	public int getBH_CielId() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_CielId);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	@Override
	public void setBH_ConceptClass(String bh_conceptClass) {
		set_Value(COLUMNNAME_BH_ConceptClass, bh_conceptClass);
	}

	@Override
	public String getBH_ConceptClass() {
		return (String) get_Value(COLUMNNAME_BH_ConceptClass);
	}

	@Override
	public void setBH_ICD10(String bh_icd10who) {
		set_Value(COLUMNNAME_BH_ICD10, bh_icd10who);

	}

	@Override
	public String getBH_ICD10() {
		return (String) get_Value(COLUMNNAME_BH_ICD10);
	}

	@Override
	public void setBH_SynomedCT(int bh_synomed_ct) {
		set_Value(COLUMNNAME_BH_SynomedCT, bh_synomed_ct);
	}

	@Override
	public int getBH_SynomedCT() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_SynomedCT);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	@Override
	public void setBH_SynomedNP(int bh_synomed_np) {
		set_Value(COLUMNNAME_BH_SynomedNP, bh_synomed_np);
	}

	@Override
	public int getBH_SynomedNP() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_SynomedNP);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	@Override
	public void setBH_Synonyms(String bh_synonyms) {
		set_Value(COLUMNNAME_BH_Synonyms, bh_synonyms);
	}

	@Override
	public String getBH_Synonyms() {
		return (String) get_Value(COLUMNNAME_BH_Synonyms);
	}

	@Override
	public void setBH_MoH705ALessThan5(String bh_moh705a_lessthan5) {
		set_Value(COLUMNNAME_BH_MoH705A_LessThan5, bh_moh705a_lessthan5);
	}

	@Override
	public String getBH_MoH705ALessThan5() {
		return (String) get_Value(COLUMNNAME_BH_MoH705A_LessThan5);
	}

	@Override
	public void setBH_MoH705BGreaterThan5(String bh_moh705b_greaterthan5) {
		set_Value(COLUMNNAME_BH_MoH705B_GreaterThan5, bh_moh705b_greaterthan5);
	}

	@Override
	public String getBH_MoH705BGreaterThan5() {
		return (String) get_Value(COLUMNNAME_BH_MoH705B_GreaterThan5);
	}
	
	@Override
	public void setBH_SearchTerms(String bh_searchterms) {
		set_Value(COLUMNNAME_BH_SEARCHTERMS, bh_searchterms);
	}
	
	@Override
	public String getBH_SearchTerms() {
		return (String) get_Value(COLUMNNAME_BH_SEARCHTERMS);
	}
}