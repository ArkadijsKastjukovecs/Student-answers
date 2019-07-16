/*package project.answers.student;

 
 import java.util.ArrayList;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import jtm.activity13.Teacher;
 import jtm.activity13.TeacherManager;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.ResponseBody;
 
 @Controller
 @RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
 public class JettyController {
 
         TeacherManager manager;
 

         @GetMapping("")
         @ResponseBody
         // This method should work without declared name parameter, request and
         // response objects,
         // but it shows, how passed request and returned response can be used inside
         // method
         public String homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
                         HttpServletResponse response) {
                 StringBuilder sb = new StringBuilder();
                 sb.append("<a href='/insertTeacher'>Insert teacher<a><br/>\n");
                 sb.append("<a href='/findTeacher'>Find teacher<a><br/>\n");
                 sb.append("<a href='/deleteTeacher'>Delete teacher<a><br/>\n");
                 // Following is also redundant because status is OK by default:
                 response.setStatus(HttpServletResponse.SC_OK);
                 return sb.toString();
         }
 
         // Implement insertTeacher() method
         @GetMapping("/insertTeacher")
         @ResponseBody
         public String insertTeacher(HttpServletRequest request, HttpServletResponse response) {
                 StringBuilder stringBuilder = new StringBuilder();
 
                 if (!request.getParameterNames().hasMoreElements()) {
                         stringBuilder.append("<form action=''>\n" + //
                                         "Name: <input type='text' name='name' value=''><br/>\n" + //
                                         "Surname:<input type='text' name='surname' value=''><br/>\n" + //
                                         "<input type='submit' value='Insert'></form><br/>\n" + //
                                         "<a href='/'>Back</a>\n");
                         response.setStatus(HttpServletResponse.SC_OK);
                         return stringBuilder.toString();
                 } else if (request.getParameter("name") != "" && request.getParameter("surname") != "") {
                         manager = new TeacherManager();
                         manager.insertTeacher(request.getParameter("name"), request.getParameter("surname"));
                         response.setStatus(HttpServletResponse.SC_OK);
                         stringBuilder.append("true<br/>\n" + "<a href='/'>Back</a>\n");
                 } else {
                         stringBuilder.append("false<br/>\n" + "<a href='/'>Back</a>\n");
                         response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                 }
 
                 return stringBuilder.toString();
         }
 
         // Implement findTeacher() method
         @GetMapping("/findTeacher")
         @ResponseBody
         public String findTeacher(HttpServletRequest request, HttpServletResponse response) {
 
                 StringBuilder stringBuilder = new StringBuilder();
                 stringBuilder.append("<form action=''>\n" + "Name: <input type='text' name='name' value=''><br/>\n"
                                 + "Surname:<input type='text' name='surname' value=''><br/>\n"
                                 + "<input type='submit' value='Find'><br/>\n");
 
                 if (!request.getParameterNames().hasMoreElements()) {
 
                         response.setStatus(HttpServletResponse.SC_OK);
                         stringBuilder.append("<a href='/'>Back</a>\n");
                         return stringBuilder.toString();
                 } else {
                         manager = new TeacherManager();
                         List<Teacher> teachers = new ArrayList<>();
                         teachers = manager.findTeacher(request.getParameter("name"), request.getParameter("surname"));
 
                         stringBuilder.append("<table>\n");
                         for (Teacher teacher : teachers) {
                                 stringBuilder.append("<tr>\n" + "<td>" + teacher.getId() + "</td>\n" + "<td>" + teacher.getFirstName()
                                                 + "</td>\n" + "<td>" + teacher.getLastName() + "</td>\n" + "</tr>\n");
                         }
                         stringBuilder.append("</table><br>\n" + "<a href='/'>Back</a>\n");
                 }
                return stringBuilder.toString();
        }

        // Implement deleteTeacher() method 
        @GetMapping("/deleteTeacher")
        @ResponseBody
        public String deleteTeacher(HttpServletRequest request, HttpServletResponse response) {
                StringBuilder stringBuilder = new StringBuilder();
                if (!request.getParameterNames().hasMoreElements()) {
                        stringBuilder.append("<form action=''>\n" + //
                                        "ID:<input type='text' name='id' value=''><br/>\n" + //
                                        "<input type='submit' value='Delete'><br/>\n" + //
                                        "<a href='/'>Back</a>\n");
                        response.setStatus(HttpServletResponse.SC_OK);
                        return stringBuilder.toString();
                } else if (!request.getParameter("id").isEmpty()) {
                        manager = new TeacherManager();
                        manager.deleteTeacher(Integer.parseInt(request.getParameter("id")));
                        response.setStatus(HttpServletResponse.SC_OK);
                        stringBuilder.append("true<br/>\n" + "<a href='/'>Back</a>\n");
                } else {
                        stringBuilder.append("false<br/>\n" + "<a href='/'>Back</a>\n");
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }
                return stringBuilder.toString();
        }
}*/