-- GO-3636: Stagger accounting & request processors into the overnight trough
--
-- Problem:
--   Per-client accounting (c_acctprocessor, daily) and request (r_requestprocessor, every
--   15 days) processors carry their time-of-day in datenextrun, which has drifted into busy
--   hours: ~390 fire at 05:00 as a single thundering herd, a cluster runs 06:00-08:00 as
--   clinics open, and a few stragglers land in working hours (incl. one at 21:25). Analysis
--   of 90 days of c_invoice.created (Africa/Nairobi) shows real load peaks 17:00-19:00 and
--   only drops to a quiet trough from ~00:00 (14% of peak) through 02:00-04:00 (3-5% of
--   peak). The 05:00 herd also overlaps the post-04:00 deployment window.
--
--   Root cause of the drift: both shared schedules (200000 acct, 1000000 request) have
--   IsIgnoreProcessingTime='N', so iDempiere computes the next run as run-COMPLETION + interval
--   (MSchedule.getNextRunMS), pushing each job later every cycle by its own processing time.
--
-- Changes:
--   1. Set IsIgnoreProcessingTime='Y' on both shared schedules so the next run anchors to the
--      run START time instead of completion -> the stagger stops drifting (set-and-forget).
--   2. Re-stagger every active processor evenly across the overnight trough, heavy accounting
--      first so it finishes with margin before the deploy window:
--        - accounting: spread evenly 00:00 -> 01:59  (120-minute window)
--        - request:    spread evenly 02:00 -> 03:44  (105-minute window)
--      datenextrun is anchored to (CURRENT_DATE + 1 day) so the next run is always in the
--      future at apply time (never an accidental immediate daytime fire). Ordering by
--      ad_client_id makes the spread deterministic. On environments without these clients
--      the UPDATEs simply touch 0 rows.
--
-- IMPORTANT: a direct datenextrun update is only honoured when AdempiereServerMgr (re)loads
--   the processors. A running server holds the old in-memory schedule and will overwrite
--   datenextrun from the prior run before picking this up. Apply this migration as part of a
--   deploy/server restart, NOT as a live DB patch, or the re-stagger is a silent no-op.

-- Anchor next-run to start time (not completion) so the stagger below does not drift
UPDATE ad_schedule
SET
	isignoreprocessingtime = 'Y',
	updated                = NOW(),
	updatedby              = 100
WHERE
	ad_schedule_id IN (200000, 1000000)
	AND isignoreprocessingtime <> 'Y';

-- Ranking / stagger criteria (applies to both UPDATEs below):
--   ROW_NUMBER() just hands each active processor a sequential slot 0..N-1; that slot is
--   mapped linearly onto the window minutes (rn * window / total). It is purely a way to
--   spread jobs evenly in time.
--   The ORDER BY is ad_client_id (tie-broken by the row PK for determinism). It is NOT a
--   priority/weighting: the spread is deliberately load-AGNOSTIC -- it does not consider a
--   clinic's transaction volume, posting backlog, processing duration, or any importance.
--   Every clinic gets an equal slot; only their position in the window differs, by client id.
--   If we ever want busiest clinics to post first (finish with the most margin before the
--   04:00 deploy), change the ORDER BY to rank on a load metric instead of ad_client_id.

-- Accounting processors: 00:00 -> 01:59, evenly spread
WITH ranked AS (
	SELECT
		c_acctprocessor_id,
		(ROW_NUMBER() OVER (ORDER BY ad_client_id, c_acctprocessor_id) - 1) AS rn,
		COUNT(*) OVER ()                                                    AS total
	FROM
		c_acctprocessor
	WHERE
		isactive = 'Y'
)
UPDATE c_acctprocessor p
SET
	datenextrun = (CURRENT_DATE + INTERVAL '1 day')
		+ ((r.rn * 120 / r.total)::int * INTERVAL '1 minute'),
	updated     = NOW(),
	updatedby   = 100
FROM
	ranked r
WHERE
	p.c_acctprocessor_id = r.c_acctprocessor_id;

-- Request processors: 02:00 -> 03:44, evenly spread (window starts after the accounting one;
-- not an enforced dependency -- a long accounting run can still overlap)
WITH ranked AS (
	SELECT
		r_requestprocessor_id,
		(ROW_NUMBER() OVER (ORDER BY ad_client_id, r_requestprocessor_id) - 1) AS rn,
		COUNT(*) OVER ()                                                       AS total
	FROM
		r_requestprocessor
	WHERE
		isactive = 'Y'
)
UPDATE r_requestprocessor p
SET
	datenextrun = (CURRENT_DATE + INTERVAL '1 day')
		+ INTERVAL '120 minutes'
		+ ((r.rn * 105 / r.total)::int * INTERVAL '1 minute'),
	updated     = NOW(),
	updatedby   = 100
FROM
	ranked r
WHERE
	p.r_requestprocessor_id = r.r_requestprocessor_id;

SELECT
	register_migration_script('202606260941_GO-3636.sql')
FROM
	dual;
