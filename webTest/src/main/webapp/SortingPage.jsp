<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Search</title>
</head>
<body>
<form action="employees" method="get">

    <label for="Names">Name</label>
    <input type="checkbox" name="namePars" value="Names" id="Names" <%= request.getParameter("namePars") != null ? "checked" : "" %> />
<!-- "checked" attribute is used in a checkbox input element to specify whether the checkbox should be selected by default when the page loads.-->
    <label for="Age">Age</label>
    <input type="checkbox" name="agePars" value="Age" id="Age" <%= request.getParameter("agePars") != null ? "checked" : "" %> />

<!-- 	employees?namePars=Names&name=Karan&buttonValue=default
 -->    
 	<label for="Salary">Salary</label>
    <input type="checkbox" name="salPars" value="Salary" id="sal" <%= request.getParameter("salPars") != null ? "checked" : "" %> />

 	<label for="Gender">Gender</label>
    <input type="checkbox" name="genderPars" value="Gender" id="Gender" <%= request.getParameter("genderPars") != null ? "checked" : "" %> />

    <label for="Experience">Experience</label>
    <input type="checkbox" name="expPars" value="Experience" id="Experience" <%= request.getParameter("expPars") != null ? "checked" : "" %> />

    <label for="Level">Level</label>
    <input type="checkbox" name="levelPars" value="Level" id="Level" <%= request.getParameter("levelPars") != null ? "checked" : "" %> />
    
    
    <label for="Deptid">Department ID</label>
    <input type="checkbox" name="deptPars" value="Deptid" id="Deptid" <%= request.getParameter("deptPars") != null ? "checked" : "" %> />

    <%
        if ("Names".equals(request.getParameter("namePars"))) {
            out.println("<p>Name</p><input type='text' name='name'/>");
        }
        if ("Age".equals(request.getParameter("agePars"))) {
            out.println("<p>Age</p><select name='ageOpr'><option value='greater'>Greater</option><option value='lesser'>Lesser</option><option value='equals'>Equals</option></select><input name='A' type='text'/>");
        }
        if ("Salary".equals(request.getParameter("salPars"))) {
            out.println("<p>Salary</p><select name='salaryOpr'><option value='greater'>Greater</option><option value='lesser'>Lesser</option><option value='equals'>Equals</option></select><input name='B' type='text'/>");
        }
        if ("Gender".equals(request.getParameter("genderPars"))) {
            out.println("<p>Gender</p><select name='genderOpr'><option value='equals'>Equals</option></select><input name='C' type='text'/>");
        }
        if ("Experience".equals(request.getParameter("expPars"))) {
            out.println("<p>Experience</p><select name='expOpr'><option value='greater'>Greater</option><option value='lesser'>Lesser</option><option value='equals'>Equals</option></select><input name='D' type='text'/>");
        }
       
        if ("Level".equals(request.getParameter("levelPars"))) {
            out.println("<p>Level</p>");
            out.println("<select name='levelOpr'>");
            out.println("    <option value='greater' " + ("greater".equals(request.getParameter("levelr")) ? "selected" : "") + ">Greater</option>");
            out.println("    <option value='lesser' " + ("lesser".equals(request.getParameter("levelr")) ? "selected" : "") + ">Lesser</option>");
            out.println("    <option value='equals' " + ("equals".equals(request.getParameter("levelr")) ? "selected" : "") + ">Equals</option>");
            out.println("</select>");
            out.println("<input name='E' type='text' value='" + (request.getParameter("E") != null ? request.getParameter("E") : "") + "'/>");
        }
        if ("Deptid".equals(request.getParameter("deptPars"))) {
            out.println("<p>Deptid</p><select name='deptOpr'><option value='greater'>Greater</option><option value='lesser'>Lesser</option><option value='equals'>Equals</option></select><input name='F' type='text'/>");
        }

    %>

    <button type="submit" name="buttonValue" value="<%= request.getParameter("mode") != null ? request.getParameter("mode") : "default" %>">Choose</button>
    <button type="button" onclick="window.location.href='employees'">Reset</button>

</form>
</body>
</html>
