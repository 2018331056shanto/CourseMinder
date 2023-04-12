<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
<nav
  class="relative flex w-full flex-nowrap items-center justify-between bg-neutral-100 py-4 text-neutral-500 shadow-lg hover:text-neutral-700 focus:text-neutral-700 lg:flex-wrap lg:justify-start"
  data-te-navbar-ref>
  <div class="flex w-full flex-wrap items-center justify-between px-6">
    <!-- Hamburger button for mobile view -->
    <button
      class="block border-0 bg-transparent px-2.5 py-2 text-neutral-500 hover:no-underline hover:shadow-none focus:no-underline focus:shadow-none focus:outline-none focus:ring-0 lg:hidden"
      type="button"
      data-te-collapse-init
      data-te-target="#navbarSupportedContent3"
      aria-controls="navbarSupportedContent3"
      aria-expanded="false"
      aria-label="Toggle navigation">
      <!-- Hamburger icon -->
      <span class="[&>svg]:w-7">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          viewBox="0 0 24 24"
          fill="currentColor"
          class="h-7 w-7">
          <path
            fill-rule="evenodd"
            d="M3 6.75A.75.75 0 013.75 6h16.5a.75.75 0 010 1.5H3.75A.75.75 0 013 6.75zM3 12a.75.75 0 01.75-.75h16.5a.75.75 0 010 1.5H3.75A.75.75 0 013 12zm0 5.25a.75.75 0 01.75-.75h16.5a.75.75 0 010 1.5H3.75a.75.75 0 01-.75-.75z"
            clip-rule="evenodd" />
        </svg>
      </span>
    </button>

    <!-- Collapsible navbar container -->
    <div
      class="!visible hidden flex-grow basis-[100%] items-center lg:!flex lg:basis-auto"
      id="navbarSupportedContent3"
      data-te-collapse-item>
      <!-- Navbar title -->
      <a class="text-xl text-black" href="/Servlet-Project/in/admin">Course-Management</a>
      <!-- Left links -->
      <ul
        class="list-style-none mr-auto flex flex-col pl-0 lg:flex-row"
        data-te-navbar-nav-ref>
        <!-- Home link -->
        <li class="lg:px-2" data-te-nav-item-ref>
          <a
            class="active disabled:text-black/30 lg:px-2 [&.active]:text-black/90 dark:[&.active]:text-neutral-400"
            aria-current="page"
            href="/Servlet-Project/in/admin"
            data-te-nav-link-ref
            >Home</a
          >
        </li>
        <!-- Features link -->
        <li class="lg:pr-2" data-te-nav-item-ref>
          <a
            class="p-0 text-neutral-500 hover:text-neutral-700 focus:text-neutral-700 disabled:text-black/30 lg:px-2 [&.active]:text-black/90 dark:[&.active]:text-neutral-400"
            href="/Servlet-Project/in/admin/course"
            data-te-nav-link-ref
            >Courses</a
          >
        </li>
        <!-- Pricing link -->
        <li class="lg:pr-2" data-te-nav-item-ref>
          <a
            class="p-0 text-neutral-500 hover:text-neutral-700 focus:text-neutral-700 disabled:text-black/30 lg:px-2 [&.active]:text-black/90 dark:[&.active]:text-neutral-400"
            href="/Servlet-Project/in/admin/teacher"
            data-te-nav-link-ref
            >Teachers</a
          >
        </li>
        <li class="lg:pr-2" data-te-nav-item-ref>
          <a
            class="p-0 text-neutral-500 hover:text-neutral-700 focus:text-neutral-700 disabled:text-black/30 lg:px-2 [&.active]:text-black/90 dark:[&.active]:text-neutral-400"
            href="/Servlet-Project/in/admin/student"
            data-te-nav-link-ref
            >Students</a
          >
        </li>
        <!-- Disabled link -->
        <li class="lg:pr-2" data-te-nav-link-ref>
          <a
            class="text-black/30 lg:px-2 [&.active]:text-black/90 dark:[&.active]:text-neutral-400"
            ></a
          >
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="w-full flex justify-center mt-10 tracking-widest font-mono font-semibold text-2xl">

<div>${name } </div>

</div>
<div class="container mx-auto px-20">

<div class="flex flex-col w-full" style="cursor: auto;">

  <div class="grid gap-2 grid-cols-4 sm:grid-cols-4 my-2 w-auto">
  <c:forEach var="item" items="${courses }">
  
    <div class="metric-card bg-white text-2xl dark:bg-gray-900 border border-gray-200 dark:border-gray-800 rounded-lg p-4 max-w-72 w-full" style="cursor: auto;">
     <div class="mt-3  flex justify-center items-center"><p>${item.getName()}</p></div>
    </div>
      </c:forEach>
    
    
  </div>
  
</div>

</div>
<div id="input-container1" class="w-full justify-center flex">
  <div class="w-3/4 flex justify-between p-4 mt-8 bg-white border border-gray-200 rounded-lg shadow sm:p-2 dark:bg-gray-800 dark:border-gray-700">
    <span class="px-4 py-2 font-serif font-bold text-xl ">Assign A New Course</span> 
    <button class="px-4 py-2 text-white bg-blue-500 rounded hover:bg-blue-600 focus:outline-none" onclick="showInput()">Assign</button>

  </div>
</div>
<form action="/Servlet-Project/in/admin/teacher/${id}" method="post" id="input-container" class="w-full mb-10 items-center hidden justify-center flex">
  <div class="w-3/4 flex justify-between p-4 mt-8 bg-white border border-gray-200 rounded-lg shadow sm:p-2 dark:bg-gray-800 dark:border-gray-700">
    <div id="input-container px-6" class=" mt-4">
<div class="mt-0">

<select name="coursename"  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
  <option >Choose a Course</option>
  <c:forEach var="item" items="${notcourses }">
  <option value="${item.getName()}:${item.getId()}"> ${item.getName() }</option>
  </c:forEach>
  
  
</select>
                
</div> 
</div>
 <button class="px-4 py-2 text-white bg-blue-500 rounded hover:bg-blue-600 focus:outline-none" onclick="showInput1()">Assign</button>

  </div>
</form>
<script>
  // JavaScript code
  function showInput() {
    var inputContainer = document.getElementById("input-container");
	  var inputContainer1=document.getElementById("input-container1")
    inputContainer1.classList.add("hidden");

    inputContainer.classList.remove("hidden");
  }
  
  function showInput1(){
	  var inputContainer=document.getElementById("input-container1")
	  
  }
</script>
</body>
</html>