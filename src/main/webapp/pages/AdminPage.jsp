<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
<!-- Main navigation container -->
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

<div class="container mx-auto px-20">
<div class="flex flex-col w-full" style="cursor: auto;">
  <div class="grid gap-4 grid-cols-1 sm:grid-cols-2 my-2 w-full">
    <div class="metric-card bg-white text-2xl dark:bg-gray-900 border border-gray-200 dark:border-gray-800 rounded-lg p-4 max-w-72 w-full" style="cursor: auto;">
      Total Courses
      <p class="mt-2 text-2xl font-bold spacing-sm text-black dark:text-white" style="cursor: auto;"> ${totalcourse} </p>
    </div>
    <div class="metric-card bg-white dark:bg-gray-900 border border-gray-200 dark:border-gray-800 rounded-lg p-4 max-w-72 w-full" style="cursor: auto;">
      <a aria-label="Unsplash Views" target="_blank" rel="noopener noreferrer" >
        <div class="flex text-2xl items-center text-gray-900 dark:text-gray-100" style="cursor: auto;">Total Teachers
         
        </div>
      </a>
      <p class="mt-2 text-2xl font-bold spacing-sm text-black dark:text-white" style="cursor: auto;">  ${totalteacher} </p>
    </div>
  </div>
  <div class="grid gap-4 grid-cols-1 sm:grid-cols-2 my-2 w-full">
    <div class="metric-card bg-white dark:bg-gray-900 border border-gray-200 dark:border-gray-800 rounded-lg p-4 max-w-72 w-full" style="cursor: auto;">
      <a aria-label="YouTube Subscribers" target="_blank" rel="noopener noreferrer">
        <div class="flex text-2xl items-center text-gray-900 dark:text-gray-100" style="cursor: auto;">Total Students
         
        </div>
      </a>
      <p class="mt-2 text-2xl font-bold spacing-sm text-black dark:text-white" style="cursor: auto;">  ${totalstudent} </p>
    </div>
    <div class="metric-card bg-white dark:bg-gray-900 border border-gray-200 dark:border-gray-800 rounded-lg p-4 max-w-72 w-full" style="cursor: auto;">
      <a aria-label="YouTube Views" target="_blank" rel="noopener noreferrer" >
        <div class="flex text-2xl items-center text-gray-900 dark:text-gray-100">Highest Taken Course
         
        </div>
      </a>
      <p class="mt-2 text-2xl font-bold spacing-sm text-black dark:text-white" style="cursor: auto;"> ${highest} </p>
    </div>
    <div class="metric-card bg-white dark:bg-gray-900 border border-gray-200 dark:border-gray-800 rounded-lg p-4 max-w-72 w-full" style="cursor: auto;">
      <a aria-label="YouTube Views" target="_blank" rel="noopener noreferrer" >
        <div class="flex text-2xl items-center text-gray-900 dark:text-gray-500">Most Favorite Teacher
         
        </div>
      </a>
      <p class="mt-2 text-2xl font-bold spacing-sm text-black dark:text-white" style="cursor: auto;">  ${bestteacher} </p>
    </div>
    <div class="metric-card bg-white dark:bg-gray-900 border border-gray-200 dark:border-gray-800 rounded-lg p-4 max-w-72 w-full" style="cursor: auto;">
      <a aria-label="YouTube Views" target="_blank" rel="noopener noreferrer" >
        <div class="flex text-2xl items-center text-gray-900 dark:text-gray-100">Newest Course
         
        </div>
      </a>
      <p class="mt-2 text-2xl font-bold spacing-sm text-black dark:text-white" style="cursor: auto;">5</p>
    </div>
    
  </div>
</div>
</div>

</body>
</html>