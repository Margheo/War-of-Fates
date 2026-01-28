@echo off
if not exist out (
  echo Pasta out nao encontrada. Compilando...
  call compile.bat
  if errorlevel 1 (
    echo Compilacao falhou.
    pause
    exit /b 1
  )
)
java -cp out Main