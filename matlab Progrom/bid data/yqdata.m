%% 导入电子表格中的数据
% 用于从以下电子表格导入数据的脚本:
%
%    工作簿: D:\MyData\MyProgram\matlab Progrom\bid data\yiqingDATA.xlsx
%    工作表: Sheet1
%
% 由 MATLAB 于 2020-08-22 14:52:44 自动生成

%% 设置导入选项并导入数据
opts = spreadsheetImportOptions("NumVariables", 2);

% 指定工作表和范围
opts.Sheet = "Sheet1";
opts.DataRange = "A2:B21";

% 指定列名称和类型
opts.VariableNames = ["country", "new"];
opts.VariableTypes = ["string", "double"];

% 指定变量属性
opts = setvaropts(opts, "country", "WhitespaceRule", "preserve");
opts = setvaropts(opts, "country", "EmptyFieldRule", "auto");

% 导入数据
yq = readtable("D:\MyData\MyProgram\matlab Progrom\bid data\yiqingDATA.xlsx", opts, "UseExcel", false);


%% 清除临时变量
clear opts