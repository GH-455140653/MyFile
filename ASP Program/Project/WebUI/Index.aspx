<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="WebUI.Index" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table style="border-style: hidden; width: 100%; height: 100%">
        <tr>
            <td>
                <asp:DataList ID="dataListInfo" runat="server">
                    <ItemTemplate>
                        <table border="1" cellpadding="0" cellspacing="0" style="font-size: 10pt; width: 886px; text-align: center">
                            <tr>
                                <td rowspan="2" style="background-image: url(images/biaogezuo2.gif); width: 57px; height: 48px"></td>
                                <td style="background-image: url(images/biaogeshang.gif); vertical-align: top; width: 401px; height: 29px; text-align: left">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
                                    <a href='PostList.aspx?ModuleID=<%#Eval("ModuleID") %>'>
                                        <%# Eval("ModuleName") %>
                                    </a>
                                </td>
                                <td rowspan="2" style="background-image: url(images/biaogeyou.gif); width: 119px; height: 48px; text-align: left"></td>
                            </tr>
                            <tr>
                                <td style="background-image: url(images/biaogexia.gif); width: 401px; height: 19px; text-align: left">&nbsp; 
                                    <span style="font-size: 9pt"></span>
                                    <%# Eval("ModuleIntro") %>
                                </td>
                            </tr>
                        </table>
                    </ItemTemplate>
                </asp:DataList>
            </td>
        </tr>
    </table>
</asp:Content>
