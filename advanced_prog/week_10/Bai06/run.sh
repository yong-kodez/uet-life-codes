ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
mkdir -p "$BUILD_DIR"
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

if [[ "$1" == "tcp-client" ]]; then 
  java -cp "$BUILD_DIR" CommandClient
fi 

if [[ "$1" == "tcp-server" ]]; then 
  java -cp "$BUILD_DIR" CommandServer
fi 

if [[ "$1" == "udp-sender" ]]; then 
  java -cp "$BUILD_DIR" SensorSender
fi 

if [[ "$1" == "udp-receiver" ]]; then 
  java -cp "$BUILD_DIR" SensorReceiver
fi 
