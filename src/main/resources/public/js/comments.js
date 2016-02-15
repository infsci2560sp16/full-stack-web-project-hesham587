function Addcomment(){
		var getCommentBox= document.getElementById("commentText");
	var newparagraph = document.createElement("p");
	var textnode = document.createTextNode(getCommentBox.value);

	newparagraph.appendChild(textnode);
	 	document.body.appendChild(newparagraph);
		}
	


	
	
function addRow() {


   var getCommentBox= document.getElementById("commentText").value;
    var div = document.createElement('div');

    div.className = 'class="col-9">';

    div.innerHTML =getCommentBox + '\<button class="button button-block" value="Delete comment" onclick="removeRow(this)">Delete comment </button>';

     document.getElementById('comments').appendChild(div);
	 }
	


function removeRow(input) {
    document.getElementById('comments').removeChild( input.parentNode );
}

	