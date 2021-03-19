const app = (function () {

    function login() {
        let user = $("#username_id").val();
        let pass = $("#password_id").val();
        let cadena = {};
        cadena["user"] = user;
        cadena["password"] = pass;
        const promise = $.post({
            url: "/loginUser",
            data: JSON.stringify(cadena),
            contentType: "application/json"
        });
        promise.then(function (data) {
            if (data === "true") {
                alert("Redirigiendo a pagina Administradora");
                window.location.href = "/admin/calculator.html";
            } else {
                alert("Usuario ó Contraseña Incorrectos");
            }
        }, function (error) {
            alert("Try again");
        });
    }

    function logOut() {
        const promise = $.post({
            url: "/logoutUser",
            contentType: "application/json"
        });
        promise.then(function (data) {
            window.location.href = "/index.html";
        }, function (error) {
            alert("Try again")
        });
    }

    function sendData() {
        let daticos = $("#number-array__id").val();
        const miniPromise = $.get({
            url: "/logged/status",
            contentType: "application/json"
        });
        miniPromise.then(function (data) {
            if (data === "false") {
                alert("Debe hacer login primero antes de intentar hacer calculos");
                window.location.href = "/index.html";
            } else {
                console.log(JSON.stringify(daticos))
                const promise = $.post({
                    url: "https://172.17.0.1:5001/calculator",
                    data: JSON.stringify(daticos),
                    contentType: "application/json"
                });
                promise.then(function (data) {
                    console.log(data);
                    console.log(JSON.stringify(data));
                    daticos = JSON.parse(data);
                    $("#Media").text("Media: " + daticos.media).css("visibility", "visible");
                    $("#desviacion").text("Desviacion Estandar: " + daticos.desviacionEstandar).css("visibility", "visible");
                }, function (error) {
                    console.log(error);
                    alert("Try again");
                });
            }
        });
    }

    return {
        login: login,
        logOut: logOut,
        sendData: sendData
    }

})();