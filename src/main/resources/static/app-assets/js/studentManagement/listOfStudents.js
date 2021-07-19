"use strict";

//getEmployees
function getAllTasks() {
    $.ajax({
        url: 'api/v1/students',
        type: 'GET',
        success: function (response) {
            let trHTML = '';
            console.log(response);
            $.each(response, function (i, item) {
                trHTML += '<tr><td>' + item.firstName + '</td><td>' + item.lastName + '</td><td >' + item.studentNumber + '</td>' +
                    '<td>'
                    +
                    '<button value="'+ item.id +'"  data-toggle="modal" data-target="#default" id="view" class="btn btn-info"><i class="fa fa-edit"></i></i> View</button>'
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

