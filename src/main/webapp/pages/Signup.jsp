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

<div class="flex items-center justify-center min-h-screen">
   <div class="flex justify-center items-center">
    <img src="https://st.depositphotos.com/18722762/51522/v/450/depositphotos_515228796-stock-illustration-online-registration-sign-login-account.jpg">
    </div>
    <div class="px-8 py-3 mx-4 mt-16 text-left md:w-1/3 lg:w-1/3 sm:w-1/3">
        <div class="flex justify-center">
            <svg xmlns="http://www.w3.org/2000/svg" class="w-20 h-20 text-blue-600" fill="none" viewBox="0 0 24 24"
                stroke="currentColor">
                <path d="M12 14l9-5-9-5-9 5 9 5z" />
                <path
                    d="M12 14l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14z" />
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="M12 14l9-5-9-5-9 5 9 5zm0 0l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14zm-4 6v-7.5l4-2.222" />
            </svg>
        </div>
        <h3 class="text-2xl  font-bold text-center">Create an Account</h3>
        <form action="/Servlet-Project/signup" method="post">
            <div class="mt-4">
                <div>
                    <label  class="block" for="Name">Name<label>
                            <input  name="name" type="text" placeholder="Name"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                </div>
                <div class="mt-4">
                    <label class="block" for="email">Email<label>
                            <input name="email" type="text" placeholder="Email"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                </div>
                 <div class="mt-4">
                   <label for="dept" class="block">Department</label>
<select name="department" id="dept" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
  <option >Choose a department</option>
  <option value="cse">Computer Science and Engineering</option>
  <option value="eee">Electrical and Electronics Engineering</option>
  <option value="swe">Software Engineering</option>
  <option value="fet">Food Engineering and Tea Technology</option>
</select>
                </div>
                 <div class="mt-4">
                   <label for="type" class="block">Create Account As</label>
<select id="selectField" onchange="addInputField()" name="type" id="countries" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
  <option >Choose a type</option>
  <option value="student">Student</option>
  <option value="teacher">Teacher</option>

</select>
                </div>
                
                <div id="inputContainer" class="mt-4">    
                      <label id="label" for="dept" class="block"></label>
                </div>
                <script>
      function addInputField() {
        // get the selected option value
        var selectedOption = document.getElementById("selectField").value;
		
        if(selectedOption==="student")
        	{
        	  var container = document.getElementById("inputContainer");
        		
        	  var label=document.getElementById("label")
        	  label.innerText = "Student ID"

                var newInput = document.createElement("input");
                newInput.type = "text";
                newInput.name = "id";
                newInput.id = "newInput";
                newInput.className = "w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600";

       
                container.appendChild(newInput);
       	
        	
        	}
        else
        	{
      	  var container = document.getElementById("inputContainer");

        	  var existingInput = document.getElementById("newInput");
        	  var label=document.getElementById("label")
        	  label.innerText=""
        	  
              if (existingInput) {
                container.removeChild(existingInput);
                container.innerHTML("")
              }
        	}
        // create a new input element
   
      }
    </script>
                <div class="mt-4">
                
                    <label class="block">Password<label>
                            <input name="password"type="password" placeholder="Password"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                </div>
                <div class="mt-4">
                    <label class="block">Confirm Password<label>
                            <input name="confpassword" type="password" placeholder="Password"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
                </div>
                <span class="text-sm text-red-400"> ${mismatch }</span>
                <div class="flex">
                    <button class="w-full px-6 py-2 mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Create
                        Account</button>
                </div>
                <div class="mt-6 text-grey-dark">
                    Already have an account?
                    <a class="text-blue-600 hover:underline" href="/Servlet-Project/login">
                        Log in
                    </a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>