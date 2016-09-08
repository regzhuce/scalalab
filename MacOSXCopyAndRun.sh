cp ./target/scala-2.12.0-M5/*.jar .
java -server -d64    -XX:+UseNUMA -XX:+UseParallelGC -XX:+UseCompressedOops -XX:+AggressiveOpts -Djava.library.path=.:./lib -Xss5m -Xms1500m -Xmx23500m -jar scalalab_2.12.0-M5-.jar
