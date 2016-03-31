<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet"  type="text/css" href="stylesheets/stylesheet.css" />
 


    <link rel="stylesheet" type="text/css" href="stylesheets/blog.css" />
 <title>Home</title>
</head>

<body>
<div class="header">
     

<img src="banner.jpg" alt="Smily Face">

</div>
<div>
<ul>
  <li><a href="home.html">Home</a></li>
    <li><a href="search.html">Search</a></li>
  <li><a href="about.html">About</a></li>
      <li class="left"><a href="login.html">Login</a></li>
	<li class="left"><a href="signup.html">Signup</a></li>
  </ul>
</div>
<h1>About iBlog</h1>
<#list contents as content>

<div class="row">

<h4>${content}</h4>
<hr>
</div>
<div class="col-2">
</div>

</#list>


















<div class="row">

</div>



<div class="footer">
<p>Copyright.</p>
</div>


</body>
</html>
