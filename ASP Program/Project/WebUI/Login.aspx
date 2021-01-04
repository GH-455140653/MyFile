<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="WebUI.Login" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
        .auto-style3 {
            margin-bottom: 0px;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table align="center" border="0" cellpadding="0" cellspacing="0" class="TableCss"
        style="font-size: small; width: 798px; height: 199px; text-align: center">
        <tr>
            <td colspan="1" style="font-size: 14pt; width: 269px; height: 30px">
            </td>
            <td colspan="2" style="font-size: 14pt; height: 30px; text-align: center">
                <br />
                <span style="color: #0099ff"></span>
            </td>
            <td colspan="1" style="font-size: 14pt; width: 336px; height: 30px">
            </td>
        </tr>
        <tr>
            <td style="width: 269px; height: 27px">
            </td>
            <td style="width: 82px; height: 27px; text-align: right">
                <span style="font-size: 10pt">用户名：</span></td>
            <td style="width: 174px; height: 27px">
                <asp:TextBox ID="txtName" runat="server" Font-Size="10pt" Width="147px"></asp:TextBox></td>
            <td style="width: 336px; height: 27px; text-align: left">
                <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="txtName"
                    ErrorMessage="*用户名不能为空"></asp:RequiredFieldValidator></td>
        </tr>
        <tr style="color: #000000">
            <td style="width: 269px; height: 28px">
            </td>
            <td style="width: 82px; height: 28px; text-align: right">
                <span style="font-size: 10pt">密码：</span></td>
            <td style="width: 174px; height: 28px; text-align: center">
                <asp:TextBox ID="txtPswd" runat="server" TextMode="Password" Width="147px"></asp:TextBox></td>
            <td style="width: 336px; height: 28px; text-align: left">
                <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="txtPswd"
                    ErrorMessage="*密码不能为空"></asp:RequiredFieldValidator></td>
        </tr>
        <tr>
            <td style="width: 269px; height: 29px">
            </td>
            <td style="width: 82px; height: 29px; text-align: right">
                验证码：</td>
            <td colspan="1" style="width: 174px; height: 29px; text-align: center">
                <asp:TextBox ID="txtCode" runat="server" Width="145px"></asp:TextBox></td>
            <td colspan="1" style="width: 336px; height: 29px; text-align: left">
                <asp:ImageButton ID="IbtnCode" runat="server" ImageUrl="~/ValidateCode.aspx" OnClick="ImageButton1_Click" />
                <asp:Button ID="Button1" runat="server" Font-Size="Small" ForeColor="Blue" Text="看不清？点击换一张" OnClick="Button_1" style="background-color:transparent;border:0" CssClass="auto-style3" Width="130px" />
                <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="txtCode"
                    ErrorMessage="*请输入验证码"></asp:RequiredFieldValidator></td>
        </tr>
        <tr>
            <td style="width: 269px; height: 25px">
            </td>
            <td style="width: 82px; height: 25px">
            </td>
            <td colspan="1" style="width: 174px; height: 25px; text-align: left">
                &nbsp; &nbsp; &nbsp;
                <asp:Button ID="btnLogin" runat="server" OnClick="btnLogin_Click" Text="登录" />
                &nbsp;
                <asp:Button ID="btnCancel" runat="server" CausesValidation="False" OnClick="btnCancel_Click"
                    Text="取消" /></td>
            <td colspan="1" style="width: 336px; height: 25px; text-align: left">
                <asp:Label ID="lbError" runat="server" ForeColor="Red"></asp:Label></td>
        </tr>
        <tr>
            <td style="width: 269px; height: 34px">
            </td>
            <td style="width: 82px; height: 34px">
            </td>
            <td colspan="1" style="width: 174px; height: 34px; text-align: left">
            </td>
            <td colspan="1" style="width: 336px; height: 34px; text-align: left">
            </td>
        </tr>
    </table>

</asp:Content>
