const app = (function () {

    function login() {
        let user = $("#username_id").val();
        let pass = $("#password_id").val();
        let cadena = {}
        cadena["user"] = user;
        cadena["password"] = pass;
        const promise = $.post({
            url: "/loginUser",
            data: JSON.stringify(cadena),
            contentType: "application/json"
        });
        promise.then(function(data){
            console.log(data)
            if (data === "true"){
                alert("Redirigiendo a pagina Administradora");
                window.location.href="/admin";
            } else{
                alert("Usuario ó Contraseña Incorrectos")
            }
        }, function(error) {
            alert("Try again")
        });
    }

    return {
        login: login
    }

})();