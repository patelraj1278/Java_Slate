package javaconcepts.abstraction;

abstract class findarea {
    int length;
    int width;

    findarea (int a,int b){
        System.out.println("Hello from FindArea");
        this.length=a;
        this.width =b;
    }
    abstract int doublearea();
}

class volume extends findarea{

    int height;
    volume (int a,int b,int h) {
        super(a,b);
        this.height=h;
        System.out.println("Hello from Volume");
    }
    int doublearea() {
        return length * width * height;
    }
}

class Rectangle extends findarea {
    Rectangle (int a ,int b) {
        super(a,b);
        System.out.println("Hello from Rectangle");
    }
    int doublearea() {
        return length * length ;
    }
}

class Testabstract {
    public static void main(String [] args) {
        volume v1;
        Rectangle r1;
        v1=new volume(2,3,4);
        r1=new Rectangle(3,4);
        v1.doublearea();
        r1.doublearea();
        System.out.println("Volume Area :: " +v1.doublearea());
        System.out.println("Rectangle Area :: " +r1.doublearea());
    }
}