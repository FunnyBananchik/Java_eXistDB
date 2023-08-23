
cls

del mem*.*

javac -Xlint -d . source/Dereberya.java -cp ./lib/Dereberya/*;

echo cls> Dereberya.bat
echo.>> Dereberya.bat
echo @java -cp ./lib/Dereberya/*; Dereberya>> Dereberya.bat
echo.>> Dereberya.bat
copy Dereberya.bat + lib\pause.txt Dereberya.bat

 @pause>nul
