<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="PostInfo.aspx.cs" Inherits="WebUI.PostInfo" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table align="center" border="0" cellpadding="0" cellspacing="0" style="font-size: 10pt">
        <tr>
            <td colspan="5" rowspan="1" style="width: 794px; height: 8px; text-align: center"></td>
        </tr>
        <tr>
            <td rowspan="2" style="border-right: #0099cc thin solid; border-top: #0099cc thin solid; border-left: #0099cc thin solid; width: 160px; border-bottom: #0099cc thin solid; height: 148px; text-align: center">发帖人信息<br />
                <asp:Image ID="imgUser" runat="server" ImageUrl="~/images/photo/01.jpg" />
                <br />
                <br />
                <asp:Label ID="lbUserName" runat="server"></asp:Label></td>
            <td style="border-right: #0099cc thin solid; border-top: #0099cc thin solid; border-left-width: thin; border-left-color: #0099cc; width: 374px; border-bottom: #0099cc thin solid; height: 23px; text-align: left">&nbsp;<asp:Label ID="lbPostTitle" runat="server"></asp:Label></td>
            <td style="border-top: #0099cc thin solid; border-left-width: thin; border-left-color: #0099cc; width: 182px; border-bottom: #0099cc thin solid; height: 23px; border-right-width: thin; border-right-color: #0099cc">发表时间：<asp:Label ID="lbDateTime" runat="server"></asp:Label></td>
            <td colspan="2" style="border-right: #0099cc thin solid; border-top: #0099cc thin solid; border-left: #0099cc thin solid; width: 78px; border-bottom: #0099cc thin solid; height: 23px">
                <asp:LinkButton ID="LinkButton1" runat="server" Font-Underline="False" ForeColor="Black"
                    OnClick="LinkButton1_Click" Width="38px">回复</asp:LinkButton></td>
        </tr>
        <tr>
            <td colspan="4" style="border-top-width: thin; border-right: #0099cc thin solid; border-left-width: thin; border-left-color: #0099cc; vertical-align: top; width: 634px; border-top-color: #0099cc; border-bottom: #0099cc thin solid; height: 125px; text-align: left">&nbsp;
                <asp:Label ID="lbpostContent" runat="server"></asp:Label></td>
        </tr>
    </table>
    <br />
    <asp:DataList ID="datalistInfo" runat="server" Font-Bold="False" Font-Italic="False"
        Font-Overline="False" Font-Size="Smaller" Font-Strikeout="False" Font-Underline="False"
        OnDeleteCommand="datalistInfo_DeleteCommand">
        <ItemTemplate>
            <table border="0" cellpadding="0" cellspacing="0" class="TableCss" style="width: 794px; font-size: 10pt;">
                <tr>
                    <td rowspan="2" style="width: 160px; height: 148px; text-align: center; border-right: #0099cc thin solid; border-top: #0099cc thin solid; border-left: #0099cc thin solid; border-bottom: #0099cc thin solid;">回帖人信息<br />
                        <img src='images/photo/<%# GetPhoto(Convert.ToString(Eval("userId")))%>' />
                        <br />
                        <br />
                        <asp:Label ID="Label2" runat="server"><%# GetUserName(Convert.ToString(Eval("userId")))%></asp:Label></td>
                    <td style="width: 374px; height: 23px; text-align: left; border-right: #0099cc thin solid; border-top: #0099cc thin solid; border-left-width: thin; border-left-color: #0099cc; border-bottom: #0099cc thin solid;">&nbsp;回帖主题：<asp:Label ID="Label3" runat="server"><%# Eval("RevertTitle") %></asp:Label></td>
                    <td style="width: 182px; height: 23px; background-image: border-top: #0099cc thin solid; border-left-width: thin; border-left-color: #0099cc; border-bottom: #0099cc thin solid; border-right-width: thin; border-right-color: #0099cc; border-top: #0099cc thin solid;">回帖时间：<asp:Label ID="Label1" runat="server"><%#Eval("RevertDate") %></asp:Label></td>
                    <td colspan="2" style="height: 23px; width: 78px; border-right: #0099cc thin solid; border-top: #0099cc thin solid; border-left: #0099cc thin solid; border-bottom: #0099cc thin solid;">
                        <asp:LinkButton ID="lbtnDel" runat="server" CommandName="Delete">删除</asp:LinkButton></td>
                </tr>
                <tr>
                    <td colspan="4" style="vertical-align: top; text-align: left; height: 125px; width: 634px; border-top-width: thin; border-right: #0099cc thin solid; border-top-color: #0099cc; border-bottom: #0099cc thin solid; border-left-width: thin; border-left-color: #0099cc;">&nbsp; &nbsp;<%# Eval("RevertContent") %></td>
                </tr>
            </table>
        </ItemTemplate>
    </asp:DataList><br />
    <table cellpadding="0" cellspacing="0" style="width: 848px; height: 28px">
        <tr>
            <td style="font-size: 9pt; width: 800px; height: 31px; text-align: center">
                <asp:Label ID="lbError" runat="server" ForeColor="Red" Width="198px"></asp:Label></td>
        </tr>
        <tr>
            <td style="font-size: 9pt; width: 800px; height: 31px; text-align: right">&nbsp;<asp:Label ID="labcurrent" runat="server" Text="当前页码为："></asp:Label>[
                                <asp:Label ID="labPage" runat="server" Text="1"></asp:Label>
                ]
                                <asp:Label ID="labcount" runat="server" Text="总页码为："></asp:Label>
                [
                                <asp:Label ID="labBackPage" runat="server"></asp:Label>
                ]<asp:LinkButton ID="lnkbtnOne" runat="server" Font-Underline="False" ForeColor="Red"
                    OnClick="lnkbtnOne_Click">第一页</asp:LinkButton>
                <asp:LinkButton ID="lnkbtnUp" runat="server" Font-Underline="False" ForeColor="Red"
                    OnClick="lnkbtnUp_Click">上一页</asp:LinkButton>
                <asp:LinkButton ID="lnkbtnNext" runat="server" Font-Underline="False" ForeColor="Red"
                    OnClick="lnkbtnNext_Click">下一页</asp:LinkButton>
                <asp:LinkButton ID="lnkbtnBack" runat="server" Font-Underline="False" ForeColor="Red"
                    OnClick="lnkbtnBack_Click">最后一页</asp:LinkButton>
                &nbsp; &nbsp; &nbsp;
            </td>
        </tr>
    </table>

</asp:Content>
