<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="DeliverPost.aspx.cs" Inherits="WebUI.DeliverPost" %>

<%@ Register Assembly="FreeTextBox" Namespace="FreeTextBoxControls" TagPrefix="FTB" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="Server">
    <table cellpadding="0" cellspacing="0"
        style="border-top-width: thin; border-left-width: thin; font-size: 10pt; border-left-color: #0099ff; border-bottom-width: thin; border-bottom-color: #0099ff; width: 100%; border-top-color: #0099ff; border-right-width: thin; border-right-color: #0099ff">
        <tr>
            <td
                style="border-right: #00ccff thin solid; border-top: #00ccff thin solid; border-left: #00ccff thin solid; width: 250px; border-bottom: #00ccff thin solid; background-color: #e7f1f8"></td>
            <td
                style="border-right: #00ccff thin solid; border-top: #00ccff thin solid; border-left: #00ccff thin solid; border-bottom: #00ccff thin solid; background-color: #e7f1f8; text-align: left">标题：<asp:TextBox ID="txtTitle" runat="server" Width="300px"></asp:TextBox>
                主题不得超过35个字符 &nbsp; &nbsp;
                <br />
                &nbsp;<asp:Label ID="Label1" runat="server" Text="分类:"></asp:Label>
                &nbsp;
                <asp:DropDownList ID="ddList" runat="server">
                </asp:DropDownList>
            </td>
        </tr>
        <tr>
            <td style="border-right: #00ccff thin solid; border-top: #00ccff thin solid; border-left: #00ccff thin solid; width: 250px; border-bottom: #00ccff thin solid; height: 269px">
                <table border="0" cellpadding="0" cellspacing="0" class="TableCss"
                    style="width: 195px">
                    <tr>
                        <td style="height: 20px">发帖人信息</td>
                    </tr>
                    <tr>
                        <td style="height: 60px">
                            <asp:Image ID="imgPhoto" runat="server" Height="50px" Width="45px" />
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 22px">
                            <asp:Label ID="lbName" runat="server"></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 22px">Email：<asp:Label ID="lbEmail" runat="server"></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 22px">性别：<asp:Label ID="lbSex" runat="server"></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 22px">角色：<asp:Label ID="lbRole" runat="server"></asp:Label>
                        </td>
                    </tr>
                </table>
            </td>
            <td style="border-right: #00ccff thin solid; border-top: #00ccff thin solid; border-left: #00ccff thin solid; border-bottom: #00ccff thin solid; height: 269px; text-align: left">内容：<br />
                <FTB:FreeTextBox ID="FreeTextBox1" runat="Server" BackColor="AliceBlue" ButtonDownImage="False"
                    DownLevelCols="50" DownLevelRows="10" GutterBackColor="LightSteelBlue" Height="230px"
                    HtmlModeDefaultsToMonoSpaceFont="True" Language="zh-cn" SupportFolder="aspnet_client/FreeTextBox/"
                    ToolbarBackgroundImage="True" ToolbarLayout="ParagraphMenu,FontFacesMenu,FontSizesMenu,FontForeColorsMenu|Bold,Italic,Underline,Strikethrough;Superscript,Subscript,RemoveFormat|JustifyLeft,JustifyRight,JustifyCenter,JustifyFull;BulletedList,NumberedList,Indent,Outdent;CreateLink,Unlink,InsertImage,InsertRule|Cut,Copy,Paste;Undo,Redo,Print"
                    ToolbarStyleConfiguration="NotSet" Width="630px">
                </FTB:FreeTextBox>
            </td>
        </tr>
        <tr>
            <td style="width: 250px; background-color: #e7f1f8"></td>
            <td style="background-color: #e7f1f8; text-align: left">
                <asp:Button ID="Button1" runat="server" CssClass="button"
                    OnClick="Button1_Click" Text="提  交" />
            </td>
        </tr>
    </table>
</asp:Content>
