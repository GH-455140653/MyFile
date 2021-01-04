<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="RevertPost.aspx.cs" Inherits="WebUI.RevertPost" %>
<%@ Register TagPrefix="ftb" Namespace="FreeTextBoxControls" Assembly="FreeTextBox" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table cellpadding="0" cellspacing="0" style="border-top-width: thin; border-left-width: thin; font-size: 10pt; border-left-color: #0099ff; border-bottom-width: thin; border-bottom-color: #0099ff; width: 100%; border-top-color: #0099ff; border-right-width: thin; border-right-color: #0099ff">
        <tr>
            <td style="border-right: #00ccff thin solid; border-top: #00ccff thin solid; border-left: #00ccff thin solid; width: 250px; border-bottom: #00ccff thin solid; background-color: #e7f1f8"></td>
            <td style="border-right: #00ccff thin solid; border-top: #00ccff thin solid; border-left: #00ccff thin solid; border-bottom: #00ccff thin solid; background-color: #e7f1f8; text-align: left">帖子名称：<asp:Label ID="postName" runat="server"></asp:Label>
                &nbsp; &nbsp;<br />
                回复主题：<asp:TextBox ID="RevertName" runat="server" Width="455px"></asp:TextBox>
                &nbsp;
            </td>
        </tr>
        <tr>
            <td style="border-right: #00ccff thin solid; border-top: #00ccff thin solid; border-left: #00ccff thin solid; width: 250px; border-bottom: #00ccff thin solid; height: 269px">
                <table border="0" cellpadding="0" cellspacing="0" class="TableCss" style="width: 195px">
                    <tr>
                        <td style="height: 20px">发帖人信息</td>
                    </tr>
                    <tr>
                        <td style="height: 60px">
                            <asp:Image ID="imgPhoto" runat="server" Height="50px" ImageUrl="~/images/photo/01.gif"
                                Width="45px" /></td>
                    </tr>
                    <tr>
                        <td style="height: 22px">
                            <asp:Label ID="lbName" runat="server"></asp:Label></td>
                    </tr>
                    <tr>
                        <td style="height: 22px">Email：<asp:Label ID="lbEmail" runat="server"></asp:Label></td>
                    </tr>
                    <tr>
                        <td style="height: 22px">性别：<asp:Label ID="lbSex" runat="server"></asp:Label></td>
                    </tr>
                    <tr>
                        <td style="height: 22px">角色：<asp:Label ID="lbRole" runat="server"></asp:Label></td>
                    </tr>
                </table>
            </td>
            <td style="border-right: #00ccff thin solid; border-top: #00ccff thin solid; border-left: #00ccff thin solid; border-bottom: #00ccff thin solid; height: 269px; text-align: left">内容：<br />
                <ftb:freetextbox id="FreeTextBox1" runat="server" language="zh-cn" width="630px"></ftb:freetextbox>
            </td>
        </tr>
        <tr>
            <td style="width: 250px; background-color: #e7f1f8"></td>
            <td style="background-color: #e7f1f8; text-align: left">
                <asp:Button ID="Button1" runat="server" CssClass="button"
                    Text="提  交" OnClick="Button1_Click" />
            </td>
        </tr>
    </table>
</asp:Content>
