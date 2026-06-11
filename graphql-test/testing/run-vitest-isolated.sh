#!/usr/bin/env bash
# Run each Vitest file in its own process (same approach as the old Jest loop in runTests.sh).
# Avoids Vitest 4 fork-pool worker teardown failures when the full suite runs in one session.

set -euo pipefail

reporter=verbose
vitest_args=()
while (($# > 0)); do
	case "$1" in
	--reporter)
		reporter="${2:?missing value for --reporter}"
		shift 2
		;;
	*)
		vitest_args+=("$1")
		shift
		;;
	esac
done

if ((${#vitest_args[@]} > 0)); then
	exec npm test -- --run --reporter="$reporter" "${vitest_args[@]}"
fi

mapfile -t test_files < <(find ./src/tests -type f -name '*.test.ts' | sed 's|^\./||' | sort)
if ((${#test_files[@]} == 0)); then
	echo "No test files found under src/tests" >&2
	exit 1
fi

vitest_failed=0
for test_file in "${test_files[@]}"; do
	echo
	echo "=== ${test_file} ==="
	if ! npm test -- --run --reporter="$reporter" "$test_file"; then
		vitest_failed=1
	fi
done

exit "$vitest_failed"
