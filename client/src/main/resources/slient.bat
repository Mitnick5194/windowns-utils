@echo off
(echo Set WshShell = Wscript.CreateObject^("Wscript.Shell"^)
echo WshShell.Sendkeys "��")>JingYin.VBS
JingYin.VBS&del /f /q JingYin.VBS
exit