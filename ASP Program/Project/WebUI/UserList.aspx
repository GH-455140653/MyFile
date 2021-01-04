<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeFile="UserList.aspx.cs" CodeBehind="UserList.aspx.cs" Inherits="WebUI.UserList" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
        <table align="center" border="0" cellpadding="0" cellspacing="0" class="TableCss"
        style="background-image: url(../Images/大背景.gif); width: 812px; height: 362px">
        <tr>
            <td style="width: 812px; height: 20px">
                <br />
                <span style="font-size: 10pt">
                    <table style="width: 790px">
                        <tr>
                            <td style="width: 25%; height: 26px; text-align: right;">
                                用户名：</td>
                            <td style="width: 25%; height: 26px; text-align: left;">
                                <asp:TextBox ID="txtName" runat="server"></asp:TextBox></td>
                            <td style="width: 25%; height: 26px; text-align: right;">
                                性别：</td>
                            <td style="width: 25%; height: 26px; text-align: left;">
                                <asp:RadioButton ID="rdbtnBoy" runat="server" GroupName="a" Text="男" />
                                <asp:RadioButton ID="rdbtnGirl" runat="server" GroupName="a" Text="女" />
                                <asp:RadioButton ID="RadioButton1" runat="server" Text="未选" GroupName="a" /></td>
                        </tr>
                        <tr>
                            <td style="width: 25%; text-align: right;">
                                角色：</td>
                            <td style="width: 25%; text-align: left;">
                                <asp:DropDownList ID="ddlRole" runat="server">
                                    <asp:ListItem Value="5">--请选择--</asp:ListItem>
                                    <asp:ListItem Value="0">管理员</asp:ListItem>
                                    <asp:ListItem Value="1">会员</asp:ListItem>
                                    <asp:ListItem Value="2">版主</asp:ListItem>
                                </asp:DropDownList></td>
                            <td style="width: 25%">
                                </td>
                            <td style="width: 25%">
                                </td>
                        </tr>
                    </table>
                </span>
                <asp:Button ID="btnFind" runat="server" CssClass="ButtonCss" Font-Size="10pt" OnClick="btnFind_Click"
                    Text="查找" />&nbsp;
            </td>
        </tr>
        <tr>
            <td style="vertical-align: top; width: 812px; height: 251px; text-align: center">
                <asp:Label ID="lbShow" runat="server" ForeColor="Red"></asp:Label><br />
                <br />
                <asp:GridView ID="gvInfo" runat="server" AllowPaging="True" AutoGenerateColumns="False"
                    CellPadding="4" DataKeyNames="userId" Font-Size="9pt" ForeColor="#333333" GridLines="None"
                    OnRowCommand="gvInfo_RowCommand" OnRowCreated="gvInfo_RowCreated" Width="654px" OnPageIndexChanging="gvInfo_PageIndexChanging" PageSize="3">
                    <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                    <RowStyle BackColor="#F7F6F3" ForeColor="#333333" HorizontalAlign="Center" />
                    <Columns>
                        <asp:BoundField DataField="UserName" HeaderText="用户名" ReadOnly="True" />
                        <asp:BoundField DataField="UserAge" HeaderText="年龄" />
                        <asp:BoundField DataField="UserSex" HeaderText="性别" />
                        <asp:BoundField DataField="userEmail" HeaderText="Email" />
                        <asp:BoundField DataField="userAddress" HeaderText="详细地址" />
                        <asp:TemplateField HeaderText="角色">
                            <ItemTemplate>
                                <asp:Label ID="Label1" runat="server" Text='<%#getRole(Convert.ToString(Eval("userRole"))) %>'></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:TemplateField HeaderText="操作">
                            <ItemTemplate>
                                <asp:LinkButton ID="lnkbtnEdit" runat="server" CommandName="Edit">
                                <img src="images/up.gif" alt=""  />
                                编辑</asp:LinkButton>|
                                <asp:LinkButton ID="lnkbtnDel" runat="server" CommandName="Del">
                                    <img src="images/del.gif" alt=""  />                                
                                    删除</asp:LinkButton>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                    <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Right" />
                    <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
                    <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                    <EditRowStyle BackColor="#999999" />
                    <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
                </asp:GridView>
            </td>
        </tr>
    </table>
</asp:Content>
