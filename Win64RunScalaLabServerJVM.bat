java -server  -d64  -XX:+UseNUMA -XX:+UseParallelGC -XX:+UseCompressedOops -XX:+AggressiveOpts -Djava.library.path=./lib;. -Xss5m -Xms3000m -Xmx23000m -jar scalalab_2.12.0-M5-.jar
