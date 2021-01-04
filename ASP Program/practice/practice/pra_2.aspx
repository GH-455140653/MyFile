<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="pra_2.aspx.cs" Inherits="practice.pra_2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Text="姓名"></asp:Label>
            <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="TextBox1" EnableClientScript="False">姓名不能为空</asp:RequiredFieldValidator>
            <br />
            <asp:Label ID="Label2" runat="server" Text="性别"></asp:Label>
            <asp:DropDownList ID="DropDownList1" runat="server" Width="146px">
                <asp:ListItem>请选择</asp:ListItem>
                <asp:ListItem>男</asp:ListItem>
                <asp:ListItem>女</asp:ListItem>
            </asp:DropDownList>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="DropDownList1" EnableClientScript="False" InitialValue="请选择">性别不能为空</asp:RequiredFieldValidator>
            <br />
            <asp:Button ID="Button1" runat="server" Text="提交" OnClick="Button1_Click" />
        </div>
    </form>
</body>
</html>
