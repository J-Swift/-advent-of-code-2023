#!/usr/bin/env nix-shell
#!nix-shell -p bash -i bash clojure

set -euo pipefail

readonly _day="${1:-}"
readonly _part="${2:-}"

if [ -z "${_day}" ] || [ -z "${_part}" ]; then
    echo "ERROR: day or part not provided"
    echo
    echo "USAGE: ${0} [day #] [part #]"
    exit 1
fi

main() {
    local day=$(printf "%02d\n" $_day)
    local part=$(printf "%02d\n" $_part)

    pushd "day_${day}/part_${part}" >/dev/null
    clojure -M run_it.clj
    popd >/dev/null
}

main
