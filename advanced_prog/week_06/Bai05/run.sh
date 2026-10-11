ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
target="$1"
mkdir -p "$BUILD_DIR"

if [ -n "$target" ]; then
  TAR_DIR="$SRC_DIR/problem0$target"
  javac -d "$BUILD_DIR" "$TAR_DIR"/*.java
  java -cp "$BUILD_DIR" Main
elif [ -z "$target" ]; then
  for i in {1..4}; do
    javac -d "$BUILD_DIR" "$SRC_DIR/problem0$i"/*.java
    java -cp "$BUILD_DIR" Main
  done
fi
