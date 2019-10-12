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

$(document).ready(function() {


	$("#bookBtn").click(function(event){
		event.preventDefault();
//$("#bookForm").serializeFormJSON();
// {name: "Spring MVC", isbn: "111"}
//		JSON.stringify
		//{"name": "Spring MVC", "isbn" : "111"}
		let bookJSON = JSON.stringify($("#bookForm").serializeFormJSON());

		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:9999/books",
			data: bookJSON,
			contentType: "application/json",
			dataType: "json",
			success: function(result){
				console.log('success');
				console.log(result);
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
				console.log('error');
				let errorObj = XMLHttpRequest.responseJSON;
				if(errorObj.errorType === 'ValidationError'){
					let errorArray = errorObj.fieldErrors;

					let errorMessage = "<p>";

					$.each(errorArray, function(index, e){
							errorMessage = errorMessage + e.field +" : " + e.message;
					});
					errorMessage += "</p>";

					$('#result').append(errorMessage);

				}else{
					alert("error happened not because of validation")
				}


			}
		});

	});


	$("#categorySubmitBtn").click(function() {
				
		let data = JSON.stringify($("#categoryForm").serializeFormJSON());
		$.ajax({
			type : "POST",
			url : "http://127.0.0.1:9999/api/addCategory",
			data : data,
			contentType: "application/json",
			dataType : "json",
			success : function(data){
				$("#categoryForm")[0].reset();
				$("#result").empty();
				$('#result').append('<H3 align="center"> OK!! <H3><p>').show();
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				console.log(XMLHttpRequest.responseJSON);
				$("#result").empty();
				
				if (XMLHttpRequest.responseJSON.errorType == "ValidationError") {
					let errorMsg = '<h3> Error(s)!! </h3>';
					errorMsg += "<p>";
					var errorList = XMLHttpRequest.responseJSON.fieldErrors;
					$.each(errorList, function(i, error) {
						errorMsg = errorMsg +error.message + '<br>';
					});
					errorMsg += '</p>';
					$('#result').append(errorMsg);
					$('#result').show();
				} else {
					alert(errorObject.responseJSON.errors(0)); // "non" Validation
				}
			}
		});
	});
});