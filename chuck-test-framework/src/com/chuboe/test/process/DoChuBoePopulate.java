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

package com.chuboe.test.process;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.base.Service;
import org.adempiere.exceptions.AdempiereException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.compiere.model.MSystem;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Trx;

import com.chuboe.test.model.MChuBoePopulateResponse;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IChuBoePopulateFactory;
import com.chuboe.test.populate.IPopulateAnnotation.CanRun;
import com.chuboe.test.populate.IPopulateAnnotation.CanRunAfter;
import com.chuboe.test.populate.IPopulateAnnotation.CanRunAfterClass;
import com.chuboe.test.populate.IPopulateAnnotation.CanRunBefore;
import com.chuboe.test.populate.IPopulateAnnotation.CanRunBeforeClass;
import com.chuboe.test.populate.IPopulateAnnotation.Skip;

public class DoChuBoePopulate extends SvrProcess {

	int m_loopCount = 1;
	String classFilter = null;
	String testNameFilter = null;

	public static List<ChuBoePopulateFactoryVO> getPopulators() {
		List<IChuBoePopulateFactory> factories = Service.locator().list(IChuBoePopulateFactory.class).getServices();
		List<ChuBoePopulateFactoryVO> populators_total = new ArrayList<ChuBoePopulateFactoryVO>();
		if (factories != null && !factories.isEmpty()) {
			for (IChuBoePopulateFactory factory : factories) {
				List<ChuBoePopulateFactoryVO> populators = factory.newChuBoePopulateInstance();
				if (populators != null)
					populators_total.addAll(populators);
			}
		}
		return populators_total;
	}

