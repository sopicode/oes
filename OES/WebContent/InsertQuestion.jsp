<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Questions</title>
</head>

<script>
var curr='D';
function nextChar(c) {
	if(c=='Z')
		return 'A';
    return String.fromCharCode(c.charCodeAt(0) + 1);
}
function add(type) {

	

	var foo = document.getElementById("fooBar");
	
	var newlabel = document.createElement("Label");
	curr=nextChar(curr);
	
	if(curr!='A')
	{
		
		//Create an input type dynamically.
		var element = document.createElement("input");

		//Assign different attributes to the element.
		element.setAttribute("type", type);
		element.setAttribute("value", "");
		element.setAttribute("name", "opt"+curr);
		element.setAttribute("id","opt"+curr);
		
		newlabel.innerHTML="Option "+curr+": ";
		var tr=document.createElement('tr');
		var td1 = document.createElement('td');
		td1.appendChild(newlabel);
		tr.appendChild(td1);
		var td2 = document.createElement('td');
		td2.appendChild(element);
		tr.appendChild(td2);
		foo.appendChild(tr);

	}
	else
		{
			curr='Z';
		}
}
function addOptions()
{
		
	var select = document.getElementById("selectbox");
	for(index in myobject) {
	    select.options[select.options.length] = new Option(myobject[index], index);
	}
}

</script>
<body>

<form action="InsertQuestion" method="post">

Select Topic:
<select id="selectbox"></select>

<h3 align="center">Enter Question: <br><br><textarea rows="4" cols="50" id="ques"></textarea> <br><br>
<table align="center" id="fooBar">
<tr>
<td> Option A: </td>
<td><input type="text" name="optA" /></td>
</tr>
<tr>
<td>Option B: </td>
<td><input type="text" name="optB"/> </td>
</tr>
<tr>
<td>Option C: </td>
<td><input type="text" name="optC"/> </td>
</tr>
<tr>
<td>Option D:</td> 
<td><input type="text" name="optD"></td>
</tr>
</table>
<br>
<INPUT type="button" value="Add Option" onclick="add('text')" align="left" width="100" height="50"/>
<INPUT type="submit" value="Insert Question" align="left" width="100" height="500"/>
</form>

</body>
</html>