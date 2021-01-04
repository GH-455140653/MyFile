<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="work1_3.aspx.cs" Inherits="WebSite.work1_3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="output" runat="server"></asp:Label>
        </div>
    <div>
        <asp:TextBox ID="input" runat="server"></asp:TextBox>
        <asp:Button ID="Button" runat="server" OnClick="Button_Click" Text="降序" />
    </div>
    </form>
    </body>
</html>
