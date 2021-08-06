$(document).on('click', '#submitB1', function () {
    console.log("clicked button")
    let tutorId = $('#tutorId').val();
    if(tutorId === ""){
        swal("Warning", "Please Select Tutor", "warning");
        return;
    }


    swal({
        title: "Warning",
        text: "Are you sure you want to submit this initiation to be rejected?",
        type: "warning",
        showCancelButton: true,
        confirmButtonClass: "btn-danger",
        confirmButtonText: "Yes, Proceed",
        cancelButtonText: "No, cancel",
        closeOnConfirm: false,
        closeOnCancel: true,

    }, function (isConfirm) {
        if (isConfirm) {

            let formData = {
                tutorId : $("#tutorId").val(),
                studentId: $("#studentId").val(),

            }

            console.log(formData)

            $.ajax({
                type: 'POST',
                url: 'assignTutorToStudent?studentId?tutorId',
                data:JSON.stringify(formData),
                dataType:"json",
                processData: false,
                contentType: "application/json",
                success: function (data) {

                    if (data.status === "success") {
                        swal({
                            title:"Done",
                            text:data.message,
                            type:"success"

                        });

                    } else if(response.data === 507) {
                        swal({title: "Oops!",
                            text: response.message,
                            type:"warning",
                            confirmButtonClass: 'btn btn-info',
                            confirmButtonText: "Ok",
                            buttonsStyling: false,
                            closeOnConfirm: true
                        }, function(){
                            window.location.reload(true);
                        });
                    } else {
                        swal("Error", data.message, "error");
                    }
                }, error: function () {
                    swal("Error", data.message, "error");
                }
            });
        }
    });
});