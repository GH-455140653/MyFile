<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="pra_3.aspx.cs" Inherits="practice.pra_3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            进货价格：<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
            <br />
            <br />
            出货价格：<asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
            <asp:CompareValidator ID="CompareValidator1" runat="server" ControlToCompare="TextBox1" ControlToValidate="TextBox2" ErrorMessage="CompareValidator" Operator="GreaterThanEqual" Type="Integer">比较不通过</asp:CompareValidator>
            <br />
            <asp:Button ID="Button1" runat="server" Text="提交" />
            <br />
        </div>
    </form>
</body>
</html>
