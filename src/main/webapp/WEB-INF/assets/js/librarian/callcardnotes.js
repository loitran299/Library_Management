let detailSelect;

async function init() {
    $('#popup').hide();
    getData();
    initEvents();
}

async function getData() {
    let id = $("#idCallCard").val();
    let url = `http://localhost:8080/api/call-card-detail?callCardId=${id}`;
    let response = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    renderGrid(response);
}

function renderGrid(detail) {
    $("#tbody3").empty();
    detail.map((item) => {
        let tr = $(`<tr></tr>`)
        tr.append(`<td>${item.book.code}</td>`);
        tr.append(`<td>${item.book.title.name}</td>`);
        tr.append(`<td>${item.book.status}</td>`);
        tr.append(`<td>${item.book.title.category.name}</td>`);
        tr.append(`<td>${item.book.title.author.name}</td>`);
        tr.append(`<td>${item.notes}</td>`);
        let btn = $(`<button>Ghi chú</button>`);
        btn.click(() => {
            detailSelect = {...item};
            $('#popup').show();
            $('#popup').find('textNotes').val(item.notes);
        })
        tr.append($(`<td></td>`).append(btn));
        $("#tbody3").append(tr);
    })
}

init();

function initEvents() {
    $("#btnClosePopup").click(()=> {
        $('#popup').hide();
    })

    $('#btnAddNotes').click(() => {
        addNotes();
    })
}

async function addNotes() {
    let notes = $('#textNotes').val();
    let url = `http://localhost:8080/api/call-card-detail?notes=${notes}&id=${detailSelect.id}`;
    let response = await fetch(url, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    console.log(response)
    if (response.status == 200) {
        alert(response.message);
        $('#popup').hide();
        await getData();
    }else {
        alert(response.message);
    }
}