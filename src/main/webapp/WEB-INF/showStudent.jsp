<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- beans.Studentをimportする -->
<%@ page import="beans.Student" %>
<!-- requestから"Student"を取得し，Studentクラスとして利用する -->
<% Student studnet = (Student) request.getAttribute("Student"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>結果</title>
  </head>

  <body bgcolor="skyblue">
    <br />
    <% if(studnet == null){ %> 該当する学生がいません．<br />
    検索し直してください． <br />
    <% }else{ %>
    <table border="1" width="100%">
      <tr>
        <td width="40%"><center>ID</center></td>
        <td width="60%"><center><%= studnet.getStudentID() %></center></td>
      </tr>
      <tr>
        <td width="40%"><center>名前</center></td>
        <td width="60%"><center><%= studnet.getStudentName() %></center></td>
      </tr>
      <tr>
        <td width="40%"><center>出身地</center></td>
        <td width="60%">
          <center><%= studnet.getStudentBirthplace() %></center>
        </td>
      </tr>
    </table>
    <br />
    <%}%>
    <a href="./index.jsp">トップに戻る</a>
  </body>
</html>
