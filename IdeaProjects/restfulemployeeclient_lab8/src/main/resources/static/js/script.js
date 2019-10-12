$(document).ready(function () {
    $('#addBtn').click(function (event) {

       event.preventDefault();
       let empJson = JSON.stringify($('#employeeForm').serializeFormJSON());
       $.ajax({
           type:"POST",
           url:"http://127.0.0.1:8080/employee",
           data:empJson,
           contentType:"application/json",
           success: function (res) {
               console.log(res);
               let printResult = "<p> New Employee Information <br/> <br/>";
               printResult += "First Name: "+ res.firstName + " <br/>" + " Last Name: "+ res.lastName+
                   " <br/>" + "Email: "+ res.email;
               printResult += "</p>";
               $('#result').append(printResult);
           },
           error: function (XMLHttpRequest, textStatus, errorThrown) {
               console.log('error');
               let errorObject = XMLHttpRequest.responseJSON;
               if(errorObject.errorType == "ValidationError"){
                   console.log(errorObject);
                   let errorArray = errorObject.errors;

                   let printError = "<p>";
                   $.each(errorArray, function (index, err) {
                       printError = printError + err.field + " : " + err.message;
                   });
                   printError += "</p>";
                   $('#result').append(printError);
               }
               else{
                   alert("Other error");
               }
           }
       })
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
