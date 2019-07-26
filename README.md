# Student-answers
<pre>
For building project use maven with [clean install]<br>
Also have to use plugin spring-boot with  [repackage]
in linux: mvn clean install spring-boot:repackage <br>
Application have 2 user level – student and teacher. A teacher may: 
  upload file with the descriptions of task and data; the file can be any kind in free form
  enter the name of test
  enter expected answers in form answer1 @ answer2 @ ...
     @ is used to split answers
   choose one test for students 
    students can download only single file <br>
The student may:
  enter the name of test;
  download test file;
    or download active tes
enter answers in form answer1 @ answer2 @... 
  or answer1 (without @ if there is single answer)<br>
The application gives evaluation of student skills, one point per one correct answer.
</pre>
