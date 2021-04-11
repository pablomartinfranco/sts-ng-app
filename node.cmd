@ECHO OFF

SET "NODE_EXE=%~dp0\node\node.exe"

IF NOT EXIST "%NODE_EXE%" (
  SETLOCAL
  SET "NODE_EXE=node"
)

"%NODE_EXE%" %*