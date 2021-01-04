<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm2.aspx.cs" Inherits="WebSite.WebForm2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style2 {
            height: 19px;
            width: 136px;
        }
        .auto-style4 {
            text-align: left;
        }
        .auto-style5 {
            text-align: center;
        }
        .auto-style6 {
            width: 136px;
        }
        .auto-style7 {
            text-align: right;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style5" colspan="3">ListBox示例</td>
                </tr>
                <tr>
                    <td class="auto-style7" rowspan="4">
                        <asp:ListBox ID="ListBox1" runat="server" AutoPostBack="True" Height="154px" Width="190px"></asp:ListBox>
                    </td>
                    <td class="auto-style2">
                        <asp:Button ID="Button2" runat="server" Height="27px" OnClick="Button2_Click" Text="&gt;&gt;" Width="146px" />
                    </td>
                    <td class="auto-style4" rowspan="4">
                        <asp:ListBox ID="ListBox2" runat="server" AutoPostBack="True" Height="159px" Width="178px"></asp:ListBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">
                        <asp:Button ID="Button1" runat="server" Height="28px" OnClick="Button1_Click" Text="&lt;&lt;" Width="146px" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">
                        <asp:Button ID="Button3" runat="server" Height="26px" OnClick="Button3_Click" Text="&gt;" Width="146px" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">
                        <asp:Button ID="Button4" runat="server" Height="29px" OnClick="Button4_Click" Text="&lt;" Width="146px" />
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
