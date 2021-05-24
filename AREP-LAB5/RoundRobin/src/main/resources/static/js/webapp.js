var webapp = (function () {

    //var url = "http://localhost:42000"
    var url = "http://ec2-3-138-154-47.us-east-2.compute.amazonaws.com:42000"
    function insertLog(log){
        axios.post(url+"/addlog?content="+log);
    }
    function getLogs() {
        $("#table > tbody").empty();
        axios.get(url+"/lastlogs").then(res=>{
            console.log(res.data);
            res.data.map( log => {
                $("#table > tbody").append(
                    "<tr>" +
                    " <td>" + log.content + "</td>" +
                    "<td>" + log.date + "</td> " +
                    "</tr>"
                );
            });
        }).catch(error => {
            console.log(error);
        });
    }
    return {
        getLogs:getLogs,
        insertLog:insertLog
    };
})();

