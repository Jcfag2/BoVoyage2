function isNumberOnly(prix){
	let err = document.getElementById("error_prixHT");
	err.style.visibility = "hidden";

	
	var expReg = /^\d+$/;

	if(prix.value.match(expReg)){
	 return true;
	}
	else{
		err.style.visibility = "visible";
		return false;
	}

}


function isNullOrNegative(champ){
	let err = document.getElementById("error_"+champ.name);
	err.style.visibility = "hidden";

	if(champ.value <= 0 ){
		err.style.visibility = "visible";
		return true;
	}

	return false;
}





function isEmpty(champ){
	let err = document.getElementById("error_"+champ.name);
	err.style.visibility = "hidden";


	if(champ.value.trim().length == 0){
		err.style.visibility = "visible";
		return true;
	}

	return false;
}


function endSupToStart()
{
    var dateAller = document.getElementById("dateDepart").value;
    var dateRetour = document.getElementById("dateRetour").value;
	
	let err = document.getElementById("error_dateRetour");
	err.style.visibility = "hidden";

    if( (new Date(dateAller).getTime() < new Date(dateRetour).getTime()))
    {
        // Your code here
		return true;
    }
	
	else{
		err.style.visibility = "visible";
		return false;
	}
	
}


function verify(){
	
	let champs = document.getElementsByClassName('champ_non_vide');
	for(let i = 0; i< champs.length ; i++){
	if(isNullOrNegative(champs[i]) || isEmpty(champs[i])){
		event.preventDefault();
	}
}

	if(!endSupToStart())
	{
		event.preventDefault();
	}

	let prixHT = document.getElementById('prixHT');
	if(!isNumberOnly(prixHT))
	{
		event.preventDefault();
	}



}


document.addEventListener("DOMContentLoaded",function(){

	let champs = document.getElementsByClassName('champ_non_vide');
	for(let i = 0; i< champs.length ; i++){
	champs[i].addEventListener("blur", function(event){isEmpty(event.target)} );
	champs[i].addEventListener("blur", function(event){isNullOrNegative(event.target)} );
	}

	let prixHT = document.getElementById('prixHT');
	prixHT.addEventListener("blur",function(event){isNumberOnly(event.target)} );



	let formulaire = document.getElementById('form_1');
	formulaire.addEventListener("submit", verify);


})


