'use strict';
$(document).ready(function (){
    $("#form").submit(function (e) {
        e.preventDefault();
        if($("#firstName").val()=== ""){
            swal.fire("Oops...!", 'First Name field is mandatory', "error");
        }else if($("#lastName").val() === ""){
            swal.fire("Oops...!", 'Last Name field is mandatory!', "error");
        }else if($("#studentNumber").val() ===""){
            swal.fire("Oops...!", 'Student Number field is mandatory!', "error");
        }else  if($("#email").val()===""){
            swal.fire("Oops...!", 'email field is mandatory!', "error");
        }else  if($("#phoneNumber").val()===""){
            swal.fire("Oops...!", 'Phone Number field is mandatory!', "error");
        }
        else{
            ajaxPost();
        }
    })

    function ajaxPost(){
        let formData = {
            firstName: $("#firstName").val(),
            lastName:$("#lastName").val(),
            studentNumber:$("#studentNumber").val(),
            email:$("#email").val(),
            phoneNumber:$("#phoneNumber").val()
        }
        console.log(formData);
        $.ajax({
            type: 'POST',
            url: 'api/v1/students',
            data:JSON.stringify(formData),
            dataType:"json",
            processData: false,
            contentType: "application/json",
            success: function (data) {

                if (data.status === "success") {
                    swal.fire({
                        title:"Done",
                        text:data.message,
                        type:"success"

                    }).then((result) => {
                        // Reload the Page
                        location.reload();
                    });
                     $("#firstName").val("")
                     $("#lastName").val("")
                     $("#studentNumber").val("")
                     $("#email").val("")

                } else if(data.data === 507){
                    swal.fire("Info", data.message, "info");
                }
                else {
                    swal.fire("Error", data.message, "error");
                }
            }, error: function () {
                swal.fire("Error", data.message, "error");
            }
        });
    }
})