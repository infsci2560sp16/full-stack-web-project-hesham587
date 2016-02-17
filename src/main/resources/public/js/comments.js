function Addcomment(){
		var getCommentBox= document.getElementById("commentText");
	var newparagraph = document.createElement("p");
	var textnode = document.createTextNode(getCommentBox.value);

	newparagraph.appendChild(textnode);
	 	document.body.appendChild(newparagraph);
		}
	


	
	
function addRow() {



   var getCommentBox= document.getElementById("commentText").value;
   if (myTrim(getCommentBox)===''){
	   window.alert("Type a comment");
	   
   }
   else{
	   
   
    var div = document.createElement('div');

    div.className = 'class="col-9">';

    div.innerHTML ='\<div class="col-1"></div><button class="button button-block" value="Delete comment" onclick="removeRow(this)">Delete comment </button>' + getCommentBox;

     document.getElementById('comments').appendChild(div);
	Rest();
	 }
	 }
	


function removeRow(input) {
    document.getElementById('comments').removeChild( input.parentNode );
}

function Rest() {
	var getCommentBox= document.getElementById("commentText");
	getCommentBox.value='';
	
	
}

function myTrim(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}

	