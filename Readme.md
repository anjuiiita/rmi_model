# Command to generate h file
javac CmdAgentClass.java -h .

# Command to generate library: 
cc -shared -I/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home/include/ \
       -I/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home/include/darwin/ -dynamiclib -o libclient.dylib client.c


# Command to compile all java files
javac *.java

# Command to run Manager
rmiregistry &
java Manager

# Command to run Agent
java Agent