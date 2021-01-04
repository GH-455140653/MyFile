package practice;

class Country {
    //定义对象country
    int filed = 960;
    String name = "中国";
    String belongto = "Africa";
    static String lanuage = "chinese";

    //定义方法
    public static void speak() {
        System.out.println("中国官方语言是" + lanuage);
        System.out.println("外交以及其他重要国际场合通用语言为：");
    }

    public boolean happyness(String happy) {
        System.out.println("作为中国人幸福吗?" + happy);
        return true;
    }
}

class jiangsu extends Country {
    public final String character = "教育发达经济繁荣";

    public void boss() {
        System.out.println("祖国是：" + name);
    }

    public void speak(String word) {
        Country.speak();
        System.out.println("江苏省拥有自己的方言：" + word);
    }
}

class shanghai extends Country {
    public final String character = "魔都";

    public void boss() {
        System.out.println("祖国是：" + name);
    }

    public void speak(String word) {
        Country.speak();
        System.out.println("上海拥有自己的方言：" + word);
    }

}

class zijian {
    public static void main(String[] args) {
        jiangsu js = new jiangsu();
        js.speak("江苏方言");
    }
}