<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <style>
        .container{background-color: darkgray}

    </style>
    <script type="text/javascript">
        function validateForm() {
            var x = document.forms["myForm"]["teachername"].value;
            var y = document.forms["myForm"]["telephone"].value;
            if(x === "" & y===""){
                document.getElementById("error").innerHTML = "Empty Fields, Please enter Full Teacher Details ";
                return false;
            }
            else if (x === "") {
                document.getElementById("error").innerHTML = "No Name found , Please Enter Teacher Name";
                return false;
            }

        }
    </script>
</head>
<body class="container">
<div >

    <nav class="navbar navbar-default">

        <a href="/" class="navbar-brand">My School</a>
        <ul class="nav navbar-nav">
            <li><a href="/administerStudent.do">Students &nbsp;</a></li>
            <li><a href="/courseadmin.do">Courses &nbsp;</a></li>
            <li  class="active"><a href="/adminsterteacher.do">Teachers</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout.do">Logout &nbsp;</a></li>
        </ul>
    </nav>

        <h2> Teachers Working </h2>
        <ol>
            <c:forEach items="${TeacherList}" var="Teacher">
                <li>Teacher Name: ${Teacher.teachername} &nbsp;  Teacher Contact Info : ${Teacher.telephone} &nbsp;
                    Specialization Field: ${Teacher.field}
                    <a href="/viewTeacher.do?teachername=${Teacher.teachername}">Details</a></li>
            </c:forEach>
        </ol>
        <h3> Add a New Teacher</h3>
    <form action="/adminsterteacher.do" method="post"  name="myForm" onsubmit="return validateForm()" required>
            Teacher name: <input type="text" name="teachername" />
            Telephone Number: <input type="text" name="telephone" />
            <input type="submit" value="Add New Teacher" />
<p id="error"></p>
        </form>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</div>
</body>

</html>
