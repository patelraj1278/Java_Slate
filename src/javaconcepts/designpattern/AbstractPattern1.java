package javaconcepts.designpattern;

/*
Step 1
        Create an interface for Shapes.
 */
interface Shape1 {
    void draw();
}

/*
Step 2
        Create concrete classes implementing the same interface.
 */
class RoundedRectangle implements Shape1 {
    @Override
    public void draw() {
        System.out.println("Inside RoundedRectangle::draw() method.");
    }
}


class RoundedSquare implements Shape1 {
    @Override
    public void draw() {
        System.out.println("Inside RoundedSquare::draw() method.");
    }
}

class Rectangle1 implements Shape1 {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

/*
Step 3
        Create an Abstract class to get factories for Normal and Rounded Shape Objects.

 */

abstract class AbstractFactory1 {
    abstract Shape1 getShape(String shapeType) ;
}


/*
Step 4
        Create Factory classes extending AbstractFactory to generate object of concrete class based on given information.
 */
class ShapeFactory1 extends AbstractFactory1 {
    @Override
    public Shape1 getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle1();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            //return new Square();
        }
        return null;
    }
}


class RoundedShapeFactory extends AbstractFactory1 {
    @Override
    public Shape1 getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        return null;
    }
}


/*
Step 5
        Create a Factory generator/producer class to get factories by passing an information such as Shape
 */
class FactoryProducer {
    public static AbstractFactory1 getFactory(boolean rounded){
        if(rounded){
            return new RoundedShapeFactory();
        }else{
            return new ShapeFactory1();
        }
    }
}

/*
Step 6
        Use the FactoryProducer to get AbstractFactory in order to get factories of concrete classes by passing an information such as type.

 */
class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //get shape factory
        AbstractFactory1 shapeFactory = FactoryProducer.getFactory(false);
        //get an object of Shape Rectangle
        Shape1 shape1 = shapeFactory.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        shape1.draw();
        //get an object of Shape Square
        Shape1 shape2 = shapeFactory.getShape("SQUARE");
        //call draw method of Shape Square
        shape2.draw();
        //get shape factory
        AbstractFactory1 shapeFactory1 = FactoryProducer.getFactory(true);
        //get an object of Shape Rectangle
        Shape1 shape3 = shapeFactory1.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        shape3.draw();
        //get an object of Shape Square
        Shape1 shape4 = shapeFactory1.getShape("SQUARE");
        //call draw method of Shape Square
        shape4.draw();

    }
}