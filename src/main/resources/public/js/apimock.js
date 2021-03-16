const apimock = (function () {

    mockdata["Users"] = [
        {
            username: "admin",
            mail: "admin@admin.com",
            password: "superadmin@1322"
        },
        {
            username: "candres1019",
            mail: "andres.calderon-o@mail.escuelaing.edu.co",
            password: "Candres@1019"
        }
    ]

    return {
        getValidUsers: function (name, callback) {
            callback(null, mockdata[name]);
        }
    }

})();