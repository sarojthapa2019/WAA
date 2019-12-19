$(document).ready(function(){

    let sel = document.getElementById("catSelect");
   $.get("http://127.0.0.1:8080/categories").done(function (res) {
       console.log(res);
       $.each(res, function (index, val) {
           let option = document.createElement("option");
           option.text=val.categoryName;
           option.value=val.id;
           sel.add(option);
       })

   }).fail(function (err) {
        console.log(err);
   });

   $('#addBtn').click(function(event){
      event.preventDefault();
      let formData = JSON.stringify($('#bookForm').serializeFormJSON());
      console.log(formData);
      $.ajax({"url":"http://127.0.0.1:8080/book",
          "data":formData,
          contentType: "application/json",
          type:"POST"
      }).done(function (res) {
          console.log(res);
          let   print = "";
          $.each(res, function (index, val) {
                print +="<tr>";
              print += "<td>"+ index + "</td>";
              print +=  "<td>" + val.name +"</td>";
              print += "<td>"+ val.author +"</td>";
              print += "<td>";
              $.each(val.categoryList, function (i, v) {
                  print += "<span>"+ v.categoryName +"</span>";
              });
              print += "</td>";
                let url = "/book/detail/"+val.id;
              print += "<td><a href="+url+">Details</a></td>";
              print += "</tr>";
          });

          $('#table').append(print);
      }).fail(function (err,e,ex) {
          console.log(err);

          let errorObject = err.responseJSON;
          if(errorObject.errorType == "ValidationError"){
             let errArr = errorObject.errors;
             let e="<p>";
             $.each(errArr, function(index, value){
                  e +=  value.field+ " :"+value.message;
             });
             e += "</p>";
             $('#error').append(e);
          }
          else{
              $('#error').append("Other Errors!!");
          }

      });

   });

    $.ajax({"url":"http://localhost:8080/book", "type":"GET", contentType:"application/json",
        success: function(res) {
            console.log(res);
            let   print = "";
            $.each(res, function (index, val) {
                print +="<tr>";
                print += "<td>"+ index + "</td>";
                print +=  "<td>" + val.name +"</td>";
                print += "<td>"+ val.author +"</td>";
                print += "<td>";
                $.each(val.categoryList, function (i, v) {
                    print += "<span>"+ v.categoryName +"</span>";
                });
                print += "</td>";
                let url = "/book/detail/"+val.id;
                print += "<td><a href="+url+">Details</a></td>";
                print += "</tr>";
            });

            $('#table').append(print);
        },
        error:function (e) {
            
        }
});

});
(function ($) {
    $.fn.serializeFormJSON = function () {

        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if(this.name=='categoryList') {
                let categoryList = [];
                $('#catSelect :selected').each(function (i, sel) {
                    categoryList[i] = {"id": parseInt($(sel).val())};
                });
                o['categoryList'] = categoryList;
            }
            else {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            }
        });
        return o;
    };
})(jQuery);
