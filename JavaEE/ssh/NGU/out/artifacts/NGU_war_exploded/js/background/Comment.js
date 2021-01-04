//评论管理全选
function commentCheckAll(id){
    var arr=document.getElementsByName('Ccheck');
    var ck=document.getElementById('Cselectall');
    for(i in arr){
        arr[i].checked=ck.checked; // 全选
        //arr[i].checked=!arr[i].checked; 反向全选
    }
}
function DeleteSelectMember() {
    var account = "";
    var temp = "";
    var a = document.getElementsByName("Ccheck");
    for (var i = 0; i < a.length; i++) {
        if (a[i].checked) {
            temp = a[i].value;
            account = account + "," + temp;
        }
    }
    document.getElementById("tempString").value = account.substring(1, account.length);
    document.getElementById('deleteForm').action = "Comment/comment_deleteSelectMember";
}
