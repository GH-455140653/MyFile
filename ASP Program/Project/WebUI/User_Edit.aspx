<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="User_Edit.aspx.cs" Inherits="WebUI.User_Edit" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table align="center" border="0" cellpadding="0" cellspacing="0" class="TableCss"
        style="width: 838px; height: 328px">
        <tr>
            <td colspan="1" style="font-size: 14pt; width: 480px; height: 12px"></td>
            <td colspan="3" style="font-size: 14pt; height: 12px; text-align: center">
                <br />
            </td>
            <td colspan="1" style="font-size: 14pt; width: 336px; height: 12px"></td>
        </tr>
        <tr style="font-size: 10pt">
            <td style="width: 480px; height: 28px"></td>
            <td style="width: 112px; height: 28px; text-align: right">
                <span>用户名：</span></td>
            <td style="width: 159px; height: 28px">
                <asp:Label ID="lbName" runat="server"></asp:Label></td>
            <td style="width: 255px; height: 28px"></td>
            <td style="width: 336px; height: 28px"></td>
        </tr>
        <tr style="font-size: 10pt">
            <td style="width: 480px; height: 28px"></td>
            <td style="width: 112px; height: 28px; text-align: right">
                <span>用户密码：</span></td>
            <td style="width: 159px; height: 28px">
                <asp:TextBox ID="txtp1" runat="server" Width="143px"></asp:TextBox>
            </td>
            <td style="width: 255px; height: 28px"></td>
            <td style="width: 336px; height: 28px"></td>
        </tr>
        <tr style="font-size: 10pt">
            <td style="width: 480px; height: 31px"></td>
            <td style="width: 112px; height: 31px; text-align: right">
                <span>确认密<span>码</span>：</span></td>
            <td style="width: 159px; height: 31px">
                <asp:TextBox ID="txtp2" runat="server" Width="143px"></asp:TextBox>
            </td>
            <td style="width: 255px; height: 31px">
                <asp:CompareValidator ID="CompareValidator1" runat="server" ControlToCompare="txtp2"
                    ControlToValidate="txtp1" ErrorMessage="两次密码不一致" Font-Size="10pt"></asp:CompareValidator></td>
            <td style="width: 336px; color: #000000; height: 31px"></td>
        </tr>
        <tr style="font-size: 10pt; color: #000000">
            <td style="width: 480px; height: 26px"></td>
            <td style="width: 112px; height: 26px; text-align: right">
                <span>性别：</span></td>
            <td style="width: 159px; height: 26px">
                <asp:RadioButton ID="rbtnBoy" runat="server" Checked="True" Font-Size="Small" GroupName="s"
                    Text="男" />
                <asp:RadioButton ID="rbtnGril" runat="server" Font-Size="Small" GroupName="s" Text="女" /></td>
            <td style="font-size: 12pt; width: 255px; height: 26px"></td>
            <td style="font-size: 12pt; width: 336px; height: 26px"></td>
        </tr>
        <tr style="font-size: 12pt">
            <td style="width: 480px; height: 27px"></td>
            <td style="width: 112px; height: 27px; text-align: right">
                <span style="font-size: 10pt">年龄：</span></td>
            <td style="width: 159px; height: 27px">
                <asp:TextBox ID="txtAge" runat="server"></asp:TextBox></td>
            <td style="width: 255px; height: 27px"></td>
            <td style="width: 336px; height: 27px"></td>
        </tr>
        <tr>
            <td style="width: 480px; height: 21px"></td>
            <td style="width: 112px; height: 21px; text-align: right">
                <span style="font-size: 10pt">头像：</span></td>
            <td style="width: 159px; height: 21px">
                <asp:DropDownList ID="drPhoto" runat="server" AutoPostBack="True"
                    Width="154px" OnSelectedIndexChanged="drPhoto_SelectedIndexChanged">
                    <asp:ListItem Selected="True">01.jpg</asp:ListItem>
                    <asp:ListItem>02.jpg</asp:ListItem>
                    <asp:ListItem>03.jpg</asp:ListItem>
                    <asp:ListItem>04.jpg</asp:ListItem>
                    <asp:ListItem>05.jpg</asp:ListItem>
                    <asp:ListItem>06.jpg</asp:ListItem>
                    <asp:ListItem>07.jpg</asp:ListItem>
                </asp:DropDownList>
            </td>
            <td style="width: 255px; height: 21px"></td>
            <td style="width: 336px; height: 21px"></td>
        </tr>
        <tr>
            <td style="width: 480px; height: 71px"></td>
            <td style="width: 112px; height: 71px; text-align: right"></td>
            <td colspan="1" style="width: 159px; height: 71px; text-align: center">
                <asp:Image ID="imgUser" runat="server" ImageUrl="~/images/Photo/01.jpg" /></td>
            <td colspan="1" style="width: 255px; height: 71px; text-align: center"></td>
            <td colspan="1" style="width: 336px; height: 71px; text-align: left"></td>
        </tr>
        <tr>
            <td style="width: 480px"></td>
            <td style="width: 112px; text-align: right">
                <span style="font-size: 10pt">Email：</span></td>
            <td colspan="1" style="width: 159px; text-align: left">
                <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox></td>
            <td colspan="1" style="width: 255px; text-align: left"></td>
            <td colspan="1" style="width: 336px; text-align: left"></td>
        </tr>
        <tr>
            <td style="width: 480px; height: 23px"></td>
            <td style="width: 112px; height: 23px; text-align: right">
                <span style="font-size: 10pt">联系地址：</span></td>
            <td colspan="1" style="width: 159px; height: 23px; text-align: left">
                <asp:TextBox ID="txtAddr" runat="server" Font-Size="10pt"></asp:TextBox></td>
            <td colspan="1" style="width: 255px; height: 23px; text-align: left"></td>
            <td colspan="1" style="width: 336px; height: 23px; text-align: left"></td>
        </tr>
        <tr>
            <td style="width: 480px; height: 19px"></td>
            <td style="width: 112px; height: 19px">角色提升：</td>
            <td colspan="1" style="width: 159px; height: 19px; text-align: left">
                <asp:RadioButton ID="rbtnAdmin" runat="server" GroupName="b" Text="管理员" />
                <asp:RadioButton ID="rbtnBz" runat="server" GroupName="b" Text="版主" /></td>
            <td colspan="1" style="width: 255px; height: 19px; text-align: left"></td>
            <td colspan="1" style="width: 336px; height: 19px; text-align: left"></td>
        </tr>
        <tr>
            <td style="width: 480px; height: 37px"></td>
            <td style="width: 112px; height: 37px"></td>
            <td colspan="1" style="width: 159px; height: 37px; text-align: left">&nbsp; &nbsp; &nbsp;
                <asp:Button ID="btnAdd" runat="server" Text="修改" OnClick="btnAdd_Click" />
                &nbsp;
                <asp:Button ID="btnCancel" runat="server" CausesValidation="False" OnClick="btnCancel_Click"
                    Text="取消" /></td>
            <td colspan="1" style="width: 255px; height: 37px; text-align: left"></td>
            <td colspan="1" style="width: 336px; height: 37px; text-align: left"></td>
        </tr>
        <tr>
            <td style="width: 480px; height: 34px"></td>
            <td style="width: 112px; height: 34px"></td>
            <td colspan="1" style="width: 159px; height: 34px; text-align: left"></td>
            <td colspan="1" style="width: 255px; height: 34px; text-align: left"></td>
            <td colspan="1" style="width: 336px; height: 34px; text-align: left"></td>
        </tr>
    </table>

</asp:Content>
