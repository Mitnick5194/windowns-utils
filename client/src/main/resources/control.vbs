Dim WshShell
op = WScript.Arguments(0)
Set ws = CreateObject("WScript.Shell")
If op = "silent" Then
	ws.SendKeys Chr(&H88AD) '静音非静音切换
ElseIf op = "decr" Then 
	ws.SendKeys Chr(&H88AE) '减小音量
ElseIf op = "incr" Then 
	ws.SendKeys Chr(&H88AF) '增大音量'
ElseIf op = "tab" Then
	ws.SendKeys "%+{TAB}" '切换窗口'
ElseIf op = "closeTab" Then
	ws.SendKeys "%+{F4}" '关闭当前活动窗口'
End If 
