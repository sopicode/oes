<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Questions</title>
</head>

<script>
function add(type) {

	//Create an input type dynamically.
	var element = document.createElement("input");

	//Assign different attributes to the element.
	element.setAttribute("type", type);
	element.setAttribute("value", type);
	element.setAttribute("name", type);


	var foo = document.getElementById("fooBar");

	//Append the element in page (in span).
	foo.appendChild(element);
	 var br = document.createElement("br");
	 foo.appendChild(br);

}

</script>
<body>

<form action="">
<h3 align="center">Enter Question: <br><br><textarea rows="4" cols="50" id="ques"></textarea> <br><br>
Option A: <input type="text" id="optA"/> <br>
Option B: <input type="text" id="optB"/> <br>
Option C: <input type="text" id="optC"/> <br>
Option D: <input type="text" name="myInputs[]"> <br><br>
<span id="fooBar">&nbsp;</span>
<INPUT type="button" value="Add" onclick="add('text')" align="left" width="100" height="50"/>
<INPUT type="submit" value="Add Question" align="left" width="100" height="50"/>
</form>

</body>
</html>