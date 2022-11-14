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

    getData(){
        let me = this;
        let list = me.combobox.find('#list');
        list.empty();
        for(let i = 0; i < 3; i++) {
            let item = $(`<div class="item">item ${i}</div>`);
            item.click(() => {
                me.combobox.find('input').val(`item ${i}`);
                me.combobox.find('#list').toggle();
            })
            list.append(item)
        }

    }
}

let myCombobox = new Combobox("combobox");