Set ws = CreateObject("WScript.Shell")

op = WScript.Arguments(0)

If op = "silent" Then
	ws.SendKeys Chr(&H88AD) '�����Ǿ����л�
ElseIf op = "red" Then 
	ws.SendKeys Chr(&H88AE) '��С����
ElseIf op = "inc" Then 
	ws.SendKeys Chr(&H88AF) '��������'

End If 
