function refreshToDoList(status) {
    var toDoDiv = $("#toDos");
    toDoDiv.empty();

    $.ajax({
        url: '/todo',
        method: 'GET',
        dataType: 'json',
        data: {status:status},
        success: function (data) {
            for(var key in data) {
                var item = data[key];

                var span = document.createElement("span");
                span.setAttribute("id", key);

                var elem = document.createElement("p");
                elem.innerHTML = item;

                var button = document.createElement("button");
                button.innerHTML = "delete";
                button.setAttribute("class", key);
                button.setAttribute("onclick", "deleteToDo(this)");

                var button_new = document.createElement("button");
                button_new.innerHTML = "new";
                button_new.setAttribute("class", key);
                button_new.setAttribute("onclick", "markToDo(this)");

                var button_inprogress = document.createElement("button");
                button_inprogress.innerHTML = "inprogress";
                button_inprogress.setAttribute("class", key);
                button_inprogress.setAttribute("onclick", "markToDo(this)");

                var button_done = document.createElement("button");
                button_done.innerHTML = "done";
                button_done.setAttribute("class", key);
                button_done.setAttribute("onclick", "markToDo(this)");

                elem.append(button);
                elem.append(button_done);
                elem.append(button_inprogress);
                elem.append(button_new);
                span.append(elem);
                toDoDiv.append(span);

            }
        }
    });
}



function addToDo() {
    var text = $("#text").val();

    $.ajax({
        url: '/todo',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
        data: {text:text}
    });

    refreshToDoList('all');
}

function deleteToDo(elem) {

    var id = elem.getAttribute("class");

    $.ajax({
        url: '/delete',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
        data: {id: id}
    });

    refreshToDoList('all');
}

function markToDo(elem) {
    var id = elem.getAttribute('class');
    var status =elem.innerHTML;
    console.log(status);

    $.ajax({
        url: '/mark',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
        data: {id:id,status:status}
    });

    refreshToDoList('all');
}
/*
function showInprogress() {
    var toDoDiv = $("#toDos");
    toDoDiv.empty();

    $.ajax({
        url: '/show',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            for(var key in data) {
                var item = data[key];

                var span = document.createElement("span");
                span.setAttribute("id", key);

                var elem = document.createElement("p");
                elem.innerHTML = item;

                var button = document.createElement("button");
                button.innerHTML = "delete";
                button.setAttribute("class", key);
                button.setAttribute("onclick", "deleteToDo(this)");

                var button_new = document.createElement("button");
                button_new.innerHTML = "new";
                button_new.setAttribute("class", key);
                button_new.setAttribute("onclick", "markToDo(this)");

                var button_inprogress = document.createElement("button");
                button_inprogress.innerHTML = "inprogress";
                button_inprogress.setAttribute("class", key);
                button_inprogress.setAttribute("onclick", "markToDo(this)");

                var button_done = document.createElement("button");
                button_done.innerHTML = "done";
                button_done.setAttribute("class", key);
                button_done.setAttribute("onclick", "markToDo(this)");

                elem.append(button);
                elem.append(button_done);
                elem.append(button_inprogress);
                elem.append(button_new);
                span.append(elem);
                toDoDiv.append(span);

            }
        }
    });
}*/
