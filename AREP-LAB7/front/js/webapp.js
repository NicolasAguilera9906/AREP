var webapp = (function () {

    var url = "https://pmyysq17y3.execute-api.us-east-2.amazonaws.com/development?value="

    function getCelsius(fahre) {
        if(fahre.toString()==""){
            alert("Insert a value");
        }
        else {
            $("#table > tbody").empty();
            axios.get(url + fahre).then(res => {
                document.getElementById("rta").innerHTML = res.data.input + " degrees fahrenheit are :  " + res.data.output + " degree centigrade";
                console.log(res.data);
            }).catch(error => {
                console.log(error);
            });
        }
    }
    return {
        getCelsius:getCelsius
    };
})();

