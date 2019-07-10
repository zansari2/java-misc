Clear-Host
javac *.java
java SubArray

#Can't run classes in their leaf, must be in the root
Clear-Host
javac .\arr\SubArray.java
java -classpath . arr.SubArray 

Clear-Host
javac .\str\StringManipulation.java
java -classpath . str.StringManipulation

Clear-Host
javac .\alg\Relationship.java
java -classpath . alg.Relationship