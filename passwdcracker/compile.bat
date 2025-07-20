@REM Compile the Java files in the src directory and place the compiled classes in the out directory
javac -d out -sourcepath src src/CrackerApp.java

@REM Compile the Login class separately
javac -d out -sourcepath src cibles/Login.java

@REM  Run the application with different arguments
@REM java -cp out CrackerApp dictionnary remote admin  
java -cp out CrackerApp dictionnary local admin
@REM java -cp out CrackerApp bruteForce local admin
@REM java -cp out CrackerApp bruteForce remote admin