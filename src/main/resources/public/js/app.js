const app = (function () {

    function login() {
        let user = $("#username_id").val();
        let pass = $("#password_id").val();
        let cadena = "{\"user\":" + "\"" + user + "\"" +",\"password\":" + "\"" + pass + "\"" + "}";
        console.log(cadena)
        const promise = $.post({
            url: "/login",
            data: cadena,
            contentType: "application/json"
        });
        promise.then(function(data){
        }, function(error) {
            alert("Try again")
        });
    }

    return {
        login: login
    }

})();