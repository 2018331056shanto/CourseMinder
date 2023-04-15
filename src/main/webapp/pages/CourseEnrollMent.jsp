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
       <ul class="list-style-none ml-auto flex flex-col pl-0 lg:flex-row" data-te-navbar-nav-ref>
        <!-- Logout link -->
        <li class="lg:px-2" data-te-nav-item-ref>
          <form method="post" action="/Servlet-Project/logout">
            <button class="active disabled:text-black/30 lg:px-2 [&.active]:text-black/90 dark:[&.active]:text-neutral-400" type="submit">Logout</button>
          </form>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="w-full flex justify-center mt-10 tracking-widest font-mono font-semibold text-2xl">

<div>Teachers and Students List in  <span>${courseName }</span> </div>
</div>
<div class="flex w-full justify-around mt-7">

<div class="flex flex-wrap w-full ">
  <div class="w-full max-w-xl rounded-lg border border-gray-200 bg-white p-4 shadow dark:border-gray-700 dark:bg-gray-800 sm:p-8">
    <div class="mb-4 flex items-center justify-between">
      <h5 class="text-xl font-bold leading-none text-gray-700 dark:text-white">Students</h5>
      <span class="text-xl font-bold leading-none text-gray-700 dark:text-white">Registration</span>
      
    </div>
    <div class="flow-root">
      <ul role="list" class="divide-y divide-gray-200 dark:divide-gray-700">
       <c:forEach var="item" items="${students}"> 
       
       
        <li class="py-3 sm:py-4">
          <div class="flex items-center space-x-4">
            <div class="min-w-0 flex-1">
              
                <p class="truncate text-xl font-medium text-gray-800 dark:text-white">  ${item.getName()} </p>

              <p class="truncate text-sm text-gray-500 dark:text-gray-400"></p>
            </div>
            <div class="inline-flex items-center text-base font-semibold text-gray-900 dark:text-white">${item.getId() }</div>
          </div>
          
        </li>
        </c:forEach>
      </ul>
    </div>
  </div>
</div>
   
<div class="flex flex-wrap w-full ">
      <div class="w-full max-w-md rounded-lg border border-gray-200 bg-white p-4 shadow dark:border-gray-700 dark:bg-gray-800 sm:p-8">
        <div class="mb-4 flex items-center justify-between">
          <h5 class="text-xl font-bold leading-none text-gray-700 dark:text-white">Teacher </h5>
          <span class="text-xl font-bold leading-none text-gray-700 dark:text-white">Department</span>
        </div>
        <div class="flow-root">
          <ul role="list" class="divide-y divide-gray-200 dark:divide-gray-700">
            <li class="py-3 sm:py-4">
              <div class="flex items-center space-x-4">
                <div class="min-w-0 flex-1">
                  
                    <p class="truncate text-xl font-medium text-gray-800 dark:text-white">   ${teacher}  </p>
                  
                  <p class="truncate text-sm text-gray-500 dark:text-gray-400"></p>
                </div>
                <div class="inline-flex items-center text-base font-semibold text-gray-900 dark:text-white">     ${deptname }  </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>


</body>
</html>