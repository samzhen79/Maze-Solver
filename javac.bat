@echo off
@del /s /q *.class
javac.exe -d ./bin --module-path ./lib --add-modules=javafx.controls,javafx.fxml --source-path ./src %*