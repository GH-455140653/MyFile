//用户管理全选
function usersCheckedAll() {
    var arr = document.getElementsByName('userChecked');
    var ck = document.getElementById('selectAll');
    // for (var i in arr) {
    //     arr[i].checked = ck.checked; // 全选
    // }
    for (let item of arr) {
        item.checked = ck.checked;
    }
}

//删除选中
function DeleteSelectMember() {
    var account = "";
    var a = document.getElementsByName("Userche");
    for (var i = 0; i < a.length; i++) {
        if (a[i].checked) {
            let temp = a[i].value;
            account = account + "," + temp;
        }
    }
    document.getElementById("tempString").value = account.substring(1, account.length);
    document.getElementById('deleteForm').action = "User/member_deleteSelectMember";
    document.getElementById("deleteForm").submit();
}

//昵称模糊搜索
function searchMember() {
    if ($('#searchInput').val() === "") {
        alert("请输入用户昵称！");
        return false;
    } else {
        return true;
    }
}