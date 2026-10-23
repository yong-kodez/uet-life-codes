#!/bin/bash

set -euo pipefail

ROOT="."
DELETE=false

for arg in "$@"; do
  case "$arg" in
    --delete) DELETE=true ;;
    *)        ROOT="$arg" ;;
  esac
done

# Gom danh sách vào mảng (an toàn với tên có khoảng trắng)
mapfile -d '' targets < <(
  find "$ROOT" -name .git -prune -o \
    \( -type f \( -name .classpath -o -name .project \) -o -type d -name .settings \) \
    -print0
)

if [ "${#targets[@]}" -eq 0 ]; then
  echo "Không tìm thấy gì để xóa."
  exit 0
fi

printf '%s\n' "${targets[@]}"
echo "-> Tổng: ${#targets[@]} mục"

if $DELETE; then
  rm -rf -- "${targets[@]}"
  echo "Đã xóa."
else
  echo "(dry-run) Chạy lại với --delete để xóa thật."
fi
