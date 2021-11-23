-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'week_8_review';

DROP DATABASE week_8_review;

DROP USER week_8_review_owner;
DROP USER week_8_review_appuser;
