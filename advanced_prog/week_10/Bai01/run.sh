ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
mkdir -p "$BUILD_DIR"
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

if [[ "$1" == "client" ]]; then 
  java -cp "$BUILD_DIR" ClientMain
fi 

if [[ "$1" == "server" ]]; then 
  java -cp "$BUILD_DIR" ServerMain
fi 
