<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="exam_2.aspx.cs" Inherits="WebSite.exam_2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 60%;
            height: 193px;
        }
        .auto-style2 {
            text-align: center;
            height: 66px;
            font-size: x-large;
        }
        .auto-style3 {
            text-align: right;
            width: 113px;
        }
        .auto-style4 {
            text-align: right;
            height: 20px;
            width: 113px;
        }
        .auto-style5 {
            height: 20px;
            text-align: left;
        }
        .auto-style6 {
            height: 20px;
            width: 179px;
            text-align: left;
        }
        .auto-style7 {
            width: 179px;
            text-align: left;
        }
        .auto-style8 {
            text-align: right;
            width: 113px;
            height: 23px;
        }
        .auto-style9 {
            width: 179px;
            height: 23px;
            text-align: left;
        }
        .auto-style10 {
            height: 23px;
            text-align: left;
        }
        .auto-style12 {
            text-align: center;
        }
        .auto-style13 {
            text-align: left;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table align="center" class="auto-style1">
                <tr>
                    <td class="auto-style2" colspan="2">用户注册</td>
                    <td class="auto-style2">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style4">用户名：</td>
                    <td class="auto-style6">
                        <asp:TextBox ID="tb_name" runat="server" Width="169px"></asp:TextBox>
                    </td>
                    <td class="auto-style5">
                        <asp:RequiredFieldValidator ID="rfv_name" runat="server" ControlToValidate="tb_name" ErrorMessage="用户名不能为空" SetFocusOnError="True" Display="Dynamic">用户名不能为空</asp:RequiredFieldValidator>
                        <asp:RegularExpressionValidator ID="rev_name" runat="server" ControlToValidate="tb_name" Display="Dynamic" ErrorMessage="用户名必须以字母开头。长度在6-9位" SetFocusOnError="True" ValidationExpression="[a-zA-Z]\w{5,8}">用户名必须以字母开头。长度在6-9位</asp:RegularExpressionValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8">密码：</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="tb_pwd" runat="server" TextMode="Password" Width="169px"></asp:TextBox>
                    </td>
                    <td class="auto-style10">
                        <asp:RequiredFieldValidator ID="rfv_pwd" runat="server" ControlToValidate="tb_pwd" ErrorMessage="RequiredFieldValidator" SetFocusOnError="True" Display="Dynamic">密码不能为空</asp:RequiredFieldValidator>
                        <asp:RegularExpressionValidator ID="ref_pwd" runat="server" ControlToValidate="tb_pwd" ErrorMessage="RegularExpressionValidator" SetFocusOnError="True" ValidationExpression="\S{6}" Display="Dynamic">密码长度只能是6位</asp:RegularExpressionValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style3">确认密码：</td>
                    <td class="auto-style7">
                        <asp:TextBox ID="tb_pwd_sure" runat="server" TextMode="Password" Width="165px"></asp:TextBox>
                    </td>
                    <td class="auto-style13">
                        <asp:CompareValidator ID="cv_pwd_sure" runat="server" ControlToCompare="tb_pwd" ControlToValidate="tb_pwd_sure" ErrorMessage="CompareValidator" SetFocusOnError="True">两次密码输入不一致</asp:CompareValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8">性别：</td>
                    <td class="auto-style9">
                        <asp:DropDownList ID="ddl_sex" runat="server">
                            <asp:ListItem>请选择</asp:ListItem>
                            <asp:ListItem>男</asp:ListItem>
                            <asp:ListItem>女</asp:ListItem>
                        </asp:DropDownList>
                    </td>
                    <td class="auto-style10">
                        <asp:RequiredFieldValidator ID="rfv_sex" runat="server" ControlToValidate="ddl_sex" ErrorMessage="RequiredFieldValidator" InitialValue="请选择">请选择性别</asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8">邮箱：</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="tb_email" runat="server" Width="170px"></asp:TextBox>
                    </td>
                    <td class="auto-style10">
                        <asp:RegularExpressionValidator ID="rev_email" runat="server" ControlToValidate="tb_email" ErrorMessage="RegularExpressionValidator" SetFocusOnError="True" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*">邮箱输入格式有误</asp:RegularExpressionValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8">出生日期：</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="tb_bornDate" runat="server" TextMode="Date" Width="168px"></asp:TextBox>
                    </td>
                    <td class="auto-style10">
                        <asp:RangeValidator ID="rv_bornDate" runat="server" ControlToValidate="tb_bornDate" ErrorMessage="RangeValidator" MinimumValue="1900-1-1" SetFocusOnError="True" Type="Date"></asp:RangeValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8">毕业日期：</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="tb_graduateDate" runat="server" TextMode="Date" Width="171px"></asp:TextBox>
                    </td>
                    <td class="auto-style10">
                        <asp:CompareValidator ID="cv_graduateDate" runat="server" ControlToCompare="tb_bornDate" ControlToValidate="tb_graduateDate" ErrorMessage="CompareValidator" Operator="GreaterThanEqual" Type="Date">毕业日期应大于出生日期</asp:CompareValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8">身份证号：</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="tb_idNum" runat="server" Width="169px"></asp:TextBox>
                    </td>
                    <td class="auto-style10">
                        <asp:RegularExpressionValidator ID="rev_idNum" runat="server" ControlToValidate="tb_idNum" ErrorMessage="RegularExpressionValidator" SetFocusOnError="True" ValidationExpression="\d{17}[\d|X]|\d{15}">身份证位数为18位</asp:RegularExpressionValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style3">手机号：</td>
                    <td class="auto-style7">
                        <asp:TextBox ID="tb_tele" runat="server" Width="170px"></asp:TextBox>
                    </td>
                    <td class="auto-style13">
                        <asp:RegularExpressionValidator ID="rev_tele" runat="server" ControlToValidate="tb_tele" ErrorMessage="RegularExpressionValidator" ValidationExpression="1(3|4|5|6|7|8|9)\d{9}">手机号为11位数字</asp:RegularExpressionValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style12" colspan="2">
                        <asp:Button ID="btn_submit" runat="server" Height="42px" OnClick="btn_submit_Click" Text="提交" Width="62px" />
                        <asp:Button ID="btn_reset" runat="server" Height="42px" OnClick="btn_reset_Click" Text="重置" Width="64px" />
                    </td>
                    <td class="auto-style12">
                        &nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
