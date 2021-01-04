<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Module_Edit.aspx.cs" Inherits="WebUI.Module_Edit" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table align="center" border="0" cellpadding="0" cellspacing="0" class="TableCss"
        style="width: 794px; height: 185px">
        <tr>
            <td colspan="1" style="font-size: 14pt; width: 311px; height: 31px">
            </td>
            <td colspan="2" style="font-size: 14pt; height: 31px; text-align: center">
                <br />
                <span style="color: #0033ff; font-family: 仿宋_GB2312"></span>
            </td>
            <td colspan="1" style="font-size: 14pt; width: 336px; height: 31px">
            </td>
        </tr>
        <tr>
            <td style="width: 311px">
            </td>
            <td style="width: 82px; text-align: right">
                <span style="font-size: 10pt">版块名称：</span></td>
            <td style="width: 170px">
                <asp:TextBox ID="txtName" runat="server" Font-Size="10pt"></asp:TextBox></td>
            <td style="width: 336px; text-align: left">
                <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="txtIntro"
                    ErrorMessage="*请输入版块名称"></asp:RequiredFieldValidator></td>
        </tr>
        <tr style="color: #000000">
            <td style="width: 311px; height: 30px">
            </td>
            <td style="width: 82px; height: 30px; text-align: right">
                <span style="font-size: 10pt">版块介绍：</span></td>
            <td style="width: 170px; height: 30px">
                <asp:TextBox ID="txtIntro" runat="server" Height="96px" TextMode="MultiLine"></asp:TextBox>&nbsp;</td>
            <td style="width: 336px; height: 30px">
            </td>
        </tr>
        <tr>
            <td style="width: 311px">
            </td>
            <td style="width: 82px">
            </td>
            <td colspan="1" style="width: 170px; text-align: left">
                &nbsp; &nbsp; &nbsp;
                <asp:Button ID="btnAdd" runat="server" CssClass="ButtonCss" OnClick="btnAdd_Click"
                    Text="修改" />
                &nbsp;
                <asp:Button ID="btnCancel" runat="server" CausesValidation="False" CssClass="ButtonCss"
                    OnClick="btnCancel_Click" Text="取消" /></td>
            <td colspan="1" style="width: 336px; text-align: left">
            </td>
        </tr>
        <tr>
            <td style="width: 311px; height: 34px">
            </td>
            <td style="width: 82px; height: 34px">
            </td>
            <td colspan="1" style="width: 170px; height: 34px; text-align: left">
            </td>
            <td colspan="1" style="width: 336px; height: 34px; text-align: left">
            </td>
        </tr>
    </table>
</asp:Content>
