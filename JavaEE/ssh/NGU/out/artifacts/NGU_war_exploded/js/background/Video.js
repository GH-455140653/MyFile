window.onload = function () {
    $("#VideoManager").show();
    $("#VideoUpdate").hide();
}

function read_Img(obj) {
    var file = obj.files[0];
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function (ev) {
        $("#Viewimg").attr("src", ev.target.result);
    }
}

function read_Video(obj) {
    var file = obj.files[0];
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function (ev) {
        $("#Viewvideo").attr("src", ev.target.result);
    }
}

function ViewReset() {
    $("#Viewimg").attr("src", "#");
    $("#Viewvideo").attr("src", "#");
}

function VideoAddView_Show() {
    $("#VideoUpdate").show();
    $("#VideoManager").hide();

}

function VideoManagerView_show() {
    $("#VideoManager").show();
    $("#VideoUpdate").hide();
}