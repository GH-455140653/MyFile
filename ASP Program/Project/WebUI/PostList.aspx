<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="PostList.aspx.cs" Inherits="WebUI.PostList" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:DataList ID="dataListInfo" runat="server" Width="800px"
        OnDeleteCommand="dataListInfo_DeleteCommand">
        <ItemTemplate>
            <table border="0" cellpadding="0" cellspacing="0" class="TableCss" style="font-size: 10pt; width: 852px; height: 138px; border-right: #0099cc thin solid; border-top: #0099cc thin solid; border-left: #0099cc thin solid; border-bottom: #0099cc thin solid;">
                <tr>
                    <td style="background-image: url(images/titlemu_2.gif); width: 233px; height: 30px; border-top-width: thin; border-right: #0099cc thin solid; border-left: #0099cc thin solid; border-top-color: #0099cc; border-bottom: #0099cc thin solid;">&nbsp;<asp:Label ID="Label3" runat="server"><%# Eval("ModuleName")%></asp:Label>
                        --<a href='PostInfo.aspx?PostID=<%# Eval("PostID") %>'
                            style="font-size: 9pt; color: black; text-decoration: none">
                            <%#Eval("postTitle") %>
                        </a>
                    </td>
                    <td style="background-image: url(images/titlemu_2.gif); width: 233px; height: 30px; border-top-width: thin; border-right: #0099cc thin solid; border-left-width: thin; border-left-color: #0099cc; border-top-color: #0099cc; border-bottom: #0099cc thin solid;">发表时间：<asp:Label ID="Label1" runat="server"><%# Eval("postDate") %></asp:Label></td>
                    <td style="background-image: url(images/titlemu_2.gif); width: 233px; height: 30px; border-top-width: thin; border-right: #0099cc thin solid; border-left-width: thin; border-left-color: #0099cc; border-top-color: #0099cc; border-bottom: #0099cc thin solid;">发帖人：<asp:Label ID="Label2" runat="server"><%# Eval("UserName")%></asp:Label></td>
                    <td style="background-image: url(images/titlemu_2.gif); width: 233px; height: 30px; border-bottom: #0099cc thin solid;">
                        <a href='RevertPost.aspx?postID=<%# Eval("PostID") %>'
                            style="font-size: 9pt; color: black; text-decoration: none">回复&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a>

                        <asp:LinkButton ID="lbtnDel" runat="server" CommandName="Delete">删除</asp:LinkButton>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" style="vertical-align: top; width: 798px; height: 105px; text-align: left">&nbsp; &nbsp;<%# Eval("postContent") %></td>
                </tr>
            </table>
        </ItemTemplate>
    </asp:DataList>
    <table cellpadding="0" cellspacing="0" style="width: 848px; height: 28px">
        <tr>
            <td style="font-size: 9pt; width: 800px; height: 31px; text-align: center">
                <asp:Label ID="lbError" runat="server" ForeColor="Red" Width="352px"></asp:Label></td>
        </tr>
        <tr>
            <td style="font-size: 9pt; width: 800px; height: 31px; text-align: right">&nbsp;<asp:Label ID="labcurrent" runat="server" Text="当前页码为："></asp:Label>[
                                <asp:Label ID="labPage" runat="server" Text="1"></asp:Label>
                ]
                                <asp:Label ID="labcount" runat="server" Text="总页码为："></asp:Label>
                [<asp:Label ID="labCountPage" runat="server"></asp:Label>&nbsp;
                ] &nbsp;&nbsp;
                <asp:LinkButton ID="lnkbtnOne" runat="server" Font-Underline="False" ForeColor="Red"
                    OnClick="lnkbtnOne_Click">第一页</asp:LinkButton>
                <asp:LinkButton ID="lnkbtnUp" runat="server" Font-Underline="False" ForeColor="Red"
                    OnClick="lnkbtnUp_Click">上一页</asp:LinkButton>
                <asp:LinkButton ID="lnkbtnNext" runat="server" Font-Underline="False" ForeColor="Red"
                    OnClick="lnkbtnNext_Click">下一页</asp:LinkButton>
                <asp:LinkButton ID="lnkbtnBack" runat="server" Font-Underline="False" ForeColor="Red"
                    OnClick="lnkbtnBack_Click">最后一页</asp:LinkButton>

            </td>
        </tr>
    </table>
</asp:Content>
