/**********************************************************************
* This file is part of iDempiere ERP Open Source and ERP Academy      *
* http://www.idempiere.org                                            *
* http://www.chuckboecking.com                                        *
*                                                                     *
* Copyright (C) Contributors                                          *
*                                                                     *
* This program is provided to current and former participants of      *
* ERP Academy (erp-academy.chuckboecking.com). Once you have joined   *
* the ERP Academy, you may use and modify it under the terms of       *
* the GNU General Public License as published by the Free Software    *
* Foundation; either version 2 of the License, or (at your option)    *
* any later version.                                                  *
*                                                                     *
* This program is distributed in the hope that it will be useful,     *
* but WITHOUT ANY WARRANTY; without even the implied warranty of      *
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
* GNU General Public License for more details.                        *
*                                                                     *
* You should have received a copy of the GNU General Public License   *
* along with this program; if not, write to the Free Software         *
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
* MA 02110-1301, USA.                                                 *
*                                                                     *
* Contributors:                                                       *
* - Chuck Boecking                                                    *
**********************************************************************/

package com.chuboe.test.populate;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Trx;

import com.chuboe.test.model.MChuBoePopulateResponse;

public class ChuBoePopulateFactoryVO {
	
	private MChuBoePopulateResponse m_response = null;
	private ArrayList<String> m_AssertionSQL = new ArrayList<String>();
	private Trx m_trx = null;
	protected CLogger m_log = CLogger.getCLogger (getClass());
	private String m_scenarioName = null;


	public String getScenarioName() {
		return m_scenarioName;
	}

	public void setScenarioName(String m_scenarioName) {
		this.m_scenarioName = m_scenarioName;
	}

	public ArrayList<String> getAssertionSQL() {
		return new ArrayList<String>(m_AssertionSQL);
	}
	
	public void addAssertionSQL(ArrayList<String> list)
	{
		m_AssertionSQL.addAll(list);
	}
	
	public void addAssertionSQL(String sql)
	{
		m_AssertionSQL.add(sql);
	}
	
	public void setResponse(MChuBoePopulateResponse response)
	{
		m_response = response;
	};
	
	public MChuBoePopulateResponse getResponse()
	{
		return m_response;
	};
	
	public CLogger getLog() {
		return m_log;
	}

	public String get_TrxName() {
		return m_trx.getTrxName();
	}

	public Trx getTrx() {
		return m_trx;
	}
	
	public void setTrx(Trx trx) {
		this.m_trx = trx;
	}
	
	protected void commitEx() throws SQLException
	{
		if (m_trx != null)
			m_trx.commit(true);
	}
	
	protected void rollback()
	{
		if (m_trx != null)
			m_trx.rollback();
	}
}
