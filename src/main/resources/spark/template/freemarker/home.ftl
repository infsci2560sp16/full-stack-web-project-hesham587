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





<div class="col-3-6">
   <div >
        <div class="row">
            <div>
			
			
				
			
                <div>
				

  <a href="post.html">
                        <h2>
                          ${article1}
                        </h2>
                      
                    </a>
					
                    <p>  Posted by <a href="#">${author1}</a> on ${date1}</p>
					<p><#if rate1=="1">senior author</#if></p>
                </div>
                <hr>
                <div>
                    <a href="iphone.html">
                        <h2 >
                    ${article2}
                        </h2>
                    </a>
                    <p >Posted by <a href="#">${author2}</a> on ${date2}</p>
                </div>
                <hr>
                <div >
                    <a href="facebook.html">
                        <h2 >
                           ${article3}
                        </h2>
                       
                    </a>
                    <p >Posted by <a href="#">${author3}</a> on ${date3}</p>
                </div>
                <hr>
                <div  >
                    <a href="banana.html">
                        <h2 >
                          ${article4}
                        </h2>
                        
                    </a>
                    <p class="post-meta">Posted by <a href="#">${author4}</a> on ${date4}</p>
					<p><#if rate4=="2">junior  author</#if></p>
                </div>
                <hr>
                <!-- Pager -->
                <ul>
                    <li class="left">
                        <a href="#">Older Posts &rarr;</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="row">

</div>



<div class="footer">
<p>Copyright.</p>
</div>


</body>
</html>
