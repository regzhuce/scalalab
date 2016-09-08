cp ./ScalaLabPr/dist/*.jar .
java -server -d64    -XX:+UseNUMA -XX:+UseParallelGC -XX:+UseCompressedOops -XX:+AggressiveOpts -Djava.library.path=./libCUDA:.:./lib -Xss5m -Xms1500m -Xmx23500m -jar ScalaLab.jar
