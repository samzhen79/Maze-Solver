@echo off
java.exe --class-path ./bin --module-path ./lib --add-modules=javafx.controls,javafx.fxml %*
