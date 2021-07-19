"use strict";

//getEmployees
function getAllTasks() {
    $.ajax({
        url: 'api/v1/tutors',
        type: 'GET',
        success: function (response) {
            let trHTML = '';
            console.log(response);
            $.each(response, function (i, item) {
                trHTML += '<tr><td>' + item.firstName + '</td><td>' + item.lastName + '</td><td>' + item.tutorCourse + '</td>' +
                    '<td>' +
                    '<a href="api/v1/tutors/'+item.id+' " ><button class="btn btn-info"><i class="fa fa-edit"></i></i> View</button></a>'
                    +
                    '<a href="api/v1/tutors/'+item.id+' " ><button class="btn btn-info"><i class="fa fa-edit"></i></i> Choose Tutor</button></a>'
                    +
                    '</td></tr>';
            });
            $('#childrenTask').append(trHTML);
        }
    });
}



//Loading temp employee
$(document).ready(function () {
    getAllTasks();
});