	@Override
	protected void prepare() {
		for (ProcessInfoParameter para : getParameter()) {
			String name = para.getParameterName();
			if (name.equals("ChuBoe_Process_Loop_Count")) {
				m_loopCount = para.getParameterAsInt();
			} else if (name.equals("ChuBoe_Process_Class_Filter")) {
				classFilter = para.getParameterAsString();
			} else if (name.equals("ChuBoe_Process_TestNameFilter")) {
				testNameFilter = para.getParameterAsString();
			} else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
	}

	@Override
	protected String doIt() throws Exception {
		int totalErrors = 0;
		int totalClasses = 0;
		int totalMethods = 0;
		int totalLoops = 0;

		// Set a format for how the test timing should be displayed
		DecimalFormat decimalFormat = new DecimalFormat("#.###");
		decimalFormat.setRoundingMode(RoundingMode.CEILING);

		MSystem system = MSystem.get(Env.getCtx());
		if (system.getSystemStatus().equals(MSystem.SYSTEMSTATUS_Production)) {
			log.log(Level.WARNING, "System Status is Production so not a good idea to execute test cases.");
			return "System Status is Production so not a good idea to execute test cases.";
		}

		//call into OSGi services for collection of classes
		List<ChuBoePopulateFactoryVO> populators = getPopulators();
		//check if something to do
		if (populators.isEmpty()) {
			throw new AdempiereException("Error - Did not find any Populate Test classes");
		}

		// Filter the packages, if need be
		if (classFilter != null && !classFilter.isEmpty() && !classFilter.isBlank()) {
			String[] classFilters = classFilter.split(",");
			for (String filter : classFilters) {
				String className = filter.trim().toLowerCase();
				populators = populators.stream().filter(
								populator -> populator.getClass().getCanonicalName().toLowerCase().contains(className.toLowerCase()))
						.collect(Collectors.toList());
			}
		}
		boolean doesTestFilterExist = testNameFilter != null && !testNameFilter.isEmpty() && !testNameFilter.isBlank();

		for (int i = 0; i < m_loopCount; i++) {
			if (totalErrors > 0) {
				addLog("Aborting more loops due to errors in previous loop");
				break;
			}

			totalLoops++;

			//iterate on collection of classes - call on annotation methods
			for (ChuBoePopulateFactoryVO pop : populators) //List Iterator of class
			{
				//TODO: consider counting errors - if error count > threshold parameter then break
				totalClasses++;
				boolean classBreak = false;
				long testStartTime = System.currentTimeMillis();
				boolean didErrorOccurForThisTest = false;

				//create a new transaction for each class.
				Trx pop_trx = Trx.get(Trx.createTrxName(pop.getClass().getSimpleName()), true);
				String pop_trxName = pop_trx.getTrxName();

				//create a new response record in the class's transaction
				MChuBoePopulateResponse pop_response = new MChuBoePopulateResponse(getCtx(), 0, pop_trxName);
				pop_response.setAD_Org_ID(0);
				pop_response.setClassname(pop.getClass().getCanonicalName());
				pop_response.setName(pop_response.getClassname());
				pop_response.setAD_Process_ID(this.getProcessInfo().getAD_Process_ID());
				pop_response.setAD_PInstance_ID(this.getAD_PInstance_ID());
				pop_response.setTrxName(pop_trxName);
				pop_response.setIsError(false);
				pop_response.setNote("Starting... " + pop.getClass().getSimpleName());
				pop_response.saveEx();
				pop_trx.commit(true);

				pop.setResponse(pop_response);
				pop.setTrx(pop_trx);

				Method[] methods = pop.getClass().getMethods();

				// If this class doesn't have a test matching the filter, skip it
				if (doesTestFilterExist && Arrays.stream(methods)
						.noneMatch(method -> method.getName().toLowerCase().contains(testNameFilter.toLowerCase()))) {
					continue;
				}

				//Look for and document skipped methods
				for (Method method : methods) {
					Skip annos = method.getAnnotation(Skip.class);
					if (!classBreak && annos != null) {
						try {
							pop.setScenarioName(pop.getClass().getSimpleName() + "_" + method.getName());
							pop_response.appendNote("Skipping... " + pop.getScenarioName());
							pop_response.saveEx();
						} catch (Exception e) {
							logError(pop_response, e);
							pop_response.saveEx();
						} finally {
							pop_trx.commit(true);
						}
					}
				}

				//Look for and execute BeforeClass annotated methods
				for (Method method : methods) {
					CanRunBeforeClass annos = method.getAnnotation(CanRunBeforeClass.class);
					if (!classBreak && annos != null) {
						try {
							pop.setScenarioName(pop.getClass().getSimpleName() + "_" + method.getName());
							pop_response.appendNote("Starting... " + pop.getScenarioName());
							pop_response.saveEx();
							method.invoke(pop);
							pop_response.appendNote("Ending... " + pop.getScenarioName());
							pop_response.saveEx();
						} catch (Exception e) {
							totalErrors++;
							didErrorOccurForThisTest = true;
							classBreak = true;
							logError(pop_response, e);
							pop_response.saveEx();
						} finally {
							pop_trx.commit(true);
						}
					}
				}


				//Look for and execute CanRun annotated methods - execute before and after annotations for each CanRun
				for (Method method : methods) {
					CanRun annos = method.getAnnotation(CanRun.class);
					if (!classBreak && annos != null) {
						// We'll skip the can run methods that don't match the filter, if there is one
						if (doesTestFilterExist && !method.getName().toLowerCase().contains(testNameFilter.toLowerCase())) {
							continue;
						}
						try {

							//Look for and execute Before annotated methods
							for (Method beforeMethod : methods) {
								CanRunBefore beforeAnnos = beforeMethod.getAnnotation(CanRunBefore.class);
								if (!classBreak && beforeAnnos != null) {
									pop.setScenarioName(pop.getClass().getSimpleName() + "_" + beforeMethod.getName());
									pop_response.appendNote("Starting... " + pop.getScenarioName());
									pop_response.saveEx();
									beforeMethod.invoke(pop);
									pop_response.appendNote("Ending... " + pop.getScenarioName());
									pop_response.saveEx();
									pop_trx.commit(true);
								}
							}

							//execute CanRun annotation
							totalMethods++;
							pop.setScenarioName(pop.getClass().getSimpleName() + "_" + method.getName());
							pop_response.appendNote("Starting... " + pop.getScenarioName());
							pop_response.saveEx();
							method.invoke(pop);
							pop_response.appendNote("Ending... " + pop.getScenarioName());
							pop_response.saveEx();
							pop_trx.commit(true);

							//Look for and execute After annotated methods
							for (Method afterMethod : methods) {
								CanRunAfter afterAnnos = afterMethod.getAnnotation(CanRunAfter.class);
								if (!classBreak && afterAnnos != null) {
									pop.setScenarioName(pop.getClass().getSimpleName() + "_" + afterMethod.getName());
									pop_response.appendNote("Starting... " + pop.getScenarioName());
									pop_response.saveEx();
									afterMethod.invoke(pop);
									pop_response.appendNote("Ending... " + pop.getScenarioName());
									pop_response.saveEx();
									pop_trx.commit(true);
								}
							}

						} catch (Exception e) {
							totalErrors++;
							didErrorOccurForThisTest = true;
							logError(pop_response, e);
							pop_response.saveEx();
						} finally {
							pop_trx.commit(true);
						}
					}
				}


				//Look for and execute AfterClass annotated methods
				for (Method method : methods) {
					CanRunAfterClass annos = method.getAnnotation(CanRunAfterClass.class);
					if (!classBreak && annos != null) {
						try {
							pop.setScenarioName(pop.getClass().getSimpleName() + "_" + method.getName());
							pop_response.appendNote("Starting... " + pop.getScenarioName());
							pop_response.saveEx();
							method.invoke(pop);
							pop_response.appendNote("Ending... " + pop.getScenarioName());
							pop_response.saveEx();
						} catch (Exception e) {
							totalErrors++;
							didErrorOccurForThisTest = true;
							logError(pop_response, e);
							pop_response.saveEx();
						} finally {
							pop_trx.commit(true);
						}
					}
				}
				pop_response.appendNote("Ending... " + pop.getClass().getSimpleName());
				pop_response.setDescription(didErrorOccurForThisTest ? "Error" : "Success");
				pop_response.setIsError(totalErrors > 0);
				long testDuration = System.currentTimeMillis() - testStartTime;
				pop_response.setExecutionTime(new BigDecimal(testDuration));
				pop_response.saveEx();
				pop_trx.commit(true);
				pop_trx.close();
				pop_trx = null;

				addLog((didErrorOccurForThisTest ? "FAIL " : "PASS ") + pop.getClass().getSimpleName() + " (" +
						decimalFormat.format((double) testDuration / 1000D) + ")");
				if (didErrorOccurForThisTest) {
					String[] responseLines = pop_response.getNote().split(MChuBoePopulateResponse.NOTE_SEPARATOR);
					for (String responseLine : responseLines) {
						addLog("----" + responseLine);
					}
				}
			} //List Iterator of classes
			populators = null;
		} //loop count

		String details =
				" Loops attempted: " + totalLoops + ", Total Classes: " + totalClasses + ", Total Methods: " + totalMethods +
						", Total Errors: " + totalErrors + ".";
		if (totalErrors > 0) {
			throw new AdempiereException(details);
		}
		return "Success!! " + details;

		//TODO: Consider adding a parameter to determine if process should create a pack out of the test results.
	}

	/**
	 * This adds whatever error was thrown to the population response that gets saved to the DB
	 *
	 * @param populateResponse The response to fill with the error
	 * @param exception        The exception thrown
	 */
	private void logError(MChuBoePopulateResponse populateResponse, Exception exception) {
		populateResponse.appendNote(ExceptionUtils.getRootCauseMessage(exception));
		// Only log the stack trace if this didn't fail because of an assertion
		String stackTrace = String.join("\n", ExceptionUtils.getRootCauseStackTrace(exception));
		if (!stackTrace.toLowerCase().contains("assert")) {
			populateResponse.appendNote(stackTrace);
		}
	}
}
