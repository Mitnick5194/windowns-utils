Dim WshShell
op = WScript.Arguments(0)
Set ws = CreateObject("WScript.Shell")
If op = "silent" Then
	ws.SendKeys Chr(&H88AD) '�����Ǿ����л�
ElseIf op = "decr" Then 
	ws.SendKeys Chr(&H88AE) '��С����
ElseIf op = "incr" Then 
	ws.SendKeys Chr(&H88AF) '��������'
ElseIf op = "tab" Then
	ws.SendKeys "%+{TAB}" '�л�����'
ElseIf op = "closeTab" Then
	ws.SendKeys "%+{F4}" '�رյ�ǰ�����'
End If 
