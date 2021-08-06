'use strict';
$(document).ready(function (){
    $("#form").submit(function (e) {
        e.preventDefault();
        if($("#firstName").val()=== ""){
            swal.fire("Oops...!", 'FirstName field is mandatory', "error");
        }else if($("#lastName").val()===""){
            swal.fire("Oops...!", 'LastName field is mandatory', "error")
        } else if($("#email").val() === ""){
            swal.fire("Oops...!", 'Email field is mandatory!', "error");
        }else if($("#phoneNumber").val() ===""){
            swal.fire("Oops...!", 'Phone Number field is mandatory!', "error");
        }else  if($("#tutorCourse").val()===""){
            swal.fire("Oops...!", 'conductivity field is mandatory!', "error");
        }
        else{
            ajaxPost();
        }
        })

    function ajaxPost(){
        let formData = {
            firstName:$("#firstName").val(),
            lastName: $("#lastName").val(),
            email:$("#email").val(),
            phoneNumber:$("#phoneNumber").val(),
            tutorCourse:$("#tutorCourse").val()
        }
        $.ajax({
            type: 'POST',
            url: 'api/v1/tutors',
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
                    $("#email").val("")
                    $("#phoneNumber").val("")
                    $("#tutorCourse").val("")

                } else if(data.data === 507){
                    swal.fire("Warning", data.message, "warning");
                } else {
                    swal.fire("Error", data.message, "error");
                }
            }, error: function () {
                swal.fire("Error","Error Processing Your Application", "error");
            }
        });
    }
})
