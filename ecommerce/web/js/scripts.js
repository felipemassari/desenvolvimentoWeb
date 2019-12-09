// Empty JS for your own code to be here
function buscaEndereco(){
    var cep = document.getElementById("cep").value;
    var xmlhttp = new XMLHttpRequest();
    var url = "http://cep.republicavirtual.com.br/web_cep.php?cep="+cep+"&formato=json";
    xmlhttp.onreadystatechange = function(){
        if (xmlhttp.status === 200){
            if (xmlhttp.readyState === 4){
                alert(xmlhttp.responseText);
            }
        }
    };
    xmlhttp.open("GET",url, true);
    xmlhttp.send();
    
}