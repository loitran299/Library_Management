var books = {}

async function initAddBook() {
    let url = "http://localhost:8080/api/books";
    let response = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    }).then((responses) => {return responses.json()}).then((results) => {return results});
    const htmls = response.map((item) => {
        return `<tr>
                    <td>${item.code}</td>
                    <td>${item.title.name}</td>
                    <td>${item.status}</td>
                    <td>${item.title.category.name}</td>
                    <td>
                        <a href="">Chi tiết</a>
                    </td>
                    <td>
                        <button class="btn-page" onclick="addBook(${item})">Thêm</button>
                    </td>
            </tr>`
    })
    $("#tbody1").append(htmls);
}
initAddBook();

function addBook(item) {
    books.add(item);
    renderChooseBook();
}

function  renderChooseBook() {
    let htmls = books.map((item) => {
        return `<tr>
                    <td>${item.code}</td>
                    <td>${item.title.name}</td>
                    <td>${item.status}</td>
                    <td>${item.title.category.name}</td>
                    <td>
                        <a href="" class="btn-page bg-red">Xóa</a>
                    </td>
                </tr>`;
    })
    $("#tbody2").remove();
    $("#tbody2").append(htmls);
}