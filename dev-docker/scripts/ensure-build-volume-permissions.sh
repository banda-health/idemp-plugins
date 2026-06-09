#!/bin/bash
# Keep paths in sync with docker-compose.build-overlays.yml
set -euo pipefail

if [ "$(id -u)" != "0" ]; then
    echo "ensure-build-volume-permissions.sh must run as root." >&2
    exit 1
fi

# Legacy build.sh created lib/ symlinks on the bind mount; Docker then mounted named
# volumes at the link target (/home/developer/banda-plugin-libs/...) instead of
# module lib/ paths. Remove those symlinks before ensuring volume mount points.
LIB_SYMLINK_MODULES=(
    chuck-test-framework
    base-test
    graphql
    graphql-test
    reports-test
)

for mod in "${LIB_SYMLINK_MODULES[@]}"; do
    lib="/workspace/idemp-banda/${mod}/lib"
    if [ -L "$lib" ]; then
        rm "$lib"
    fi
done

rm -rf /home/developer/banda-plugin-libs

BUILD_VOLUME_PATHS=(
    /workspace/idemp-banda/testing
    /workspace/idemp-banda/chuck-test-framework/target
    /workspace/idemp-banda/chuck-test-framework/lib
    /workspace/idemp-banda/base/target
    /workspace/idemp-banda/base-test/target
    /workspace/idemp-banda/base-test/lib
    /workspace/idemp-banda/graphql/target
    /workspace/idemp-banda/graphql/lib
    /workspace/idemp-banda/graphql-feature/target
    /workspace/idemp-banda/graphql-test/target
    /workspace/idemp-banda/graphql-test/lib
    /workspace/idemp-banda/reports/target
    /workspace/idemp-banda/reports-test/target
    /workspace/idemp-banda/reports-test/lib
)

for path in "${BUILD_VOLUME_PATHS[@]}"; do
    mkdir -p "$path"
    chown -R developer:developer "$path"
done
