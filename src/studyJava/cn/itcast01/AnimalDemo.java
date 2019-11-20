package studyJava.cn.itcast01;

public class AnimalDemo {
    public static void main(String[] args) {
        //通过工厂类创造
//        Dog dd = AnimalFactory.createDog();
//        Cat cc = AnimalFactory.createCat();
//        dd.eat();
//        cc.eat();
        //工厂改进后
        Animal d = AnimalFactory.createAnimal("dog");
        d.eat();
        d=AnimalFactory.createAnimal("cat");
        d.eat();
        d=AnimalFactory.createAnimal("pig");
        if(d!=null){
            d.eat();
        }else {
            System.out.println("对不起，暂时没有这种动物");
        }
    }
}
