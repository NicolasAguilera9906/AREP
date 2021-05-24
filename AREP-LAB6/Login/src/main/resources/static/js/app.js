var webapp = (function () {

    var url="https://localhost:5000";

    function login(userEmail,userPassword){
        var user={email:userEmail,password:userPassword}
        console.log(user);
        axios.post(url+"/login",user).then(res=>{
            if(res.data=="Successful login"){
                window.location.href="auth/index.html";
            }
            else {
                alert(res.data);
            }

        })
    }

    function logout(){
        axios.post(url+"/logout").then(res=>{
            if(res.data==="Successful logout") {
                window.location.href = url+"/login.html";
            }
        })
    }

    function service(){
        axios.get(url+"/auth/service").then(res=>{
            document.getElementById("hour").innerHTML = "The hour is: "+res.data;

        })
    }




    return {
        login:login,
        service:service,
        logout:logout
    };
})();