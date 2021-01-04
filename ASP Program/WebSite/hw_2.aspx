<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="hw_2.aspx.cs" Inherits="WebSite.hw_2" Theme="hw2_2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 36%;
        }
        .auto-style2 {
            height: 20px;
        }
        .auto-style3 {
            width: 142px;
        }
        .auto-style4 {
            width: 170px;
        }
        .auto-style5 {
            width: 170px;
            text-align: left;
        }
        .auto-style6 {
            width: 142px;
            text-align: right;
        }
        .auto-style7 {
            width: 142px;
            text-align: right;
            height: 23px;
        }
        .auto-style8 {
            width: 170px;
            text-align: left;
            height: 23px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server" style="text-align:center">
        <div>
            <table class="auto-style1" align="center">
                <tr>
                    <td class="auto-style2" colspan="2">
                        <asp:Label ID="Label1" runat="server" Text="动态加载主题"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">
                        <asp:Label ID="Label2" runat="server" Text="选择主题："></asp:Label>
                    </td>
                    <td class="auto-style5">
                        <asp:DropDownList ID="DropDownList1" runat="server" AutoPostBack="True" OnSelectedIndexChanged="DropDownList1_SelectedIndexChanged">
                            <asp:ListItem Value="hw2_1">主题一</asp:ListItem>
                            <asp:ListItem Value="hw2_2">主题二</asp:ListItem>
                        </asp:DropDownList>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style7">
                        <asp:Label ID="Label3" runat="server" Text="默认外观："></asp:Label>
                    </td>
                    <td class="auto-style8">
                        <asp:TextBox ID="TextBox1" runat="server" SkinID="tb_1"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style7">
                        <asp:Label ID="Label4" runat="server" Text="命名外观："></asp:Label>
                    </td>
                    <td class="auto-style8">
                        <asp:TextBox ID="TextBox2" runat="server" SkinID="tb_2"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style3">
                        <asp:Button ID="Button1" runat="server" Text="Button" SkinID="btn" />
                    </td>
                    <td class="auto-style4"><a href="https://www.baidu.com">百度</a></td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
