<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://cdn.tailwindcss.com"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">

</head>
<body>
<div>

<nav class="bg-white shadow-md fixed w-full z-10">
  <div class="max-w-7xl mx-auto px-2 sm:px-6 lg:px-8">
    <div class="relative flex items-center justify-between h-16">
      <div class="absolute inset-y-0 left-0 flex items-center sm:hidden">
        <!-- Mobile menu button -->
        <button type="button" class="inline-flex items-center justify-center p-2 rounded-md text-gray-400 hover:text-white hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white" aria-controls="mobile-menu" aria-expanded="false">
          <span class="sr-only">Open main menu</span>
      
          <svg class="block h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
          </svg>
          <svg class="hidden h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
          </svg>
        </button>
      </div>
      <div class="flex items-center justify-between w-full ">
        <div class="flex-shrink-0">
             <a class="text-2xl text-black" href="/Servlet-Project/in/admin" style="font-family: Lobster">Course-Management</a>
        </div>
        <div class="hidden sm:block sm:ml-6">
          <div class="flex space-x-4">
            <!-- Current: "bg-gray-900 text-white", Default: "text-gray-300 hover:bg-gray-700 hover:text-white" -->
            <a href="/Servlet-Project/login" class="text-black text-lg text-bold px-3 py-2 rounded-md text-sm font-medium">Login</a>

            <a href="/Servlet-Project/signup" class="text-black px-3 py-2 rounded-md text-sm font-medium">Signup</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Mobile menu, show/hide based on mobile menu state. -->
  <div class="sm:hidden" id="mobile-menu">
    <div class="px-2 pt-2 pb-3 space-y-1">
      <!-- Current: "bg-gray-900 text-white", Default: "text-gray-300 hover:bg-gray-700 hover:text-white" -->
      <a href="#" class="bg-gray-900 text-white block px-3 py-2 rounded-md text-base font-medium">Login</a>

      <a href="#" class="text-gray-300 hover:bg-gray-700 hover:text-white block 
      px-3 py-2 rounded-md text-base font-medium">Signup</a>
</div>

  </div>
</nav>
    <section class="min-h-screen flex justify-center text-white ">
    <div class="flex justify-center items-center">
    <img src="https://t3.ftcdn.net/jpg/03/39/70/90/360_F_339709048_ZITR4wrVsOXCKdjHncdtabSNWpIhiaR7.jpg">
    </div>
            <div class="lg:w-1/2 w-full flex items-center justify-center text-center md:px-16 px-0 z-0">
            <div class="w-full py-6 z-20">
                <h1 class="my-6">
                    <div class="w-auto h-7 sm:h-8 inline-flex">
                      <p class="text-2xl text-black font-bold" style="letter-spacing:2px">Sign in to your account</p>
                    </div>
                </h1>
              
                <form action="/Servlet-Project/login" method="post" class="sm:w-2/3 w-full px-4 lg:px-0 mx-auto">
                                   <span class="text-xl text-red-800"> ${mismatch }</span>
                   
                    <div class="pb-2 pt-4">
                        <input type="email" name="email" id="email" placeholder="Email" class="block outline-none w-full p-4 text-lg text-black rounded-sm border-2 border-gray-300 focus:border-gray-400">
                    </div>
                    <div class="pb-2 pt-4">
                        <input class="block outline-none w-full p-4 text-lg text-black rounded-sm border-2 border-gray-300 focus:border-gray-400" type="password" name="password" id="password" placeholder="Password">
                    </div>
                    <div class="flex gap-24">
                       <div class="text-left text-gray-400 hover:underline hover:text-gray-100">
                        <a href="/Servlet-Project/signup" >Don't have account?</a>
                    </div>
                    <div class="text-right text-gray-400 hover:underline hover:text-gray-100">
                        <a href="#">Forgot your password?</a>
                    </div>
                    </div>
                    <div class="px-4 pb-2 pt-4">
                        <button  type="submit" class="uppercase block w-full p-4 text-lg rounded-full bg-indigo-500 hover:bg-indigo-600 focus:outline-none">sign in</button>
                    </div>

                  
                </form>
            </div>
        </div>
    </section>
    </div>
</body>


   
</html>