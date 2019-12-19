$(document).ready(function() {
    $('#addBtn').click(function (event) {
        event.preventDefault();
        let catJson = JSON.stringify($('#categoryForm').serializeFormJSON())
        $.ajax({
            type: "POST",
            url: "http://127.0.0.1:9999/categories",
            data: catJson,
            contentType: "application/json",
            success: function (res) {
                console.log(res);
                let print = "<tr>";
                print += "<td>"+ res.name+"</td>" + "<td>"+ res.description+"</td>";
                print += "</tr>";
                $('#table').append(print);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest.responseJSON);
                let errObject = XMLHttpRequest.responseJSON;
                if(errObject.errorType == "ValidationError"){

                }
            }
        });
    });
});
(function ($) {
    $.fn.serializeFormJSON = function () {

        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
})(jQuery);
