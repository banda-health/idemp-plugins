package org.bandahealth.idempiere.graphql.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_VisitResolver;
import org.compiere.model.MUser;
import org.compiere.util.CLogger;

import javax.servlet.AsyncContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Holds live SSE connections for real-time queue-arrival notifications, keyed by channel (a
 * process-stage value like "totriage", or "toclinician:&lt;clinician AD_User_UU&gt;" for the
 * specific-clinician case). Singleton, mirrors the GraphQLEndpoint.cacheFactory pattern.
 */
public class QueueEventBroadcaster {
	private static final QueueEventBroadcaster instance = new QueueEventBroadcaster();
	private static final CLogger logger = CLogger.getCLogger(QueueEventBroadcaster.class);
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final long HEARTBEAT_INTERVAL_SECONDS = 20;

	private final Map<String, Set<AsyncContext>> connectionsByChannel = new ConcurrentHashMap<>();
	private final ScheduledExecutorService heartbeatScheduler = Executors.newSingleThreadScheduledExecutor();

	private QueueEventBroadcaster() {
		heartbeatScheduler.scheduleAtFixedRate(this::sendHeartbeats, HEARTBEAT_INTERVAL_SECONDS, HEARTBEAT_INTERVAL_SECONDS,
				TimeUnit.SECONDS);
	}

	public static QueueEventBroadcaster getInstance() {
		return instance;
	}

	public void subscribe(String channel, AsyncContext asyncContext) {
		connectionsByChannel.computeIfAbsent(channel, key -> new CopyOnWriteArraySet<>()).add(asyncContext);
	}

	public void unsubscribe(String channel, AsyncContext asyncContext) {
		Set<AsyncContext> connections = connectionsByChannel.get(channel);
		if (connections != null) {
			connections.remove(asyncContext);
		}
	}

	public static String clinicianChannel(String clinicianUserUU) {
		return QueueRoleMapping.CLINICIAN_PROCESS_STAGE_VALUE + ":" + clinicianUserUU;
	}

	/**
	 * Broadcast a queue-arrival event to every connection subscribed to the visit's new process
	 * stage, and (for the clinician stage, when a specific clinician is assigned) also to that
	 * clinician's dedicated channel - mirrors getMyQueueVisitFilter's general-pool-vs-specific-
	 * clinician split.
	 */
	public void broadcastVisitQueued(Properties ctx, MBHVisit visit) {
		String processStageValue = visit.getBH_Process_Stage();
		if (processStageValue == null || processStageValue.isEmpty()) {
			return;
		}

		String payload = buildPayload(ctx, visit, processStageValue);
		if (payload == null) {
			return;
		}

		send(processStageValue, payload);
		if (QueueRoleMapping.CLINICIAN_PROCESS_STAGE_VALUE.equals(processStageValue) && visit.getBH_Clinician_User_ID() > 0) {
			MUser clinician = MUser.get(ctx, visit.getBH_Clinician_User_ID());
			if (clinician != null) {
				send(clinicianChannel(clinician.getAD_User_UU()), payload);
			}
		}
	}

	private String buildPayload(Properties ctx, MBHVisit visit, String processStageValue) {
		try {
			String patientName = visit.getPatient() != null ? visit.getPatient().getName() : null;
			if (patientName == null) {
				return null;
			}
			ObjectNode node = objectMapper.createObjectNode();
			node.put("patientName", patientName);
			node.put("sourceLabel", resolveProcessStageName(ctx, processStageValue));
			node.put("isEmergency", visit.isBH_IsEmergency());
			node.put("isLabReturn", visit.isBH_IsReturningFromLab());
			return objectMapper.writeValueAsString(node);
		} catch (Exception exception) {
			logger.warning("Could not build queue event payload: " + exception.getMessage());
			return null;
		}
	}

	private String resolveProcessStageName(Properties ctx, String processStageValue) {
		String refListUU = X_BH_VisitResolver.BH_PROCESS_STAGE_UUIDS_BY_VALUE.get(processStageValue);
		if (refListUU == null) {
			return "";
		}
		MRefList_BH refList = Repository.getByUuid(ctx, MRefList_BH.Table_Name, null, refListUU);
		return refList != null ? refList.getName() : "";
	}

	private void send(String channel, String payload) {
		Set<AsyncContext> connections = connectionsByChannel.get(channel);
		if (connections == null || connections.isEmpty()) {
			return;
		}
		for (AsyncContext asyncContext : connections) {
			writeEvent(asyncContext, "data: " + payload + "\n\n", connections);
		}
	}

	private void sendHeartbeats() {
		for (Map.Entry<String, Set<AsyncContext>> entry : connectionsByChannel.entrySet()) {
			for (AsyncContext asyncContext : entry.getValue()) {
				writeEvent(asyncContext, ": keep-alive\n\n", entry.getValue());
			}
		}
	}

	private void writeEvent(AsyncContext asyncContext, String event, Set<AsyncContext> connections) {
		try {
			PrintWriter writer = asyncContext.getResponse().getWriter();
			writer.write(event);
			writer.flush();
			// PrintWriter.flush() only pushes into the servlet's internal response buffer - without an
			// explicit flushBuffer(), Jetty can hold the bytes rather than sending them immediately,
			// defeating real-time delivery for a long-lived SSE stream
			asyncContext.getResponse().flushBuffer();
			if (writer.checkError()) {
				throw new IOException("Client connection closed");
			}
		} catch (Exception exception) {
			connections.remove(asyncContext);
			try {
				asyncContext.complete();
			} catch (Exception ignored) {
				// Already completed/closed
			}
		}
	}
}
