Set ws = CreateObject("WScript.Shell")

op = WScript.Arguments(0)

If op = "silent" Then
	ws.SendKeys Chr(&H88AD) '静音非静音切换
ElseIf op = "red" Then 
	ws.SendKeys Chr(&H88AE) '减小音量
ElseIf op = "inc" Then 
	ws.SendKeys Chr(&H88AF) '增大音量'

End If 
