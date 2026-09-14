#!/bin/bash

ROOT_DIR=$(pwd)
RUN_TEMP="$ROOT_DIR/run_temp.txt"
target_dir="$1"

for i in {01..10}; do
  bai_dir="$ROOT_DIR/$target_dir/Bai$i"
  mkdir -p "$bai_dir/src"
  cp "$RUN_TEMP" "$bai_dir/run.sh"
done

