<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm.aspx.cs" Inherits="WebUI.WebForm" %>
<%@ Register TagPrefix="ftb" Namespace="FreeTextBoxControls" Assembly="FreeTextBox" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <ftb:FreeTextBox ID="FreeTextBox1" runat="server" ></ftb:FreeTextBox> 
            <br />
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Button" />
            <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
            <br />
            <br />
            <asp:GridView ID="GridView1" runat="server">
            </asp:GridView>
            <br />
        </div>
    </form>
</body>
</html>
