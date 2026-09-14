#!/bin/bash

ROOT_DIR=$(pwd)
target_dir=$1

for i in {01..10}; do
  rm -rf "$target_dir/Bai$i/build/"
done

