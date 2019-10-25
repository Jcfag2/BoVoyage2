function isEmpty(champ){
	let err = document.getElementById("error_"+champ.name);
	err.style.visibility = "hidden";


	if(champ.value.trim().length == 0){
		err.style.visibility = "visible";
		return true;
	}

	return false;
}



function verify(){
	
	let champs = document.getElementsByClassName('champ_non_vide');
	for(let i = 0; i< champs.length ; i++){
		if(isEmpty(champs[i]))
		event.preventDefault();
	}
	
}




document.addEventListener("DOMContentLoaded",function(){

	let champs = document.getElementsByClassName('champ_non_vide');
	for(let i = 0; i< champs.length ; i++){
	champs[i].addEventListener("blur", function(event){isEmpty(event.target)} );
	}


	let formulaire = document.getElementById('form_1');
	formulaire.addEventListener("submit", verify)


});


