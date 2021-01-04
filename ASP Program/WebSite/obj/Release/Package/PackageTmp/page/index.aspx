<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="index.aspx.cs" Inherits="WebSite.index" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 44%;
        }
        .mystyle{
            background-color:aquamarine
        }
        .auto-style2 {
            height: 20px;
        }
        .auto-style3 {
            width: 225px;
        }
        .auto-style4 {
            height: 20px;
            width: 225px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:CheckBox ID="cb1" runat="server" OnCheckedChanged="CheckBox1_CheckedChanged" Text="选择" CssClass="mystyle" />
        </div>
        <table class="auto-style1">
            <tr>
                <td class="auto-style3">
                    &nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style4">
                    <asp:Literal ID="Literal1" runat="server" Text="姓名："></asp:Literal>
                </td>
                <td class="auto-style2">
                    <asp:Button ID="Button1" runat="server" Text="确定" Width="53px" Height="20px" PostBackUrl="~/page_2.aspx" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
