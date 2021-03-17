const apimock = (function () {

    let mockdatica =
        "{\"usuarios\": [" +
            "{" +
                "\"username\": \"admin\"," +
                "\"mail\": \"admin@admin.com\"," +
                "\"password\": \"7d64e1eeca3f4f28fc0db624f1abaec1ea94dfbaf56feca44bbfee5b4fb27ff7\"" +
            "},{" +
                "\"username\": \"candres1019\"," +
                "\"mail\": \"andres.calderon-o@mail.escuelaing.edu.co\"," +
                "\"password\": \"f873139c0d0ffcea24e71b34384e352ff59ba93426cf9050b97382036629b3d4\"" +
            "}" +
        "]}";

    function loadAll(){
        const promise = $.post({
            url: "/loadUsers",
            data: mockdatica,
            contentType: "application/json"
        });
        promise.then(function(data){
        }, function(error) {
            alert("Try again")
        });
    }

    return {
        loadAll: loadAll
    }

})();