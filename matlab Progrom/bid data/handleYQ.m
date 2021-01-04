clc,clear
yqdata()
new=yq.new;%获取当日新增
country=yq.country;%获取国家
bar(new,0.5,'g');
set(gca,'xticklabel',get(gca,'xtick'),'yticklabel',get(gca,'ytick'));
set(gca,'XTickLabel',country);
set(gca,'XTick',[1:length(country)]);
set(gcf,'unit','centimeters','position',[1,2,40,15])
legend('各国新增对比图')
xlabel('国家');
ylabel("新增人数");

