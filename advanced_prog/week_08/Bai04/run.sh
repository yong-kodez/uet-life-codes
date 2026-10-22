ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
BEFORE_BUILD="$BUILD_DIR/before"
AFTER_BUILD="$BUILD_DIR/after"

mkdir -p "$BEFORE_BUILD"
mkdir -p "$AFTER_BUILD"

javac -d "$BEFORE_BUILD" "$SRC_DIR"/MainBefore.java
javac -d "$AFTER_BUILD" "$SRC_DIR"/MainAfter.java

java -cp "$BEFORE_BUILD" MainBefore
echo "-------------------------"
java -cp "$AFTER_BUILD" MainAfter
