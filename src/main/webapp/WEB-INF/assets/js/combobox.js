class Combobox{
    constructor(id) {
        let me = this;

        me.combobox = $(`#${id}`);

        me.combobox.find('#list').hide();

        me.getData();
        me.initEvents();
    }

    initEvents() {
        let me = this;
        me.combobox.find('input').click(() => {
            me.combobox.find('#list').toggle();
        })
    }

    async getData(){
        let me = this;
        let url = me.combobox.attr("urls");
        let response = await fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            }
        }).then((responses) => {return responses.json()}).then((results) => {return results});
        let list = me.combobox.find('#list');
        list.empty();
        response.map((reader) => {
            let item = $(`<div class="item">${reader.fullName}-${reader.code}</div>`);
            item.click(() => {
                let input = me.combobox.find('input');
                input.val(`${reader.fullName}-${reader.code}`);
                input.attr("readerID", reader.id);
                me.combobox.find('#list').toggle();
                $('#readerCode').find('span').text(reader.code)
                $('#readerName').find('span').text(reader.fullName)
            })
            list.append(item)
        })
    }
}

let myCombobox = new Combobox("combobox");