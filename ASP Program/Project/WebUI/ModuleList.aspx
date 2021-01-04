<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="ModuleList.aspx.cs" Inherits="WebUI.ModuleList" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="Server">
    <div style="text-align:center">
        <table align="center" class="style3">
        <tr>
            <td>版块名称:<asp:TextBox ID="txtName" runat="server"></asp:TextBox>
                <asp:Button ID="btnFind" runat="server" Text="查找" OnClick="btnFind_Click" />
                <asp:Button ID="btnSearch" runat="server" Text="添加" OnClick="btnSearch_Click" />
            </td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="lbShow" runat="server" Text="lbShow"></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                <asp:GridView ID="gvInfo" runat="server" AllowPaging="True" AutoGenerateColumns="False"
                    CellPadding="4" DataKeyNames="ModuleId" Font-Size="9pt" ForeColor="#333333" GridLines="None"
                    OnRowCommand="gvInfo_RowCommand" OnRowCreated="gvInfo_RowCreated" Width="654px" OnPageIndexChanging="gvInfo_PageIndexChanging" PageSize="3">
                    <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
                    <RowStyle BackColor="#F7F6F3" ForeColor="#333333" HorizontalAlign="Center" />
                    <Columns>
                        <asp:TemplateField HeaderText="选择">
                            <ItemTemplate>
                                <asp:CheckBox ID="checkBox1" runat="server" />
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:BoundField DataField="moduleID" HeaderText="moduleID" />
                        <asp:BoundField DataField="moduleName" HeaderText="板块名称" ReadOnly="True" />
                        <asp:BoundField DataField="buildDate" HeaderText="创建时间" />
                        <asp:TemplateField HeaderText="操作">
                            <ItemTemplate>
                                <asp:LinkButton ID="lnkbtnEdit" runat="server" CommandName="Edit">
                                <img src="images/edit.png" alt=""  />
                                编辑</asp:LinkButton>|
                                <asp:LinkButton ID="lnkbtnDel" runat="server" CommandName="Del">
                                    <img src="images/delete.png" alt=""  />                                
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
        <tr>
            <td class="auto-style1" style="padding: 0 0 0 10%">
                <asp:CheckBox ID="CheckBox2" runat="server" Text="全选" TextAlign="Left" OnCheckedChanged="CheckBox2_CheckedChanged" AutoPostBack="True" />
                <asp:Button ID="btnDelete" runat="server" Text="删除" OnClick="btnDelete_Click" />
            </td>
        </tr>
    </table>
    </div>
</asp:Content>
