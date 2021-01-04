<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="work1_1.aspx.cs" Inherits="WebSite.work1_1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:TextBox ID="input" runat="server" OnTextChanged="input_TextChanged"></asp:TextBox>
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="等级" />
            <asp:Label ID="Label" runat="server"></asp:Label>
        </div>
    </form>
</body>
</html>
