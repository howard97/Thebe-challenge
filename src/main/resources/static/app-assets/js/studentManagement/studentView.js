
$(document).on('click', '#view', function () {
    getStudentData();
});

let firstName = $("#firstName");
let lastName = $("#lastName");
let studentNumber=$("#studentNumber");
let email=$("#email");
let phoneNumber=$("#phoneNumber");

function getStudentData(){
    let view= $("#view").val();
    console.log(view);
    let url="api/v1/students/" + view;
    $.get(url, function (responseJson){
        console.log(responseJson);
        //Loop through the response
        $.each(responseJson, function (index, student){
            $("#firstName").val(student.firstName).text(student.firstName).append(firstName);
            $("#lastName").val(student.lastName).text(student.lastName).append(lastName);
            $("#studentNumber").val(student.studentNumber).text(student.studentNumber).append(studentNumber);
            $("#email").val(student.email).text(student.email).append(email);
            $("#phoneNumber").val(student.phoneNumber).text(student.phoneNumber).append(phoneNumber);
        });

    }).done(function (){

    }).fail(function (){

    });
}

