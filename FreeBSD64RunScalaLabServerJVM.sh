java -server -d64   -XX:+UseNUMA -XX:+UseParallelGC -XX:+UseCompressedOops -XX:+AggressiveOpts -Djava.library.path=./libCUDA:.:./lib -Xss5m -Xms4000m -Xmx23500m -jar scalalab_2.12.0-RC1-.jar
