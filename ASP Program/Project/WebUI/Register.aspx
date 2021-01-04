<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="WebUI.Register" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
        .auto-style7 {
            width: 480px;
            height: 27px;
        }
        .auto-style8 {
            width: 112px;
            height: 27px;
        }
        .auto-style9 {
            width: 159px;
            height: 27px;
        }
        .auto-style10 {
            width: 255px;
            height: 27px;
        }
        .auto-style11 {
            width: 336px;
            height: 27px;
        }
        .auto-style12 {
            width: 159px;
        }
    .auto-style13 {
        width: 403px;
        height: 31px;
    }
    .auto-style14 {
        width: 112px;
        height: 31px;
    }
    .auto-style15 {
        width: 159px;
        height: 31px;
    }
    .auto-style16 {
        width: 255px;
        height: 31px;
    }
    .auto-style17 {
        width: 336px;
        height: 31px;
    }
    .auto-style18 {
        height: 12px;
        width: 403px;
    }
    .auto-style19 {
        height: 28px;
        width: 403px;
    }
    .auto-style20 {
        height: 26px;
        width: 403px;
    }
    .auto-style21 {
        width: 403px;
        height: 20px;
    }
    .auto-style22 {
        height: 22px;
        width: 403px;
    }
    .auto-style23 {
        height: 71px;
        width: 403px;
    }
    .auto-style24 {
        width: 403px;
    }
    .auto-style25 {
        height: 23px;
        width: 403px;
    }
    .auto-style26 {
        height: 19px;
        width: 403px;
    }
    .auto-style27 {
        height: 37px;
        width: 403px;
    }
    .auto-style28 {
        height: 34px;
        width: 403px;
    }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table align="center" border="0" cellpadding="0" cellspacing="0" class="TableCss"
        style="width: 838px; height: 328px">
        <tr>
            <td colspan="1" style="font-size: 14pt; " class="auto-style18"></td>
            <td colspan="3" style="font-size: 14pt; height: 12px; text-align: center">
                <br />
            </td>
            <td colspan="1" style="font-size: 14pt; width: 336px; height: 12px"></td>
        </tr>
        <tr style="font-size: 10pt">
            <td class="auto-style19"></td>
            <td style="width: 112px; height: 28px; text-align: right">
                <span>用户名：</span></td>
            <td style="width: 159px; height: 28px">
                <asp:TextBox ID="txtName" runat="server" Font-Size="10pt" Width="150px"></asp:TextBox></td>
            <td style="width: 255px; height: 28px">
                <asp:CustomValidator ID="CustomValidator1" runat="server" ControlToValidate="txtName" ErrorMessage="用户名已存在" OnLoad="CustomValidator1_Load" OnInit="CustomValidator1_Init" OnServerValidate="CustomValidator1_ServerValidate" SetFocusOnError="True"></asp:CustomValidator>
            </td>
            <td style="width: 336px; height: 28px"></td>
        </tr>
        <tr style="font-size: 10pt">
            <td class="auto-style19"></td>
            <td style="width: 112px; height: 28px; text-align: right">
                <span>用户密码：</span></td>
            <td style="width: 159px; height: 28px">
                <asp:TextBox ID="txtPswd" runat="server" TextMode="Password" Width="150px"></asp:TextBox></td>
            <td style="width: 255px; height: 28px">
                <asp:RequiredFieldValidator runat="server" ControlToValidate="txtPswd" ErrorMessage="密码不能为空"></asp:RequiredFieldValidator>
            </td>
            <td style="width: 336px; height: 28px"></td>
        </tr>
        <tr style="font-size: 10pt">
            <td class="auto-style13"></td>
            <td style="text-align: right" class="auto-style14">
                <span>确认密<span>码</span>：</span>

            </td>
            <td class="auto-style15">
                <asp:TextBox ID="txtPswd2" runat="server" TextMode="Password" Width="150px"></asp:TextBox>
            </td>
            <td class="auto-style16">
                <asp:CompareValidator ID="CompareValidator1" runat="server" ControlToCompare="txtPswd"
                    ControlToValidate="txtPswd2" ErrorMessage="两次密码不一致" Font-Size="10pt"></asp:CompareValidator>
            </td>
            <td style="color: #000000; " class="auto-style17"></td>
        </tr>
        <tr style="font-size: 10pt; color: #000000">
            <td class="auto-style20"></td>
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
            <td class="auto-style21"></td>
            <td style="text-align: right" class="auto-style8">
                <span style="font-size: 10pt">年龄：</span></td>
            <td class="auto-style9">
                <asp:TextBox ID="txtAge" runat="server" Width="150px"></asp:TextBox></td>
            <td class="auto-style10"></td>
            <td class="auto-style11"></td>
        </tr>
        <tr>
            <td class="auto-style22"></td>
            <td style="width: 112px; height: 22px; text-align: right">
                <span style="font-size: 10pt">头像：</span></td>
            <td class="auto-style12" rowspan="2">
                <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
                <asp:UpdatePanel ID="UpdatePanel1" runat="server">
                    <ContentTemplate>
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
                        <asp:Image ID="imgUser" runat="server" ImageUrl="~/images/Photo/01.jpg" />
                    </ContentTemplate>
                </asp:UpdatePanel>
            </td>
            <td style="width: 255px; height: 22px"></td>
            <td style="width: 336px; height: 22px"></td>
        </tr>
        <tr>
            <td class="auto-style23"></td>
            <td style="width: 112px; height: 71px; text-align: right"></td>
            <td colspan="1" style="width: 255px; height: 71px; text-align: center"></td>
            <td colspan="1" style="width: 336px; height: 71px; text-align: left"></td>
        </tr>
        <tr>
            <td class="auto-style24"></td>
            <td style="width: 112px; text-align: right">
                <span style="font-size: 10pt">Email：</span></td>
            <td colspan="1" style="width: 159px; text-align: left">
                <asp:TextBox ID="txtEmail" runat="server" Width="150px"></asp:TextBox></td>
            <td colspan="1" style="width: 255px; text-align: left"></td>
            <td colspan="1" style="width: 336px; text-align: left"></td>
        </tr>
        <tr>
            <td class="auto-style25"></td>
            <td style="width: 112px; height: 23px; text-align: right">
                <span style="font-size: 10pt">联系地址：</span></td>
            <td colspan="1" style="width: 159px; height: 23px; text-align: left">
                <asp:TextBox ID="txtAddr" runat="server" Font-Size="10pt" Width="150px"></asp:TextBox></td>
            <td colspan="1" style="width: 255px; height: 23px; text-align: left"></td>
            <td colspan="1" style="width: 336px; height: 23px; text-align: left"></td>
        </tr>
        <tr>
            <td class="auto-style26"></td>
            <td style="width: 112px; height: 19px"></td>
            <td colspan="1" style="width: 159px; height: 19px; text-align: left"></td>
            <td colspan="1" style="width: 255px; height: 19px; text-align: left"></td>
            <td colspan="1" style="width: 336px; height: 19px; text-align: left"></td>
        </tr>
        <tr>
            <td class="auto-style27"></td>
            <td style="width: 112px; height: 37px"></td>
            <td colspan="1" style="width: 159px; height: 37px; text-align: left">&nbsp; &nbsp; &nbsp;
                <asp:Button ID="btnAdd" runat="server" OnClick="btnAdd_Click" Text="添加" />
                &nbsp;
                <asp:Button ID="btnCancel" runat="server" CausesValidation="False" OnClick="btnCancel_Click"
                    Text="取消" /></td>
            <td colspan="1" style="width: 255px; height: 37px; text-align: left"></td>
            <td colspan="1" style="width: 336px; height: 37px; text-align: left"></td>
        </tr>
        <tr>
            <td class="auto-style28"></td>
            <td style="width: 112px; height: 34px"></td>
            <td colspan="1" style="width: 159px; height: 34px; text-align: left"></td>
            <td colspan="1" style="width: 255px; height: 34px; text-align: left"></td>
            <td colspan="1" style="width: 336px; height: 34px; text-align: left"></td>
        </tr>
    </table>

</asp:Content>
