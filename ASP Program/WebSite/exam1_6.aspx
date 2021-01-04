<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="exam1_6.aspx.cs" Inherits="WebSite.exam_6" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:PlaceHolder ID="PlaceHolder1" runat="server"></asp:PlaceHolder>
        <div>
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="提交" />
            <asp:Label ID="Label1" runat="server"></asp:Label>
        </div>
    </form>
</body>
</html>
