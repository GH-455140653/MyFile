<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="exam1_5.aspx.cs" Inherits="WebSite.exam1_4" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Text="学院："></asp:Label>
            <asp:DropDownList ID="DLCollege" runat="server" AutoPostBack="True" OnSelectedIndexChanged="DLCollege_SelectedIndexChanged">
            </asp:DropDownList>
            <asp:Label ID="Label2" runat="server" Text="班级："></asp:Label>
            <asp:DropDownList ID="DLClass" runat="server" AutoPostBack="True" OnSelectedIndexChanged="DLClass_SelectedIndexChanged" OnTextChanged="DLClass_TextChanged">
            </asp:DropDownList>
            <asp:Label ID="Label3" runat="server" Text="姓名："></asp:Label>
            <asp:DropDownList ID="DLName" runat="server" AutoPostBack="True" OnTextChanged="DLName_TextChanged">
            </asp:DropDownList>
            <asp:Label ID="lb" runat="server"></asp:Label>
        </div>
    </form>
</body>
</html>
