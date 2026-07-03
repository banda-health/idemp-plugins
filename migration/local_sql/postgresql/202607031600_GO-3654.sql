-- GO-3654: New tenants get wrong accounting/request processor schedule & miss the GO-3636 stagger
--
-- Problem (follow-up to GO-3636):
--   GO-3636 re-staggered all EXISTING accounting/request processors into the overnight trough, but new
--   tenants are created by core MSetup on the seed schedules (200002 "10 Minutes" acct, 200003
--   "15 Minutes" request). Two System-tenant Alert Rules (DB-only, unversioned, both mislabeled
--   "Update Accounting Processor run times") tried to correct them daily via postprocessing UPDATEs,
--   but that can never work reliably:
--     - AdempiereServerMgr only loads new processors on a restart/reload, and a RUNNING processor
--       rewrites datenextrun from its in-memory schedule on every run, so the alert's datenextrun is
--       clobbered (observed on UAT: tenant 1000416 flipped to the daily schedule by the alert at 05:50
--       yet still firing every 10 minutes with datenextrun ~13:04).
--     - current_date + INTERVAL '1 day' herds every caught processor onto midnight, undoing the spread.
--   The real fix is in code: InitialBandaClientSetup now moves the processors to the shared schedules
--   and staggers datenextrun into the trough at client creation, before the server manager ever loads
--   them. This migration handles everything already in the database.
--
-- Changes:
--   1. Create the shared request-processor schedule 1000000 "15 Days" where it doesn't exist (it was
--      hand-entered on UAT/prod only; local/dev environments never had it), and re-assert
--      IsIgnoreProcessingTime='Y' on both shared schedules (GO-3636 only updated rows existing then).
--   2. Repoint any processor still on a non-shared schedule to the shared ones, staggering datenextrun
--      into the trough with a stateless per-client slot (ad_client_id % window) -- the same formula
--      InitialBandaClientSetup now uses at creation.
--   3. Re-place datenextrun for ACTIVE processors already on the shared schedules but with a time-of-day
--      clearly outside their trough window (i.e. clobbered placements like tenant 1000416). Windows are
--      padded (acct < 02:15, request 01:45-04:00) so rows that drifted a few ms/day past the window edge
--      aren't pointlessly re-touched on every deploy. Inactive processors keep their stale datenextrun
--      (they aren't loaded by the server manager; on UAT there are ~28 with dates back to 2019).
--   4. Retire the two System-tenant alerts + their dedicated alert processors: superseded by the
--      creation-time fix, and their live UPDATEs are worse than useless (midnight herd + clobber).
--
-- IMPORTANT: like GO-3636, apply as part of a deploy/server restart, NOT as a live DB patch --
--   datenextrun set here is only honoured when AdempiereServerMgr (re)loads the processors.

-- 1) Shared request-processor schedule (UU matches the hand-entered UAT/prod row)
INSERT INTO ad_schedule
	(ad_schedule_id, ad_schedule_uu, ad_client_id, ad_org_id, isactive, created, createdby, updated,
	 updatedby, name, scheduletype, frequencytype, frequency, monthday, isignoreprocessingtime,
	 issystemschedule)
SELECT
	1000000, 'b7934445-5448-4f3b-8cce-5f56a785bcfd', 0, 0, 'Y', NOW(), 100, NOW(), 100, '15 Days', 'F',
	'D', 15, 0, 'Y', 'N'
WHERE
	NOT EXISTS(SELECT 1 FROM ad_schedule WHERE ad_schedule_id = 1000000);

-- Anchor next-run to start time (not completion) so the stagger below does not drift (GO-3636)
UPDATE ad_schedule
SET
	isignoreprocessingtime = 'Y',
	updated                = NOW(),
	updatedby              = 100
WHERE
	ad_schedule_id IN (200000, 1000000)
	AND isignoreprocessingtime <> 'Y';

-- 2) Any accounting processor not on the shared daily schedule: repoint + stagger into 00:00-01:59
UPDATE c_acctprocessor
SET
	ad_schedule_id = 200000,
	datenextrun    = (CURRENT_DATE + INTERVAL '1 day')
		+ ((ad_client_id % 120) * INTERVAL '1 minute'),
	updated        = NOW(),
	updatedby      = 100
WHERE
	ad_schedule_id <> 200000;

-- Any request processor not on the shared "15 Days" schedule: repoint + stagger into 02:00-03:44
UPDATE r_requestprocessor
SET
	ad_schedule_id = 1000000,
	datenextrun    = (CURRENT_DATE + INTERVAL '1 day')
		+ INTERVAL '120 minutes'
		+ ((ad_client_id % 105) * INTERVAL '1 minute'),
	updated        = NOW(),
	updatedby      = 100
WHERE
	ad_schedule_id <> 1000000;

-- 3) Processors already on the shared schedules whose placement was lost (clobbered/herded datenextrun):
--    put them back into their trough window
UPDATE c_acctprocessor
SET
	datenextrun = (CURRENT_DATE + INTERVAL '1 day')
		+ ((ad_client_id % 120) * INTERVAL '1 minute'),
	updated     = NOW(),
	updatedby   = 100
WHERE
	ad_schedule_id = 200000
	AND isactive = 'Y'
	AND datenextrun::time >= TIME '02:15';

UPDATE r_requestprocessor
SET
	datenextrun = (CURRENT_DATE + INTERVAL '1 day')
		+ INTERVAL '120 minutes'
		+ ((ad_client_id % 105) * INTERVAL '1 minute'),
	updated     = NOW(),
	updatedby   = 100
WHERE
	ad_schedule_id = 1000000
	AND isactive = 'Y'
	AND (datenextrun::time < TIME '01:45' OR datenextrun::time >= TIME '04:00');

-- 4) Retire the System-tenant alerts (and their dedicated processors) that tried to fix schedules live.
--    Matched by name because they only ever existed as hand-entered DB data (no IDs guaranteed across
--    environments); on environments without them these touch 0 rows.
UPDATE ad_alertrule
SET
	isactive  = 'N',
	updated   = NOW(),
	updatedby = 100
WHERE
	ad_alert_id IN (SELECT ad_alert_id
	                FROM ad_alert
	                WHERE name IN ('Update Accounting Processor run times',
	                               'Update Request Processor run times'))
	AND isactive = 'Y';

UPDATE ad_alert
SET
	isactive  = 'N',
	updated   = NOW(),
	updatedby = 100
WHERE
	name IN ('Update Accounting Processor run times', 'Update Request Processor run times')
	AND isactive = 'Y';

UPDATE ad_alertprocessor
SET
	isactive  = 'N',
	updated   = NOW(),
	updatedby = 100
WHERE
	name IN ('Update Accounting Processor run times', 'Update Request Processor run times')
	AND isactive = 'Y';

SELECT
	register_migration_script('202607031600_GO-3654.sql')
FROM
	dual;
