var url = document.URL;
var title = document.title;
$(document).ready(function () {
    $("#btnFav").click(function () {
        var ctrl = (navigator.userAgent.toLowerCase()).indexOf('mac') !== -1 ? 'Command/Cmd' : 'CTRL';
        if (document.all) {
            window.external.addFavorite(url, title);
            alert('收藏成功');
        } else if (window.sidebar) {
            window.sidebar.addPanel(title, url, "");
            alert('收藏成功');
        } else {
            alert('您可以通过快捷键' + ctrl + ' + D 加入到收藏夹');
        }
    })
})