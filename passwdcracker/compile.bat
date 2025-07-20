@REM Compile the Java files in the src directory and place the compiled classes in the out directory
javac -d out -sourcepath src src/App.java 

@REM Compile the Login class separately
javac -d out -sourcepath src cibles/Login.java

@REM  Run the application with different arguments

@REM java -cp out App dictionnary remote admin  
java -cp out App dictionnary local admin