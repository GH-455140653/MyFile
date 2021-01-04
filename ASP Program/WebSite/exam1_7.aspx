<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="exam1_7.aspx.cs" Inherits="WebSite.exam1_7" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 80%;
            height: 503px;
        }
        .auto-style2 {
            width: 392px;
        }
        .auto-style3 {
            width: 392px;
            height: 55px;
        }
        .auto-style4 {
            width: 392px;
            height: 32px;
        }
        .auto-style5 {
            height: 40px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1" style="margin:auto" border="1">
                <tr>
                    <td colspan="2" style="text-align:center" class="auto-style5">文件上传示例</td>
                </tr>
                <tr>
                    <td class="auto-style3">
                        <asp:FileUpload ID="FileUpload1" runat="server" Width="201px" />
                        &nbsp;&nbsp;
                        <asp:Button ID="btn_submit" runat="server" Height="20px" OnClick="btn_submit_Click" Text="提交" />
                        <br />
                    </td>
                    <td rowspan="3">
                        <asp:Image ID="photo" runat="server" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4">
                        <asp:Label ID="fileMsg" runat="server"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style2">
                        <asp:BulletedList ID="RBL_file" runat="server" DisplayMode="LinkButton" OnClick="RBL_file_Click">
                        </asp:BulletedList>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
