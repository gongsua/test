package Test.Animal_01;

public class Zoo_main {
    public static void main(String[] args) {
        //new 를 통해 메모리에 Cat 인스턴스를 생성한다.
        //객체를 사용할려면 클래스를 기반으로 생성해야 한다.
        // new를 통해서 Cat이라는 클래스를 기반으로 새로운 객체를 생성한다.
        //Cat cat 은 Cat이라는 클래스에 있는 것들을 받을 변수를 선언하는 것이다.
        //그 변수라는 것은 cat 안에 new Cat 통해서 새로 생성된 객체에 대한 메모리 참조값만 넣는 것이다.
        Cat cat = new Cat();
        Dog dog = new Dog("솜이",9,"윤진");

        Human human = new Human();
        //.을 통해서 Class에 접근한다.
        cat.name = "땡글이";
        cat.age = 9;
        System.out.println("고양이의 이름은 " + cat.name);
        //dog는 private 로 선언했기 때문에 main에서 dog의 name 값을 가져올 수 없다
        //System.out.println("강아지의 이름은 " + dog.name);
        System.out.println("강아지 인스턴스 메모리 참조 값을 출력 : " + dog);
        //이를 위해 캡슐화를 이용한다. Getter, Setter 메서드를 사용하여 불러오도록한다.

    }
}
