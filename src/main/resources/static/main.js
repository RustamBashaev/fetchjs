/**
 *
 */

// $('document').ready(function() {
//
//     $('.table .btn').on('click',function(event) {
//
//         event.preventDefault();
//
//         var href = $(this).attr('href');
//
//         $.get(href, function (user, status) {
//             $('#idEdit').val(user.id);
//             $('#nameEdit').val(user.name);
//             $('#surnameEdit').val(user.surname);
//             // $('#ageEdit').val(user.age);
//             $('#emailEdit').val(user.email);
//             $('#passwordEdit').val(user.password);
//         });
//
//         $('#editModal').modal();
//     });
// });

// const url = 'https://jsonplaceholder.typicode.com/todos'

const tableUsers = document.getElementById('allUsers')
const editButton = document.getElementById('btnEdit')
const deleteButton = document.getElementById('btnDelete')


const url = 'http://localhost:8888/admin/allUsers'

const users = []

console.log('8888', tableUsers)


const getAllUsers = async () => {
    try {
        const response = await fetch(url)
         return response.json()

    } catch(e) {
        console.error(e)
    }
}

getAllUsers().then(data => {
    users.push(...data)
    const uuu = data.map(user => createRows(user))
    tableUsers.innerHTML = uuu
   // console.log('uuu', uuu)
})

console.log('users', users)

const editUser = (id) => {
    //console.log('editButton', document.getElementById('btnEdit'))
    console.log('event.target.id', id)
}

const removeUse = (sadfsa) => {
    console.log("sadfsa", sadfsa)
}

function createRows(user) {



    const id = user.id

    console.log('removeUse(user.id)', removeUse(id))

    let user_data = '<tr id="btnEdit" id=' + user.id + '>';
    user_data += '<td>' + user.id + '</td>';
    user_data += '<td>' + user.name + '</td>';
    user_data += '<td>' + user.surname + '</td>';
    user_data += '<td>' + user.email + '</td>';
    user_data += '<td>';
    let roles = user.authorities;
    for (let role of roles) {
        user_data += role.name.replace('ROLE_', '') + ' ';
    }
    user_data += '</td>' +
        '<td>' + '<input onclick="editUser(this.id)" value="Edit" type="button" ' +
        'class="btn-info btn edit-btn" data-toggle="modal" data-target="#editModal" ' +
        'data-id="' + user.id + '">' + '</td>' +

        '<td>' + '<input id="btnDelete" value="Delete" type="button" class="btn btn-danger del-btn" ' +
        'data-toggle="modal" data-target="#deleteModal" data-id=" ' + user.id + ' ">' + '</td>';
    user_data += '</tr>';

    return user_data;
}




